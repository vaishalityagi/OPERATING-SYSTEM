import java.util.*;

public class DeadlockDetector {
    public static List<Integer> detectCycle(Map<Integer, List<Integer>> graph) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> recStack = new HashSet<>();

        for (Integer node : graph.keySet()) {
            if (dfs(node, graph, visited, recStack))
                return new ArrayList<>(recStack);
        }
        return null;
    }

    private static boolean dfs(int node, Map<Integer, List<Integer>> graph,
                               Set<Integer> visited, Set<Integer> recStack) {
        if (recStack.contains(node)) return true;
        if (visited.contains(node)) return false;

        visited.add(node);
        recStack.add(node);

        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            if (dfs(neighbor, graph, visited, recStack)) return true;
        }
        recStack.remove(node);
        return false;
    }
}
