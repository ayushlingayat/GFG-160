import java.util.*;

public class NQueenProblemDay77 {
    
    public List<List<Integer>> nQueen(int n) {
        List<List<Integer>> result = new ArrayList<>();
        solveNQueens(n, 0, new ArrayList<>(), result);
        return result;
    }

    private void solveNQueens(int n, int col, List<Integer> current, List<List<Integer>> result) {
        // Base case: If all queens are placed, add the solution
        if (col == n) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try placing the queen in each row of the current column
        for (int row = 1; row <= n; row++) {
            if (isSafe(row, col, current)) {
                current.add(row); // Place the queen
                solveNQueens(n, col + 1, current, result); // Recur for the next column
                current.remove(current.size() - 1); // Backtrack
            }
        }
    }

    private boolean isSafe(int row, int col, List<Integer> current) {
        // Check if the queen can be placed at (row, col)
        for (int i = 0; i < current.size(); i++) {
            int prevRow = current.get(i);
            int prevCol = i;

            // Check same row or diagonal conflicts
            if (prevRow == row || Math.abs(prevRow - row) == Math.abs(prevCol - col)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of N: ");
        int n = scanner.nextInt();
        
        NQueenProblemDay77 solver = new NQueenProblemDay77();
        List<List<Integer>> solutions = solver.nQueen(n);

        System.out.println("Total Solutions: " + solutions.size());
        for (List<Integer> solution : solutions) {
            System.out.println(solution);
        }

        scanner.close();
    }
}
