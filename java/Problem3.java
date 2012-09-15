public class Problem3 {

    public static void main(String[] args) {
        System.out.println(largestPrimeFactor());
    }

    public static int largestPrimeFactor() {
        long number = 600851475143L;
        final int sqrtOfNumber = (int) Math.sqrt(number);
        boolean[] isPrime1 = new boolean[sqrtOfNumber];
        for (int i1 = 0; i1 < isPrime1.length; i1++) isPrime1[i1] = true;
        for (int j = 2; j < isPrime1.length; j++) {
            int prime = j;
            if (!isPrime1[prime]) continue;
            for (int i1 = prime * 2; i1 < isPrime1.length; i1 = i1 + prime) isPrime1[i1] = false;
        }
        boolean[] isPrime = isPrime1;
        for (int i = isPrime.length - 1; i > 0; i--) {
            if (isPrime[i] && number % i == 0) return i;
        }
        return -1;
    }


}
