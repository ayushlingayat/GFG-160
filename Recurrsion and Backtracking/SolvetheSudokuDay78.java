public class SolvetheSudokuDay78 {
    
    boolean solveSudoku(int[][] mat) {
        for (int row = 0; row < 9; row++) { // Iterate through rows
            for (int col = 0; col < 9; col++) { // Iterate through columns
                if (mat[row][col] == 0) { // Find an empty cell
                    for (int num = 1; num <= 9; num++) { // Try numbers 1-9
                        if (isValid(mat, row, col, num)) { // Check if the number is valid
                            mat[row][col] = num; // Place the number

                            if (solveSudoku(mat)) { // Recursively solve
                                return true; 
                            } else {
                                mat[row][col] = 0; // Backtrack (reset the cell)
                            }
                        }
                    }
                    return false; // No valid number found for this cell
                }
            }
        }
        return true; // Sudoku is solved
    }

    // Helper function to check if a number is valid in a cell
    boolean isValid(int[][] mat, int row, int col, int num) {
        // Check row
        for (int i = 0; i < 9; i++) {
            if (mat[row][i] == num) {
                return false;
            }
        }

        // Check column
        for (int i = 0; i < 9; i++) {
            if (mat[i][col] == num) {
                return false;
            }
        }

        // Check 3x3 box
        int boxRowStart = row - row % 3;
        int boxColStart = col - col % 3;
        for (int i = boxRowStart; i < boxRowStart + 3; i++) {
            for (int j = boxColStart; j < boxColStart + 3; j++) {
                if (mat[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    // Function to print the Sudoku board
    void printSudoku(int[][] mat) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int[][] board = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        SolvetheSudokuDay78 solver = new SolvetheSudokuDay78();
        if (solver.solveSudoku(board)) {
            System.out.println("Solved Sudoku:");
            solver.printSudoku(board);
        } else {
            System.out.println("No solution exists.");
        }
    }
}
