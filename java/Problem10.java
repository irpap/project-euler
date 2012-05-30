public class Problem10 {

    public static void main(String args[]) {
        System.out.println(sumOfPrimesBelow(2000000));
    }

    public static long sumOfPrimesBelow(int n) {
        long sum = 0;
        boolean[] isPrime = new boolean[n+1];
        for (int i = 0; i < isPrime.length; i++) isPrime[i] = true;
        for (int j = 2; j < isPrime.length; j++) {
            int prime = j;
            if (!isPrime[prime]) continue;
            sum += prime;
            for (int i = prime * 2; i < isPrime.length; i = i + prime) isPrime[i] = false;
        }
        return sum;
    }
}
