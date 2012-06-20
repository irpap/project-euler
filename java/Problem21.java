/**
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
 * If d(a) = b and d(b) = a, where a  b, then a and b are an amicable pair and each of a and b are called amicable numbers.
 * <p/>
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 * <p/>
 * Evaluate the sum of all the amicable numbers under 10000.
 */
public class Problem21 {

    public static void main(String[] args) {
        long answer = sumOfAmicablePairs(10000);
        System.out.println("The sum of all amicable pairs is " + answer); //account for counting each pair twice
    }

    private static int sumOfAmicablePairs(int upTo) {
        int answer = 0;
        for (int i = 1; i < upTo; i++) {
            int a = sumOfProperDivisors(i);
            int b = sumOfProperDivisors(a);
            if (a != b && i == b) {
                answer += a + b;
            }
        }
        return answer / 2;
    }

    public static int sumOfProperDivisors(int n) {
        int sum = 1;
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                sum += i + n / i;
                if (i * i == n) sum -= i; //correction for perfect squares
            }
        }
        return sum;
    }

}
