import java.math.BigInteger;

/**
 * 215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

 What is the sum of the digits of the number 2^1000?
 */
public class Problem16 {
    public static void main(String[] args){
        BigInteger result = new BigInteger("2").pow(1000);
        char[] digits = result.toString().toCharArray();
        long sum = 0;
        for (char d : digits) {
           sum += d-'0';
        }
        System.out.println("The sum of digits in 2^1000 is " + sum);
    }
}
