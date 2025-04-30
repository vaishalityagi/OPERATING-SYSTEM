import java.util.*;

public class BankersAlgorithm {
    public static boolean isSafe(List<Process> processes, int[] available) {
        int[] work = available.clone();
        boolean[] finish = new boolean[processes.size()];

        while (true) {
            boolean found = false;
            for (int i = 0; i < processes.size(); i++) {
                if (!finish[i]) {
                    Process p = processes.get(i);
                    boolean canAllocate = true;
                    for (int j = 0; j < work.length; j++) {
                        if (p.need[j] > work[j]) {
                            canAllocate = false;
                            break;
                        }
                    }
                    if (canAllocate) {
                        for (int j = 0; j < work.length; j++)
                            work[j] += p.allocation[j];
                        finish[i] = true;
                        found = true;
                    }
                }
            }
            if (!found) break;
        }

        for (boolean f : finish)
            if (!f) return false;

        return true;
    }
}
