/**
 * Calculating 40 choose 20
 */

public class Problem15b {
    public static int SIZE = 21;

    public static void main(String[] args) {
        long[][] triangle = pascalTriangle(SIZE * 2);
        long paths = centralBionomialCoeff(triangle, SIZE);
        System.out.println(paths);
    }

    public static long centralBionomialCoeff(long[][] triangle, int i) {
        return triangle[(i - 1) * 2][i - 1];
    }

    public static long[][] pascalTriangle(int n) {
        long[][] triangle = new long[n][];
        for (int i = 0; i < n; i++) {
            triangle[i] = new long[i + 1];
            triangle[i][0] = 1;
            triangle[i][i] = 1;
        }
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 1; j < triangle[i].length - 1; j++) {
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }
        }
        return triangle;
    }
}
