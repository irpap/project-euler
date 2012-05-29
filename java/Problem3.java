public class Problem3 {

    private final long number = 600851475143L;
    private final int sqrtOfNumber = (int) Math.sqrt(number);

    public int largestPrimeFactor() {
        boolean[] isPrime = primes();
        for (int i = isPrime.length - 1; i > 0; i--) {
            if (isPrime[i] && number % i == 0) return i;
        }
        return -1;
    }

    public boolean[] primes() {
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
