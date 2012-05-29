public class Problem4 {

    Integer largestPalindrome() {
        int largestPalindrome = 0;

        for (int i = 999; i >= 100; i--) {
            for (int j = i; j >= 100; j--) {
                int product = i * j;
                if (isPalindrome(product) && product > largestPalindrome) largestPalindrome = product;
            }
        }
        return largestPalindrome;
    }

    boolean isPalindrome(int a) {
        String s = String.valueOf(a);
        return isPalindrome(s);
    }

    private boolean isPalindrome(String s) {
        if (s.length() <= 1) return true;
        if (s.charAt(0) != s.charAt(s.length() - 1)) return false;
        return isPalindrome(s.substring(1, s.length() - 1));
    }
}