package Lab4;

/**
 *      Todo: A palindrome reads the same forwards and backwards (e.g., “madam”, “racecar”).
 *       Implement a recursive function to check if a string is a palindrome.
 */

public class RecursivePalindrome {

    public static boolean isPalindrome(String string) {

        if(string == null) {
            return false;
        }

        // Convert word to Lowercase
        string = string.toLowerCase();

        if(string.length() <= 1) {
            return true;
        }

        if(string.charAt(0) != string.charAt(string.length() - 1)) {
            return false;
        }

        return isPalindrome(string.substring(1, string.length() - 1));
    }

    public static void main(String[] args) {

        String word = "Racecar";

        System.out.println(isPalindrome(word));
    }
}
