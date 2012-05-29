public class Problem7 {

    public static void main(String args[]) {
        System.out.println(nthPrime(10001));
    }

    public static int nthPrime(int n) {
        int randomBigNumber = 20 * n;
        int primesFound = 0;
        boolean[] isPrime = new boolean[randomBigNumber];
        for (int i = 0; i < isPrime.length; i++) isPrime[i] = true;
        for (int j = 2; j < isPrime.length; j++) {
            int prime = j;
            if (!isPrime[prime]) continue;
            if (++primesFound == n) return prime;
            for (int i = prime * 2; i < isPrime.length; i = i + prime) isPrime[i] = false;
        }
        System.out.println("found only " + primesFound + " primes!");
        return -1;
    }
}
