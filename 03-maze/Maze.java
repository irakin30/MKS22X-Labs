import java.util.*;
import java.io.*;

public class Maze {
    private char[][] maze;
    private boolean animate;// false by default
    private int startRow, startCol;

    /*
     * Constructor loads a maze text file, and sets animate to false by default.
     * When the file is not found then:
     * throw a FileNotFoundException
     *
     * You may assume the file contains a rectangular ascii maze, made with the
     * following 4 characters:
     * '#' - Walls - locations that cannot be moved onto
     * ' ' - Empty Space - locations that can be moved onto
     * 'E' - the location of the goal if any (0 or more per file)
     * 'S' - the location of the start(exactly 1 per file)
     *
     * You may also assume the maze has a border of '#' around the edges.
     * So you don't have to check for out of bounds!
     * Some text editors always include a newline at the end of a file, but that is
     * not always present.
     * Make sure your file reading is able to handle this.
     */
    public Maze(String filename) throws FileNotFoundException {
        // COMPLETE CONSTRUCTOR
        animate = false;
        try {
            maze = toArray(filename);
            int[] temp = findStart(maze);
            startRow = temp[0];
            startCol = temp[1];
        }
        catch(FileNotFoundException e) {
            throw new FileNotFoundException("File Not Found");
        }
    }

    private int[] findStart(char[][] maze) {
        int[] start = new int[2];
        for(int row = 0; row < maze.length; row++) {
            for(int col = 0; col < maze[row].length; col++) {
                if(maze[row][col] == 'S') {
                    start[0] = row;
                    start[1] = col;
                    return start;
                }
            }
        }
        return start;
    }

    private char[][] toArray(String fileName) throws FileNotFoundException {
        char[][] result = new char[0][];
        try {
            File file = new File(fileName);
            Scanner input = new Scanner(file);
            ArrayList<char[]> array = new ArrayList<char[]>();
            while (input.hasNextLine()) {
                array.add((input.nextLine()).toCharArray());
            }
            result = array.toArray(result);
            input.close();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File Not Found");
        }
        return result;
    }

    private void wait(int millis) {
        try {
            Thread.sleep(millis);
        }
        catch (InterruptedException e) {
        }
    }

    public void setAnimate(boolean b) {
        animate = b;
    }

    public static void clearTerminal() {
        // erase terminal
        System.out.println("\033[2J");
    }

    public static void gotoTop() {
        // go to top left of screen
        System.out.println("\033[1;1H");
    }

    /*
     * Return the string that represents the maze.
     * It should look like the text file with some characters replaced.
     */
    public String toString() {
        String mazeString = "";
        for(char[] row : maze) {
            for(char col : row) {
                mazeString += col + " ";
            }
            mazeString += "\n";
        }
        return mazeString;
    }

    /*
     * Wrapper Solve Function returns the helper function
     * Note the helper function has the same name, but different parameters.
     * Since the constructor exits when the file is not found or is missing an E or
     * S, we can assume it exists.
     */
    public int solve() {
        // only clear the terminal if you are running animation
        if (animate) {
            clearTerminal();
        }
        // start solving at the location of the s.
        return solve(startRow, startCol);

    }

    /*
     * Recursive Solve function:
     *
     * A solved maze has a path marked with '@' from S to E.
     *
     * Returns the number of @ symbols from S to E when the maze is solved,
     * Returns -1 when the maze has no solution.
     *
     * Postcondition:
     * The 'S' is replaced with '@'
     * The 'E' remain the same
     * All visited spots that were not part of the solution are changed to '.'
     * All visited spots that are part of the solution are changed to '@'
     */
    private int solve(int row, int col) { // you can add more parameters since this is private
        // automatic animation! You are welcome.
        if (animate) {
            gotoTop();
            System.out.println(this);
            wait(50);
        }
        char currentPosition = maze[row][col];
        int[][] directions = {new int[]{0, 1}, new int{0, -1}, new int{1, 0}, new int{-1. 0}}
        if (currentPostion == 'E') return 1;
        else {
            if currentPosition
        }


        return -1; // so it compiles
    }
}
