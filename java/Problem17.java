import java.util.HashMap;

/**
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * <p/>
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
 */
public class Problem17 {

    private static HashMap<Integer, String> numbersToWords = populateNumbersMap();
    public static final String AND = " and ";

    private static HashMap<Integer, String> populateNumbersMap() {
        HashMap<Integer, String> nums = new HashMap<Integer, String>();
        nums.put(1, "one");
        nums.put(2, "two");
        nums.put(3, "three");
        nums.put(4, "four");
        nums.put(5, "five");
        nums.put(6, "six");
        nums.put(7, "seven");
        nums.put(8, "eight");
        nums.put(9, "nine");
        nums.put(10, "ten");
        nums.put(11, "eleven");
        nums.put(12, "twelve");
        nums.put(13, "thirteen");
        nums.put(14, "fourteen");
        nums.put(15, "fifteen");
        nums.put(16, "sixteen");
        nums.put(17, "seventeen");
        nums.put(18, "eighteen");
        nums.put(19, "nineteen");
        nums.put(20, "twenty");
        nums.put(30, "thirty");
        nums.put(40, "forty");
        nums.put(50, "fifty");
        nums.put(60, "sixty");
        nums.put(70, "seventy");
        nums.put(80, "eighty");
        nums.put(90, "ninety");
        nums.put(100, "hundred");
        nums.put(1000, "thousand");

        return nums;
    }

    public static String wordForNumber(int n) {
        if (n == 1000)
            return wordForNumber(n / 1000) + " " + numbersToWords.get(1000);
        if (n / 100 > 0)
            return wordForNumber(n / 100) + " " + numbersToWords.get(100) + ((n % 100 == 0) ? "" : AND + wordForNumber(n % 100));
        if (n > 20 && n < 100)
            return numbersToWords.get((n / 10) * 10) + " " + ((n % 10 == 0) ? "" : numbersToWords.get(n % 10));
        if (n > 0 && n <= 20) return numbersToWords.get(n);
        return null;
    }

    public static void main(String[] args) {
        long lettersUsed = 0;
        for (int i = 1; i <= 1000; i++) {
            String word = wordForNumber(i);
            System.out.println(word);
            lettersUsed += word.replaceAll("\\s", "").length();
            System.out.println(word.replaceAll("\\s", "").length());
        }
        System.out.println(lettersUsed);
    }


}
