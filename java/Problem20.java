import java.math.BigInteger;

/**
 * n! means n  (n  1)  ...  3  2  1
 * <p/>
 * For example, 10! = 10  9  ...  3  2  1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * <p/>
 * Find the sum of the digits in the number 100!
 */
public class Problem20 {
    public static void main(String[] args) {
        BigInteger n = BigInteger.ONE;
        for (int i = 1; i <= 100; i++) {
            n = n.multiply(new BigInteger(i + ""));
        }
        char[] digits = n.toString().toCharArray();
        int sum = 0;
        for (int d : digits) {
            sum += d-'0';
        }
        System.out.println("The sum of digits in 100! is: " + sum);
    }
}
