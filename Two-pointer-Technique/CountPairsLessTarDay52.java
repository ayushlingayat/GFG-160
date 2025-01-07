import java.util.Arrays;

public class CountPairsLessTarDay52 {
    int countPairs(int arr[], int target) {
        Arrays.sort(arr); // Sort the array
        int n = arr.length;
        int i = 0, j = n - 1;
        int cnt = 0;

        while (i < j) {
            if (arr[i] + arr[j] < target) {
                cnt += (j - i); // Count pairs with the current i
                i++; // Move the left pointer to the right
            } else {
                j--; // Move the right pointer to the left
            }
        }

        return cnt; // Return the count of pairs
    }

    public static void main(String args[]) {
        CountPairsLessTarDay52 countPairsInstance = new CountPairsLessTarDay52();
        
        // Example array and target
        int[] arr = {1, 3, 5, 2, 4, 6};
        int target = 8;

        // Call the countPairs method
        int result = countPairsInstance.countPairs(arr, target);

        // Print the result
        System.out.println("Number of pairs with sum less than " + target + ": " + result);
    }
}
