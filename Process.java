public class Process {
    public int id;
    public int[] allocation;
    public int[] max;
    public int[] need;

    public Process(int id, int[] allocation, int[] max) {
        this.id = id;
        this.allocation = allocation;
        this.max = max;
        this.need = new int[max.length];
        for (int i = 0; i < max.length; i++) {
            this.need[i] = max[i] - allocation[i];
        }
    }
}
