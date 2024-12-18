import java.util.HashMap;
import java.util.Map;

public class NumberofOccurenceDay28 {

    int countFreq(int[] arr, int target) {
        // Create a hashmap to store frequencies
        Map<Integer, Integer> map = new HashMap<>();

        // Count occurrences of each element
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // Return the frequency of the target if it exists, otherwise 0
        return map.getOrDefault(target, 0);
    }

    public static void main(String args[]) {
        // Example usage of the countFreq method
        NumberofOccurenceDay28 obj = new NumberofOccurenceDay28();

        int[] arr = {1, 2, 3, 2, 4, 2, 5, 3};
        int target = 2;

        // Count occurrences of the target
        int result = obj.countFreq(arr, target);

        // Print the result
        System.out.println("Number of occurrences of " + target + ": " + result);
    }
}
