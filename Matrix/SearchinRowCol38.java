public class SearchinRowCol38 {

    // Function to search for a value in a matrix
    public static boolean matSearch(int mat[][], int x) {
        int n = mat.length; // Number of rows
        int m = mat[0].length; // Number of columns
        int i = 0, j = m - 1; // Start from the top-right corner

        // Traverse the matrix
        while (i < n && j >= 0) {
            if (x > mat[i][j]) {
                i++; // Move to the next row
            } else if (x < mat[i][j]) {
                j--; // Move to the previous column
            } else {
                return true; // Element found
            }
        }
        return false; // Element not found
    }

    public static void main(String args[]) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        int target = 10;

        System.out.println("Searching for " + target + " in the matrix:");
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        boolean found = matSearch(matrix, target);
        if (found) {
            System.out.println("Element " + target + " is present in the matrix.");
        } else {
            System.out.println("Element " + target + " is not present in the matrix.");
        }
    }
}
