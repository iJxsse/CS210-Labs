package Lab2;

/*
        Todo:
             Given ArraySearch code:
             Generate a random integer number and save it into variable,
             run linear search and binary search to find it.
             Time the execution using the function nanoTime().

        Output: n = 2_115_483_640;
             Target = 1970759982
             Output of linear search: 1970759982
             Time taken = 192ms
             Output of binary search: 1970759982
             Time taken = 0ms
 */

public class ArraySearch {

    // Linear Search Method
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Found at index i
            }
        }
        return -1; // Not Found
    }

    // Binary search - only if the array is sorted!
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // index of the middle element

            if (arr[mid] == target) {
                return mid; // element found
            } else if (arr[mid] < target) {
                left = mid + 1; // search in the right half
            } else {
                right = mid - 1; // search in the left half
            }
        }
        return -1; // element not found
    }



    public static void main(String[] args) {

        int n = 2_115_483_640;  // size of the array
        int min = 0;
        int range = n - min + 1;

        int rand = 0;
        for (int i = 0; i < 10; i++) {
            rand = (int) (Math.random() * range) + min;
        }

        System.out.println("Target = " + rand);

        int[] numbers = new int[n];  // create the empty array

        // populate the array with incremental numbers
        for (int i = 0; i < n; i++) {
            numbers[i] = i;
        }

        // Number to be searched
        int target = rand;

        // Linear search
        long startLinear = System.nanoTime(); // get starting time (linear)
        int index_linear = linearSearch(numbers, target);
        long endLinear = System.nanoTime();   // get end time (linear)
        System.out.println("Output of linear search: " + index_linear);
        System.out.println("Time taken = " + ((endLinear - startLinear)) / 1000000 + "ms");

        // Binary search
        long startBinary = System.nanoTime(); // get starting time (binary)
        int index_binary = binarySearch(numbers, target);
        long endBinary = System.nanoTime(); // get end time (binary)
        System.out.println("Output of binary search: " + index_binary);
        System.out.println("Time taken = " + ((endBinary - startBinary)) / 1000000 + "ms");

    }
}
