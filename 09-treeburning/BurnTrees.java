import java.util.*;
public class BurnTrees {
    private Queue<int[]> frontier; 
    private int[][] map;
    private int ticks;
    private static final int TREE = 2;
    private static final int FIRE = 1;
    private static final int ASH = 3;
    private static final int SPACE = 0;
    private static final int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} }; 

    /** 
     * Determine if the simulation is still burning
     * 
     * @return false if any fires are still burning, true otherwise
     */
    public boolean done() {
        // YOU MUST IMPLEMENT THIS METHOD
        // (BEFORE WRITING ANY CODE READ ALL OF THE CODE AND SEE HOW IT FITS TOGETHER)
        // HINT: do not check the board for fire which is an n^2 operation 
        //my note: if there are no fires in the frontier, it can't spread so it's done.
        return frontier.isEmpty();
    }

    /** 
     * This is the core of the simulation. All of the logic for advancing to the
     * next round goes here.
     * All existing fires spread new fires, and turn to ash
     * new fires should remain fire, and not spread.
     */
    public void tick() {
        ticks++;// leave this here.
        // YOU MUST IMPLEMENT THE REST OF THIS METHOD
        // (BEFORE WRITING ANY CODE READ ALL OF THE CODE AND SEE HOW IT FITS TOGETHER) 
        for(int i = 0, e = frontier.size(); i < e; i++) {
            int[] current = frontier.remove();
            map[current[0]][current[1]] = ASH; 
            for(int[] dir : directions) {
                int currentR = current[0] + dir[0]; 
                int currentC = current[1] + dir[1]; 
                try {
                    if(map[currentR][currentC] == TREE) {
                        map[currentR][currentC] = FIRE; 
                        frontier.add(new int[] {currentR, currentC});
                    }
                }
                catch (ArrayIndexOutOfBoundsException f) 
                {/*ignore when it's not on the board*/} 
            }
        }
    }

    /*********************** YOU MIGHT UPDATE THIS **************************/

    /** 
     * Initialize the simulation.
     * If you add more instance variables you can add more here,
     * otherwise it is complete
     */
    public BurnTrees(int width, int height, double density) {
        frontier = new ArrayDeque<int[]>(); 
        map = new int[height][width];
        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[r].length; c++) {
                if (Math.random() < density) {
                    map[r][c] = TREE;
                }
            }
        }
        start();// set the left column on fire.
    }

    /** 
     * Sets the trees in the left column of the forest on fire
     */
    public void start() {
        // If you add more instance variables you can add more here,
        // otherwise it is complete.
        for (int i = 0; i < map.length; i++) {
            if (map[i][0] == TREE) {
                map[i][0] = FIRE;
                //add the new fires to the frontier
                frontier.add(new int[] {i , 0}); 
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Table 1:\n"); 
        printTable(100, 100, 0.05); 

        System.out.println("\nTable 2:\n"); 
        printTableFromRange(100, 100, 0.01, 0.6, 0.7);

        if (args.length > 1) {
            int WIDTH = Integer.parseInt(args[0]);
            int HEIGHT = Integer.parseInt(args[1]);
            double DENSITY = Double.parseDouble(args[2]);
            int DELAY = 200;
            if (args.length > 3) {
                DELAY = Integer.parseInt(args[3]);
            }
            BurnTrees b = new BurnTrees(WIDTH, HEIGHT, DENSITY);

            int ans = b.animate(DELAY);// animate all screens
            System.out.println(ans);// print the final answer

            // int ans = b.outputAll();//print all screens one after another
            // System.out.println(ans);//print the final answer
        }
    }

    /* Below this line, here are the required methods for the main function*/

    /**
     * Returns the average amount of ticks that trees burn for in n runs.
     * Warning: due to the the return type being a double, there are bound to be rounding errors.
     * @param n       - the amount of trials
     * @param size    - width of a square map
     * @param density - density of the trees
     * @return the average amount of ticks per run
     */
    public static double averageOfNRuns(int n, int size, double density) {
        int totalTicks = 0;
        for (int i = 0; i < n; i++) {
            totalTicks += new BurnTrees(size, size, density).run();
        }
        return (double) totalTicks / n;
    }

    public static void printTable(int n, int size, double densityInterval) {
        printTableFromRange(n, size, densityInterval, densityInterval, 1);
    }

    public static void printTableFromRange(int n, int size, double densityInterval, double start, double end) {
        for (double density = start; density < end; density += densityInterval) {
            System.out.printf("%d | %.2f | %.1f \n", size, density, averageOfNRuns(n, size, density));
        }
    }
    
    /***********************
     * DO NOT UPDATE THINGS BELOW HERE
     **************************/

    /*
     * DO NOT UPDATE THIS
     * PLEASE READ SO YOU SEE HOW THE SIMULATION IS SUPPOSED TO WORK!!!
     */
    public int run() {
        while (!done()) {
            tick();
        }
        return getTicks();
    }

    /* DO NOT UPDATE THIS */
    public int getTicks() {
        return ticks;
    }

    /* DO NOT UPDATE THIS */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            for (int c = 0; c < map[i].length; c++) {
                if (map[i][c] == SPACE)
                    builder.append(" ");
                else if (map[i][c] == TREE)
                    builder.append("@");
                else if (map[i][c] == FIRE)
                    builder.append("w");
                else if (map[i][c] == ASH)
                    builder.append(".");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    /* DO NOT UPDATE THIS */
    public String toStringColor() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            for (int c = 0; c < map[i].length; c++) {
                if (map[i][c] == 0)
                    builder.append(" ");
                else if (map[i][c] == 2)
                    builder.append(Text.color(Text.GREEN) + "@");
                else if (map[i][c] == 1)
                    builder.append(Text.color(Text.RED) + "w");
                else if (map[i][c] == 3)
                    builder.append(Text.color(Text.DARK) + ".");
            }
            builder.append("\n" + Text.RESET);
        }
        return builder.toString() + ticks + "\n";
    }

    /* DO NOT UPDATE THIS */
    public int animate(int delay) {
        System.out.print(Text.CLEAR_SCREEN);
        System.out.println(Text.go(1, 1) + toStringColor());
        Text.wait(delay);
        while (!done()) {
            tick();
            System.out.println(Text.go(1, 1) + toStringColor());
            Text.wait(delay);
        }
        return getTicks();
    }

    /* DO NOT UPDATE THIS */
    public int outputAll() {
        System.out.println(toString());
        while (!done()) {
            tick();
            System.out.println(toString());
        }
        return getTicks();
    }

}