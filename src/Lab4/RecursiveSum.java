package Lab4;

/**
 *      Todo: Write a recursive method that returns the sum of numbers from 1 to n.
 */

public class RecursiveSum {

    public static int recursiveSum(int num) {

        if(num <= 0) {
            return 0;
        }

        return num + recursiveSum(num - 1);
    }

    public static void main(String[] args) {

        int num = 10;

        System.out.println(recursiveSum(num));
    }
}
