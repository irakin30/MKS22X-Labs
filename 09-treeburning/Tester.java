public class Tester {
    /**
     * Returns the average amount of ticks that trees burn for in n runs.
     * 
     * @param n       - the amount of trials
     * @param size    - width of a square map
     * @param density - density of the trees
     * @return the average amount of ticks per run
     */
    public static double averageOfNRuns(int n, int size, double density) {
        double totalTicks = 0;
        for (int i = 0; i < n; i++) {
            totalTicks += new BurnTrees(size, size, density).run();
        }
        return totalTicks / n;
    }

    public static void printTable(int n, int size, double densityInterval) {
        for (double density = densityInterval; density <= 1; density += densityInterval) {
            System.out.printf("Size: %d | Density: %.2f | Average Amount of Ticks: %.1f \n", size, density, averageOfNRuns(n, size, density));
        }
    }

    public static void main(String[] args) {
        printTable(1, 100, 0.05);
    }
}
