package Lab2;

/*
        Todo:
            Write a Java program that checks if an array is a palindrome.

        Output:
            12421 is a palindrome? : true
 */

public class ArrayPalindrome {

    public static boolean isPalindrome(String[] word) {

        int length = word.length;

        for(int i = 0; i < length / 2; i++) {
            // Continuously checks opposite elements
            if (!word[i].equals(word[length - 1 - i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String[] word = {"1", "2", "4", "2", "1"};
        for(String i : word) {
            System.out.print(i);
        }
        System.out.print(" is a palindrome? : " + isPalindrome(word));
    }
}
