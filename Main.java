import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of resource types: ");
        int m = sc.nextInt();
        int[] available = new int[m];
        System.out.println("Enter available resources: ");
        for (int i = 0; i < m; i++) {
            available[i] = sc.nextInt();
        }

        ResourceManager manager = new ResourceManager(available);

        System.out.print("Enter the number of processes: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter data for Process " + i + ":");
            int[] allocation = new int[m];
            int[] max = new int[m];

            System.out.println("Enter allocation for Process " + i + ": ");
            for (int j = 0; j < m; j++) {
                allocation[j] = sc.nextInt();
            }

            System.out.println("Enter max requirement for Process " + i + ": ");
            for (int j = 0; j < m; j++) {
                max[j] = sc.nextInt();
            }

            manager.addProcess(new Process(i, allocation, max));
        }

        boolean safe = BankersAlgorithm.isSafe(manager.processes, available);
        System.out.println("Initial State is " + (safe ? "SAFE" : "UNSAFE"));

        System.out.print("Enter process ID for resource request: ");
        int pid = sc.nextInt();
        System.out.println("Enter the request for Process " + pid + ": ");
        int[] request = new int[m];
        for (int i = 0; i < m; i++) {
            request[i] = sc.nextInt();
        }

        boolean granted = manager.requestResources(pid, request);
        System.out.println("Request by P" + pid + " for resources: " + (granted ? "GRANTED" : "DENIED"));

        sc.close();
    }
}
