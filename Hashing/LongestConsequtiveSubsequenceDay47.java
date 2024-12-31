import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsequtiveSubsequenceDay47 {

    public int longestConsecutive(int[] arr) {
        int maxi = 0; // Variable to store the maximum length of consecutive subsequence
        int n = arr.length;
        int l = 0; // Left pointer of the window
        int r = 0; // Right pointer of the window
        
        // Use a Set to store unique elements
        Set<Integer> hash = new HashSet<>();
        for (int num : arr) {
            hash.add(num);
        }

        // Convert set to array and sort
        Integer[] arr1 = hash.toArray(new Integer[0]);
        Arrays.sort(arr1);

        // Iterate through sorted array to find longest consecutive sequence
        while (r < arr1.length) {
            if (arr1[r] - arr1[l] != r - l) {
                l++;
            } else {
                maxi = Math.max(maxi, r - l);
            }
            r++;
        }

        return maxi + 1; // Add 1 as the sequence length includes both ends
    }

    public static void main(String args[]) {
        // Example Test Case
        LongestConsequtiveSubsequenceDay47 solution = new LongestConsequtiveSubsequenceDay47();
        
        // Test case 1
        int[] arr1 = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest Consecutive Subsequence Length (Test case 1): " + solution.longestConsecutive(arr1)); // Output: 4
        
        // Test case 2
        int[] arr2 = {0, -1, 1};
        System.out.println("Longest Consecutive Subsequence Length (Test case 2): " + solution.longestConsecutive(arr2)); // Output: 3
        
        // Test case 3
        int[] arr3 = {1, 9, 3, 10, 4, 20, 2};
        System.out.println("Longest Consecutive Subsequence Length (Test case 3): " + solution.longestConsecutive(arr3)); // Output: 4
    }
}
