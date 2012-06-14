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
import java.util.Map;
import java.util.Set;

public class Problem14 {
    static HashMap<Long, Long> lengths = new HashMap<Long, Long>(1000000);

    public static Long lengthOfChain(long n) {
        long next = n;
        long length = -1;
        if (n == 1) {
            lengths.put(1L, 1L);
            return 1L;
        }
        while (true) {
            length++;

            if (lengths.containsKey(next)) {

                lengths.put(n, length + lengths.get(next));
                return length + lengths.get(next);
            }
            if (next % 2 == 0) {
                next = next / 2;
            } else {
                next = 3 * next + 1;
            }
        }

    }

    private static void numberWithLongestChain(int limit) {
        long max = 0;
        for (int i = 1; i <= limit; i++) {
            Long length = lengthOfChain(i);
            if (length > max) max = length;
        }

        System.out.println("longest chain is " + max);
        Set<Map.Entry<Long, Long>> entries = lengths.entrySet();
        for (Map.Entry e : entries) {
            if ((Long) e.getValue() == max) {
                System.out.println("for key " + e.getKey());
                break;
            }

        }
    }

    public static void main(String[] args) {
        final long startTime = System.nanoTime();

        numberWithLongestChain(1000000);
        final long duration = System.nanoTime() - startTime;
        System.out.println(duration + "  ns");

    }


}
