package Lab4;

/**
 *      Todo: Write a Java program to reverse a string using recursion.
 */

public class RecursiveStringReverse {

    public static String reverseString(String word) {

        if(word == null || word.length() <= 1) {
            return word;
        }


        return reverseString(word.substring(1)) + word.charAt(0);
    }

    public static void main(String[] args) {

        String word = "samsung";

        System.out.println(reverseString(word));
    }
}
