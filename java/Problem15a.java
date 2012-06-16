import java.util.ArrayList;

public class Problem15a {
    static int WIDTH = 14;
    static int NUM_NODES = WIDTH * WIDTH;
    private static long paths = 0;

    public static void main(String[] args) {
        numberOfShortestPaths();
        System.out.println(paths + " paths");
    }

    public static void numberOfShortestPaths() {
        ArrayList<ArrayList<Integer>> adjacencyList = buildGraph();
        DFS(0, NUM_NODES - 1, adjacencyList);
    }

    public static void DFS(int start, int end, ArrayList<ArrayList<Integer>> adjacencyList) {
        if (start == end) {
            paths++;
            return;
        }
        for (int child : adjacencyList.get(start)) {
            DFS(child, end, adjacencyList);
        }
    }

    private static ArrayList<ArrayList<Integer>> buildGraph() {
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < NUM_NODES; i++) {
            int rowEnd = i + WIDTH - i % WIDTH - 1;

            ArrayList<Integer> l = new ArrayList<Integer>();
            if (i + WIDTH <= NUM_NODES - 1) l.add(i + WIDTH);
            if (i + 1 <= rowEnd) l.add(i + 1);

            adjacencyList.add(l);
        }
        return adjacencyList;
    }
}
