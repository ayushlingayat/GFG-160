import java.util.Arrays;

public class AggressiveCowsDay33 {

    // Function to find the largest minimum distance
    public static int aggressiveCows(int[] stalls, int k) {
        int n = stalls.length;
        int start = 1, end, mid, ans = 0;
        Arrays.sort(stalls);  // Sort the stalls array
        end = stalls[n - 1] - stalls[0]; // Maximum possible distance

        while (start <= end) {
            mid = start + (end - start) / 2; // Midpoint of the current range
            int count = 1, pos = stalls[0]; // Place the first cow in the first stall

            // Try to place the rest of the cows
            for (int i = 1; i < n; i++) {
                if (stalls[i] - pos >= mid) {
                    count++;
                    pos = stalls[i];
                }
            }

            // Check if we can place all cows with at least 'mid' distance
            if (count >= k) {
                ans = mid; // Update answer
                start = mid + 1; // Try for a larger minimum distance
            } else {
                end = mid - 1; // Try for a smaller minimum distance
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // Example input
        int[] stalls = {1, 2, 4, 8, 9}; // Stall positions
        int k = 3; // Number of cows

        // Calculate the largest minimum distance
        int result = aggressiveCows(stalls, k);

        // Print the result
        System.out.println("The largest minimum distance is: " + result);
    }
}
