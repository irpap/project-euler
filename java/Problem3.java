import util.EulerHelper;

public class Problem3 {

    public static void main(String[] args) {
        System.out.println(largestPrimeFactor());
    }

    public static int largestPrimeFactor() {
        long number = 600851475143L;
        boolean[] isPrime = EulerHelper.primesUpTo(number);
        for (int i = isPrime.length - 1; i > 0; i--) {
            if (isPrime[i] && number % i == 0) return i;
        }
        return -1;
    }


}
