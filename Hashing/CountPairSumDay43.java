import java.util.HashMap;

public class CountPairSumDay43 {

    // Function to count pairs with the given target sum
    int countPairs(int arr[], int target) {
        // HashMap to store the frequency of elements
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int num : arr) {
            // Check if the complement exists in the map
            int complement = target - num;
            if (map.containsKey(complement)) {
                count += map.get(complement); // Add the count of the complement
            }

            // Add the current number to the map
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        CountPairSumDay43 obj = new CountPairSumDay43();

        // Example array and target
        int[] arr = {1, 5, 7, -1, 5};
        int target = 6;

        // Output the result
        int result = obj.countPairs(arr, target);
        System.out.println("Number of pairs with sum " + target + ": " + result);

        // Additional test
        int[] arr2 = {1, 1, 1, 1};
        target = 2;
        result = obj.countPairs(arr2, target);
        System.out.println("Number of pairs with sum " + target + ": " + result);
    }
}
