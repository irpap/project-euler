package util;

public class EulerHelper {
    /**
     * A Sieve of Eratosthenes returning a boolean array such that if primes[i] == true then i is a prime
     */
    public static boolean[] primesUpTo(long number) {
        final int sqrtOfNumber = (int) Math.sqrt(number);
        boolean[] isPrime = new boolean[sqrtOfNumber];
        for (int i = 0; i < isPrime.length; i++) isPrime[i] = true;
        for (int j = 2; j < isPrime.length; j++) {
            int prime = j;
            if (!isPrime[prime]) continue;
            for (int i = prime * 2; i < isPrime.length; i = i + prime) isPrime[i] = false;
        }
        return isPrime;
    }
}