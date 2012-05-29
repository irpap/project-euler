public class Problem1 {
    static int sumOfMultiples3And5UpTo1000() {
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0) sum += i;
        }
        return sum;
    }
}
