import java.util.Arrays;
import java.util.Collections;

/**
 * A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:
 * <p/>
 * 012   021   102   120   201   210
 * <p/>
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 */
public class Problem24 {
    public static void main(String[] args) {
        int[] first = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] next = first;

        for (int i = 0; i < 1000000; i++) {
            next = next(next);
            for (int j : next) {
                System.out.print(j);
            }
            System.out.println();
        }
//        for (int i : next) {
//            System.out.print(i);
//        }
    }

    static int[] next(int[] n) {

        int ms = ms(n); //the least significant digit which is followed by a larger even less significant digit
        int ls = ls(n, ms); // the immediately bigger digit with less significance than ms.
        if (ls == -1) return null; // no more permutations

        int tmp = n[ls];
        n[ls] = n[ms];
        n[ms] = tmp;

        Arrays.sort(n, ms + 1, n.length - 1);
        return n;

    }

    private static int ls(int[] n, int ms) {
        int minLarger = ms;
        for (int i = ms; i < n.length - 1; i++) {
            if (n[i] > n[ms] && n[i] < minLarger) minLarger = n[i];
        }
        return minLarger;
    }

    private static int ms(int[] n) {
        for (int i = n.length - 2; i > 0; i--) {
            for (int j = i; j < n.length - 1; j++) {
                if (j > i) return i;
            }
        }
        return -1;
    }
}
