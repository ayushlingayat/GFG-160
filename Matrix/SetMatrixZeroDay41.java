import java.util.Arrays;

public class SetMatrixZeroDay41 {

    // Function to set matrix zeroes
    public void setMatrixZeroes(int[][] mat) {
        int n = mat.length;    // Number of rows
        int m = mat[0].length; // Number of columns

        int[] row = new int[n];
        int[] col = new int[m];

        // Initialize row and col arrays to track rows and columns with zero
        Arrays.fill(row, -1);
        Arrays.fill(col, -1);

        // Mark the rows and columns that need to be set to zero
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    row[i] = 0;
                    col[j] = 0;
                }
            }
        }

        // Set the elements to zero as needed
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] == 0 || col[j] == 0) {
                    mat[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 0, 6},
            {7, 8, 9}
        };

        SetMatrixZeroDay41 obj = new SetMatrixZeroDay41();

        System.out.println("Original Matrix:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }

        obj.setMatrixZeroes(matrix);

        System.out.println("Matrix after setting zeroes:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
