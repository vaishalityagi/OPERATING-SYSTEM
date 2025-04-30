import java.util.*;

public class ResourceManager {
    public List<Process> processes = new ArrayList<>();
    public int[] available;

    public ResourceManager(int[] available) {
        this.available = available.clone();
    }

    public void addProcess(Process p) {
        processes.add(p);
    }

    public boolean requestResources(int pid, int[] request) {
        Process p = processes.get(pid);

        for (int i = 0; i < request.length; i++) {
            if (request[i] > p.need[i] || request[i] > available[i])
                return false;
        }

        for (int i = 0; i < request.length; i++) {
            available[i] -= request[i];
            p.allocation[i] += request[i];
            p.need[i] -= request[i];
        }

        if (!BankersAlgorithm.isSafe(processes, available)) {
            for (int i = 0; i < request.length; i++) {
                available[i] += request[i];
                p.allocation[i] -= request[i];
                p.need[i] += request[i];
            }
            return false;
        }

        Map<Integer, List<Integer>> graph = buildWaitForGraph();
        List<Integer> cycle = DeadlockDetector.detectCycle(graph);

        if (cycle != null) {
            System.out.println("Deadlock detected among processes: " + cycle);
            for (int i = 0; i < request.length; i++) {
                available[i] += request[i];
                p.allocation[i] -= request[i];
                p.need[i] += request[i];
            }
            return false;
        }

        return true;
    }

    public Map<Integer, List<Integer>> buildWaitForGraph() {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (Process p1 : processes) {
            for (Process p2 : processes) {
                if (p1.id != p2.id) {
                    for (int i = 0; i < available.length; i++) {
                        if (p1.need[i] > available[i]) {
                            graph.computeIfAbsent(p1.id, k -> new ArrayList<>()).add(p2.id);
                            break;
                        }
                    }
                }
            }
        }
        return graph;
    }
}
