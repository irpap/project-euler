import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Same problem as 18 with larger input
 */
public class Problem76 {
    public static void main(String[] args) {
        String triangleString = readInput();
        int[][] triangle = Problem18.buildTringle(triangleString);
        int longestPath = Problem18.findLongestPath(triangle);
        System.out.println("longest path is " + longestPath);
    }

    private static String readInput() {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader("triangle.txt"));
            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line + "\n");
            }

        } catch (IOException e) {
            throw new RuntimeException("Something went wrong with the file reading", e);
        }
        return sb.toString();
    }
}
