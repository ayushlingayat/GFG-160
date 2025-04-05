class Solution {
    // Directions: 8 possible directions around a cell
    int[] dx = {-1, -1, -1,  0, 0, 1, 1, 1};
    int[] dy = {-1,  0,  1, -1, 1, -1, 0, 1};

    void dfs(int row, int col, int m, int n, char[][] grid, boolean[][] visited) {
        visited[row][col] = true;

        // Check all 8 directions
        for (int i = 0; i < 8; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];

            // Check boundaries and if the cell is land and not visited
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n &&
                !visited[newRow][newCol] && grid[newRow][newCol] == 'L') {
                dfs(newRow, newCol, m, n, grid, visited);
            }
        }
    }

    public int countIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;

        // Traverse all cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If land and not visited, start DFS
                if (grid[i][j] == 'L' && !visited[i][j]) {
                    dfs(i, j, m, n, grid, visited);
                    count++; // one island completed
                }
            }
        }

        return count;
    }
}