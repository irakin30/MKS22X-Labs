import java.io.File;
import java.io.FileNotFoundException;
public class Driver {
    public static void main(String[] args) {
        // files do not require an extension like .txt or .dat
        String filename = args[0];
        try {
            Maze f;
            f = new Maze(filename);
            f.setAnimate(true);
            System.out.println(f.solve());
            System.out.println(f);
        } catch (FileNotFoundException e) {
            System.out.println("Invalid filename: " + filename);
        }
    }
}
