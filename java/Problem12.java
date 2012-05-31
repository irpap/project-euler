public class Problem12 {
    public static void main(String[] args) {
        System.out.println(triangleNumberWith500Divisors());
    }

    public static int triangleNumberWith500Divisors() {
        for (int number = 0, n = 0; ; n++, number += n) {
            int divisors = 0;
            for (int i = 1; i < Math.sqrt(number); i++) {
                if (number % i == 0) divisors += 2;
            }
            if (divisors > 500) return number;
        }

    }
}
