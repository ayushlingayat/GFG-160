import java.util.*;

public class MinimizetheHeightsDay9 {

    int getMinDiff(int[] arr, int k) {
        int n = arr.length;
        if (n == 1) {
            return 0;  // If there's only one element, the difference is 0
        }

        // Sort the array
        Arrays.sort(arr);

        // Initial difference between the largest and smallest values
        int ans = arr[n - 1] - arr[0];

        // Consider the smallest and largest possible heights
        int smallest = arr[0] + k;
        int largest = arr[n - 1] - k;
        
        // Traverse through the array and calculate the minimum difference
        for (int i = 0; i < n - 1; i++) {
            int minHeight = Math.min(smallest, arr[i + 1] - k);
            int maxHeight = Math.max(largest, arr[i] + k);
            if (minHeight < 0) continue; // Skip negative heights
            ans = Math.min(ans, maxHeight - minHeight);
        }
        return ans;
    }

    public static void main(String[] args) {
        MinimizetheHeightsDay9 obj = new MinimizetheHeightsDay9();

        int[] arr = {1, 5, 8, 10};
        int k = 2;

        int result = obj.getMinDiff(arr, k);
        System.out.println("The minimum difference is: " + result);
    }
}
