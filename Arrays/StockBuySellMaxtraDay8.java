public class StockBuySellMaxtraDay8 {

    // Method to calculate the maximum profit
    public int maximumProfit(int prices[]) {
        int min = Integer.MAX_VALUE; // Initialize minimum price
        int ans = 0; // Initialize maximum profit

        for (int price : prices) {
            min = Math.min(min, price); // Update the minimum price
            ans = Math.max(ans, price - min); // Update the maximum profit
        }

        return ans; // Return the maximum profit
    }

    // Main method for testing
    public static void main(String[] args) {
        StockBuySellMaxtraDay8 solution = new StockBuySellMaxtraDay8();

        // Example test case
        int[] prices = {7, 1, 5, 3, 6, 4};
        int maxProfit = solution.maximumProfit(prices);

        // Output the result
        System.out.println("Maximum Profit: " + maxProfit); // Expected Output: 5
    }
}
