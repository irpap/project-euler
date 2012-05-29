public class Problem2 {
    public static int sumOfEvenValuedFibValues() {
        int sum = 1;

        int first = 0;
        int second = 1;
        int next;
        while (true) {
            next = first + second;
            if (next > 4000000) return sum;
            if (next % 2 == 1) sum += next;
            first = second;
            second = next;
        }
    }
}
