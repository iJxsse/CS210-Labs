package Lab3;

/*
        Todo:
            1. Run all three algorithms for an array of size n = 1000.
            2. Count how many times a swap is performed in Bubble Sort and Selection Sort.
            (Note: Insertion Sort does not perform swaps.)
            3. Compare the results.
            4. Choose one of the three sorting algorithms and modify it so that it can sort an array
            of strings instead of integers.
 */

public class SortIntegers {

    // -------------------------
    // Bubble Sort
    // -------------------------
    static int bubbleCount = 0;
    static int selectionCount = 0;
    public static void bubbleSort(String[] sArr) {

        int n = sArr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sArr[j].compareTo(sArr[j + 1]) > 0) {
                    bubbleCount++;
                    String temp = sArr[j];
                    sArr[j] = sArr[j + 1];
                    sArr[j + 1] = temp;
                }
            }
        }
    }

    public static void bubbleSort(int[] arr) {

        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    bubbleCount++;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // -------------------------
    // Selection Sort
    // -------------------------
    public static void selectionSort(int[] arr) {

        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            selectionCount++;
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    // -------------------------
    // Insertion Sort
    // -------------------------
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // -------------------------
    // Utility functions
    // -------------------------
    public static void printArray(String[] arr) {
        for (String num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static String[] copyArray(String[] arr) {
        String[] copy = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }

    public static int[] copyArray(int[] arr) {
        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }

    // -------------------------
    // Main method
    // -------------------------
    public static void main(String[] args) {
        int n = 1000;

        int[] numbers = new int[n];
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = (int)(Math.random() * n);
        }

        String[] sArray = {"cat", "yacht", "grand", "scale", "spot", "escape", "bulk", "Greenland", "values", "communicate"};

        System.out.println("\nOriginal String array:");
        printArray(sArray);

        // Bubble Sort String
        bubbleCount = 0;
        String[] sortedArray = copyArray(sArray);
        bubbleSort(sortedArray);
        System.out.println("\nBubble Sort (String) (Swaps: " + bubbleCount + "):");
        printArray(sortedArray);

        System.out.println("\nOriginal int array:");
        printArray(numbers);

        // Bubble Sort
        bubbleCount = 0;
        int[] bubbleSorted = copyArray(numbers);
        bubbleSort(bubbleSorted);
        System.out.println("\nBubble Sort: (Swaps: " + bubbleCount + "):");
        printArray(bubbleSorted);

        // Selection Sort
        int[] selectionSorted = copyArray(numbers);
        selectionSort(selectionSorted);
        System.out.println("\nSelection Sort (Swaps: " + selectionCount + "):");
        printArray(selectionSorted);

        // Insertion Sort
        int[] insertionSorted = copyArray(numbers);
        insertionSort(insertionSorted);
        System.out.println("\nInsertion Sort:");
        printArray(insertionSorted);
    }
}