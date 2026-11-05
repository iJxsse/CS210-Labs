package Lab4;

/**
 *      Todo: Compute (a^n) using both recursive and iterative approaches, and compare their
 *       performance in terms of execution time.
 */

public class PowerFunction {

    //Recursive Approach
    public static long powerRecursive(long a, int n) {

        if(n == 0) {
            return 1;
        }

        return a * powerRecursive(a, n-1);
    }

    // Iterative Approach
    public static long powerIterative(long a, int n) {

        long result = 1;

        for(int i = 0; i < n; i++) {
            result *= a;
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 12000;
        long a = 2;

        long start = System.nanoTime();
        powerRecursive(a, n);
        long end = System.nanoTime();
        long recursiveTime = end - start;
        System.out.println("Recursive Time " + recursiveTime + " ns");

        start = System.nanoTime();
        powerIterative(a, n);
        end = System.nanoTime();
        long iterativeTime = end - start;
        System.out.println("Iterative Time " + iterativeTime + " ns");
    }
}
