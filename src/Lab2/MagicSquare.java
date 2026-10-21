package Lab2;
import java.util.Scanner;

/*
        Todo:
            Using 2-D arrays, write a program to check if a square matrix is a magic square.
            First ask the user to specify the size of the square and then ask to insert the numbers one by one.
            The program checks if the square is a magic square and writes a message on the screen.

            A magic square is a square matrix of size n × n where the sums of all rows, all
            columns, and both diagonals are equal.

        Output:
            For Lo Shu Square: 4 9 2
                               3 5 7
                               8 1 6

            Is square magic? true
 */

public class MagicSquare {

    public static boolean isMagicSquare(int[][] square) {

        // Sum to compare
        int targetSum = 0;

        for(int i = 0; i < square[0].length; i++) {
            targetSum += square[0][i];
        }

        // Rows Sum
        for(int row = 0; row < square[0].length; row++) {
            int rowSum = 0;
            for(int col = 0; col < square[row].length; col++) {
                rowSum += square[row][col];
            }
            if(rowSum != targetSum) {
                return false;
            }
        }

        // Columns Sum
        for(int col = 0; col < square[0].length; col++) {
            int colSum = 0;
            for(int row = 0; row < square[col].length; row++) {
                colSum += square[row][col];
            }
            if(colSum != targetSum) {
                return false;
            }
        }

        // Diagonals Sum
        int diagSum = 0;
        int antiDiagSum = 0;
        for(int diag = 0; diag < square.length; diag++) {
            diagSum += square[diag][diag];
            antiDiagSum += square[diag][square.length - 1 - diag];
        }

        return diagSum == targetSum && antiDiagSum == targetSum;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // Size of Matrix
        System.out.print("Enter size of Matrix (n): ");
        int n = scan.nextInt();
        int[][] square = new int[n][n];

        // Populate Matrix
        for(int row = 0; row < square.length; row++) {
            for(int col = 0; col < square[row].length; col++) {
                System.out.print("Enter Element at row " + row + ", column " + col + ": ");
                square[row][col] = scan.nextInt();
            }
        }

        //  Display Matrix
        System.out.println("\nYou Entered:");
        for(int[] row : square) {
            for(int num : row) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }

        //  Output Result
        System.out.println("\nIs square magic? " + isMagicSquare(square));
    }
}
