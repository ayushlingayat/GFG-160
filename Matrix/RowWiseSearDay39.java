public class RowWiseSearDay39 {

    // Function to search for an element row by row
    public boolean searchRowMatrix(int[][] mat, int x) {
        for (int i = 0; i < mat.length; i++) { // Iterate over rows
            for (int j = 0; j < mat[i].length; j++) { // Iterate over columns
                if (mat[i][j] == x) { // Check if the element matches
                    return true;
                }
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

        RowWiseSearDay39 obj = new RowWiseSearDay39();

        System.out.println("Searching for " + target + " in the matrix:");
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        boolean found = obj.searchRowMatrix(matrix, target);
        if (found) {
            System.out.println("Element " + target + " is present in the matrix.");
        } else {
            System.out.println("Element " + target + " is not present in the matrix.");
        }
    }
}
