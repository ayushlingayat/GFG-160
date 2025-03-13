class Solution {
    // Function to return max value that can be put in knapsack of capacity W.
    static int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        int[][] dp = new int[n + 1][W + 1];
        
        // Build table dp[][] in bottom-up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    dp[i][w] = 0;
                else if (wt[i - 1] <= w)
                    // Maximum of (including the current item, excluding the current item)
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
                else
                    // If current item's weight is more than capacity, exclude it
                    dp[i][w] = dp[i - 1][w];
            }
        }
        
        return dp[n][W];
    }
}