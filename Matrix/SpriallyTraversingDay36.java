import java.util.ArrayList;

public class SpriallyTraversingDay36 {

    static class SpriallyTraverse {
        // Function to return a list of integers denoting spiral traversal of matrix.
        public ArrayList<Integer> spirallyTraverse(int mat[][]) {
            ArrayList<Integer> res = new ArrayList<>();
            int startRow = 0;
            int startCol = 0;
            int endRow = mat.length - 1;
            int endCol = mat[0].length - 1;

            while (startRow <= endRow && startCol <= endCol) {
                // Traverse from left to right across the top row
                for (int col = startCol; col <= endCol; col++) {
                    res.add(mat[startRow][col]);
                }
                startRow++;

                // Traverse from top to bottom along the rightmost column
                for (int row = startRow; row <= endRow; row++) {
                    res.add(mat[row][endCol]);
                }
                endCol--;

                // Traverse from right to left along the bottom row (if not already traversed)
                if (startRow <= endRow) {
                    for (int col = endCol; col >= startCol; col--) {
                        res.add(mat[endRow][col]);
                    }
                    endRow--;
                }

                // Traverse from bottom to top along the leftmost column (if not already traversed)
                if (startCol <= endCol) {
                    for (int row = endRow; row >= startRow; row--) {
                        res.add(mat[row][startCol]);
                    }
                    startCol++;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        // Example usage
        SpriallyTraverse obj = new SpriallyTraverse();
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        ArrayList<Integer> result = obj.spirallyTraverse(matrix);
        System.out.println("Spiral Traversal: " + result);
    }
}
