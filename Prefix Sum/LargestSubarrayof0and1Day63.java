import java.util.HashMap;
import java.util.Map;

public class LargestSubarrayof0and1Day63 {
    public int maxLen(int[] arr) {
        int count = 0;
        int o = 0;
        // Create a HashMap to store the first occurrence of a given count
        Map<Integer, Integer> map = new HashMap<>();
        // Initialize with 0, because an equal number of 0's and 1's can start from the beginning
        map.put(0, -1);
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                o++;
            } else {
                o--;
            }
            
            // If the count has been seen before, calculate the length of the subarray
            if (map.containsKey(o)) {
                count = Math.max(count, i - map.get(o));
            } else {
                // Otherwise, store the first occurrence of the count
                map.put(o, i);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LargestSubarrayof0and1Day63 solution = new LargestSubarrayof0and1Day63();
        
        int[] arr1 = {0, 1, 0, 1, 0, 1, 1};
        System.out.println("Maximum length of subarray with equal number of 0s and 1s: " + solution.maxLen(arr1)); // Output: 6
        
        int[] arr2 = {1, 1, 1, 0, 0, 1, 0};
        System.out.println("Maximum length of subarray with equal number of 0s and 1s: " + solution.maxLen(arr2)); // Output: 6
        
        int[] arr3 = {0, 0, 1, 0, 1, 1, 1, 0};
        System.out.println("Maximum length of subarray with equal number of 0s and 1s: " + solution.maxLen(arr3)); // Output: 6
    }
}
