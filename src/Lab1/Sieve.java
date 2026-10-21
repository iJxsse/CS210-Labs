package Lab1;

/**
 * A Java implementation of the Lab1.Sieve of Eratosthenes algorithm.
 * This program finds all prime numbers up to a given number n.
 **/

/*
 *    Todo: Declare a new variable counter inside the sieve class,
 *       Increment with counter++,
 *       Run the program and print the value of the counter variable.
 *
 *       Using the Lab1.Sieve, I was required to verify, for
 *       each positive even number, if the Goldbach Conjecture is true and to print the output.
 *       The Goldbach Conjecture: Every even integer greater than 2 can be expressed as the sum of two prime numbers
 *
 *       Output(limit = 14):  Operations (counter): 8
 *                            Goldbach Partitions for 14:
 *                            14 = 3 + 11. 14 = 7 + 7.
 */

import java.util.Arrays;

public class Sieve {

    /*
     * Main method to demonstrate the Lab1.Sieve of Eratosthenes.
     */

    public static int counter = 0;

    public static boolean[] sieveOfEratosthenes(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        if(n >= 0) prime[0] = false;
        if(n >= 1) prime[1] = false;

        for (int p = 2; p <= Math.sqrt(n); p++) {

            // If prime[p] is still true, then it is a prime.
            if (prime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    prime[i] = false;
                    counter++;
                }
            }
        }
        return prime;
    }

    public static void main(String[] args) {

        int limit = 14; // Find prime numbers up to the value of the "limit" variable.
        boolean[] isPrime = sieveOfEratosthenes(limit);  //isPrime is an array of boolean, isPrime[n] = true if number n is prime
        System.out.println("Operations (counter): " + counter);

        /*
         * Goldbach Conjecture
         */

        System.out.println("\nGoldbach Partitions for " + limit + ":");

        if (limit > 2 && limit % 2 == 0){
            for (int i = 2; i <= limit / 2; i++) {
                if (isPrime[i] && isPrime[limit - i]) {
                    System.out.print(limit + " = " + i + " + " + (limit - i) + ". ");
                }
            }
        } else {
            System.out.println("Please enter an even number greater than 2");
        }
    }
}