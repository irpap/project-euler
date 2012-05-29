import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Problem5 {
    //What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
    Set factors(int n) {
        Set factors = new HashSet<Integer>();
        System.out.println("Factors");
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
                factors.add(i);
            }
        }
        return factors.isEmpty()? Collections.singleton(n) : factors;
    }

    int smallestNumber() {
        Set<Integer> allFactors = new HashSet<Integer>();
        for (int i = 2; i <= 20; i++) {
            allFactors.addAll(factors(i));
        }
        int product = 1;
        for (int i : allFactors) {
            product = product * i;
        }
        return product;
    }

}
