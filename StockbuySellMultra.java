public class StockbuySellMultra {

    public int maximumProfit(int[] prices) {
        // as soon as I get a dip, sell it on the previous of the current day
        int n = prices.length;
        int totalProfit = 0;
        int buy = 0;

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                // Initialize the first buy price
                buy = prices[i];
            } else if (prices[i] < prices[i - 1]) {
                // Found a dip, sell at the previous day's price
                totalProfit += prices[i - 1] - buy;
                // Update the buy price to the current day's price
                buy = prices[i];
            }
        }

        // Add the profit for the last segment, if any
        totalProfit += prices[n - 1] - buy;

        return totalProfit;
    }

    public static void main(String[] args) {
        StockbuySellMultra solution = new StockbuySellMultra();

        // Test case 1
        int[] prices1 = {1, 2, 3, 4, 5};
        System.out.println("Maximum Profit: " + solution.maximumProfit(prices1)); // Expected: 4

        // Test case 2
        int[] prices2 = {7, 1, 5, 3, 6, 4};
        System.out.println("Maximum Profit: " + solution.maximumProfit(prices2)); // Expected: 7

        // Test case 3
        int[] prices3 = {7, 6, 4, 3, 1};
        System.out.println("Maximum Profit: " + solution.maximumProfit(prices3)); // Expected: 0
    }
}
