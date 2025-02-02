class WordSearchDay79 {
    static public boolean isWordExist(char[][] mat, String word) {
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (search(mat, i, j, word, 0)) return true;
            }
        }
        return false;
    }

    private static boolean search(char[][] mat, int i, int j, String word, int idx) {
        int m = mat.length;
        int n = mat[0].length;
        if (idx == word.length()) return true;
        if (i < 0 || i >= m || j < 0 || j >= n || mat[i][j] != word.charAt(idx)) return false;
        
        char temp = mat[i][j];
        mat[i][j] = '#'; // Mark as visited
        
        boolean found = search(mat, i + 1, j, word, idx + 1) ||
                        search(mat, i - 1, j, word, idx + 1) ||
                        search(mat, i, j + 1, word, idx + 1) ||
                        search(mat, i, j - 1, word, idx + 1);
        
        mat[i][j] = temp; // Restore character
        return found;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        
        String word1 = "ABCCED";
        String word2 = "SEE";
        String word3 = "ABCB";
        
        System.out.println("Word '" + word1 + "' exists: " + isWordExist(board, word1));
        System.out.println("Word '" + word2 + "' exists: " + isWordExist(board, word2));
        System.out.println("Word '" + word3 + "' exists: " + isWordExist(board, word3));
    }
}
