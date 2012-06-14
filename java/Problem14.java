/*
The following iterative sequence is defined for the set of positive integers:

n  n/2 (n is even)
n  3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:

13  40  20  10  5  16  8  4  2  1
It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.
*/

import java.util.HashMap;

public class Problem14 {

    public static int chainLength(long n, HashMap<Long, Integer> lengths) {
        long next = n;
        int length = -1;
        while (true) {
            length++;
            if (lengths.containsKey(next)) {
                int l = length + lengths.get(next);
                lengths.put(n, l);
                return l;
            }
            if (next % 2 == 0) {
                next = next / 2;
            } else {
                next = 3 * next + 1;
            }
        }
    }

        private static void longestCollatzChain(int limit) {
        HashMap<Long, Integer> lengths = initialisedLengthsMap(limit);

        long candidate = 0;
        long max = 0;
        for (int i = 1; i <= limit; i++) {
            int length = chainLength(i, lengths);
            if (length > max) {
                max = length;
                candidate = i;
            }
        }
        System.out.println("longest chain is " + max + " for " + candidate);
    }

    private static HashMap<Long, Integer> initialisedLengthsMap(int limit) {
        HashMap<Long, Integer> lengths = new HashMap<Long, Integer>(limit);
        lengths.put(1L, 1);
        return lengths;
    }

    public static void main(String[] args) {
        final long startTime = System.nanoTime();
        longestCollatzChain(1000000);
        final long duration = System.nanoTime() - startTime;
        System.out.println(duration + "  ns");

    }


}
