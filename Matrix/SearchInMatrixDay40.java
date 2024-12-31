public class SearchInMatrixDay40 {

    // Function to search for an element in a row-column sorted matrix
    public boolean searchMatrix(int[][] mat, int x) {
        int m = mat.length; // Number of rows
        int n = mat[0].length; // Number of columns
        int i = 0, j = n - 1; // Start from the top-right corner

        // Traverse the matrix
        while (i < m && j >= 0) {
            if (mat[i][j] < x) {
                i++; // Move down
            } else if (mat[i][j] > x) {
                j--; // Move left
            } else {
                return true; // Element found
            }
        }
        return false; // Element not found
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 4, 7, 11},
            {2, 5, 8, 12},
            {3, 6, 9, 16},
            {10, 13, 14, 17}
        };

        int target = 5;

        SearchInMatrixDay40 obj = new SearchInMatrixDay40();

        System.out.println("Searching for " + target + " in the matrix:");
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        boolean found = obj.searchMatrix(matrix, target);
        if (found) {
            System.out.println("Element " + target + " is present in the matrix.");
        } else {
            System.out.println("Element " + target + " is not present in the matrix.");
        }
    }
}
