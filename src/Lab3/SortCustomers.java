package Lab3;

/*
        Todo:
            Using one of the three sorting algorithms of your choice, modify it to implement a
            function that can:
                1. Sort all customers by first name (ascending).
                2. Sort all customers by age (ascending).
                3. Sort all customers first by first name, and then by surname if the first names
                are the same.
 */

public class SortCustomers {

    static int bubbleCount = 0;
    static class Customer {

        String name;
        String surname;
        int age;

        Customer(String name, String surname, int age) {
            this.name = name;
            this.surname = surname;
            this.age = age;
        }

        @Override
        public String toString() {
            return name + " " + surname + " (" + age + ")";
        }
    }

    public static void sortByName(Customer[] cArr) {

        int n = cArr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (cArr[j].name.compareTo(cArr[j + 1].name) > 0) {
                    bubbleCount++;
                    Customer temp = cArr[j];
                    cArr[j] = cArr[j + 1];
                    cArr[j + 1] = temp;
                }
            }
        }
    }

    public static void sortByAge(Customer[] cArr) {

        int n = cArr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (cArr[j].age > cArr[j+1].age) {
                    bubbleCount++;
                    Customer temp = cArr[j];
                    cArr[j] = cArr[j + 1];
                    cArr[j + 1] = temp;
                }
            }
        }
    }

    public static void sortByNameAndSurname(Customer[] cArr) {

        int n = cArr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                int nameDiff = cArr[j].name.compareTo(cArr[j + 1].name);

                if (nameDiff > 0 || (nameDiff == 0 && cArr[j].surname.compareTo(cArr[j + 1].surname) > 0)) {
                    bubbleCount++;
                    Customer temp = cArr[j];
                    cArr[j] = cArr[j + 1];
                    cArr[j + 1] = temp;
                }
            }
        }
    }

    public static Customer[] copyArray(Customer[] arr) {
        Customer[] copy = new Customer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }

    public static void printArray(Customer[] arr) {
        for (Customer num : arr) {
            System.out.print("\n" + num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Customer[] customers = {
                new Customer("Bob", "Adams", 28),
                new Customer("Diana", "Clark", 35),
                new Customer("Diana", "Davis", 22),
                new Customer("Adam", "Smith", 51),
                new Customer("Mary", "Walsh", 18),
                new Customer("Adam", "Reed", 32),
                new Customer("Carl", "English", 29),
                new Customer("Bob", "Gates", 20)
        };

        System.out.println("\nOriginal Customer array:");
        printArray(customers);

        // Sorted by Name
        bubbleCount = 0;
        Customer[] sortedByName = copyArray(customers);
        sortByName(sortedByName);
        System.out.println("\nSorted by Name (Swaps: " + bubbleCount + "):");
        printArray(sortedByName);

        // Sort by Age
        bubbleCount = 0;
        Customer[] sortedByAge = copyArray(customers);
        sortByAge(sortedByAge);
        System.out.println("\nSorted by Age (Swaps: " + bubbleCount + "):");
        printArray(sortedByAge);

        // Sort by Name and Surname
        bubbleCount = 0;
        Customer[] sortedByNameAndSurname = copyArray(customers);
        sortByNameAndSurname(sortedByNameAndSurname);
        System.out.println("\nSorted by Name and Surname (Swaps: " + bubbleCount + "):");
        printArray(sortedByNameAndSurname);
    }
}
