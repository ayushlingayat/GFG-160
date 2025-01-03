import java.util.HashMap;

public class SubarraysumkDay49 {
    public int countSubarrays(int arr[], int k) {
        // Using a HashMap to store prefix sums
        HashMap<Integer, Integer> mp = new HashMap<>();
        int res = 0; // To store the count of subarrays
        int sum = 0; // To store the running sum

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // If the running sum is equal to k, increment the result
            if (sum == k) {
                res++;
            }

            // Check if there is a prefix sum that satisfies the condition
            if (mp.containsKey(sum - k)) {
                res += mp.get(sum - k);
            }

            // Update the HashMap with the current sum
            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        SubarraysumkDay49 solution = new SubarraysumkDay49();

        // Example array and target sum
        int[] arr = {1, 1, 1};
        int k = 2;

        // Call the method and print the result
        int result = solution.countSubarrays(arr, k);
        System.out.println("Number of subarrays with sum " + k + ": " + result);
    }
}
