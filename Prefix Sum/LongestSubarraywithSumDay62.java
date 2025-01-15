import java.util.HashMap;
import java.util.Map;

public class LongestSubarraywithSumDay62 {

    public int longestSubarray(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // Handle the case when the subarray starts from index 0
        int cur = 0, ans = 0, n = arr.length;
        
        for (int i = 0; i < n; i++) {
            cur += arr[i]; // Update the current sum
            // Check if there's a subarray sum that matches the required sum
            if (map.containsKey(cur - k)) {
                ans = Math.max(ans, i - map.get(cur - k));
            }
            // Only add current sum to the map if it doesn't already exist
            if (!map.containsKey(cur)) {
                map.put(cur, i);
            }
        }
        
        return ans;
    }

    public static void main(String[] args) {
        LongestSubarraywithSumDay62 solution = new LongestSubarraywithSumDay62();
        
        // Test case
        int[] arr = {1, -1, 5, -2, 3};
        int k = 3;
        
        int result = solution.longestSubarray(arr, k);
        System.out.println("Length of the longest subarray with sum " + k + ": " + result);
        
        // Additional test case
        int[] arr2 = {-2, -1, 2, 1};
        k = 1;
        
        int result2 = solution.longestSubarray(arr2, k);
        System.out.println("Length of the longest subarray with sum " + k + ": " + result2);
    }
}
