import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TripletswithZeroSumDay44 {

    public List<List<Integer>> findTriplets(int[] arr) {
        // Map to store the indices of each number
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();

        // Populate the map with indices of each element
        for (int i = 0; i < arr.length; i++) {
            map.computeIfAbsent(arr[i], x -> new ArrayList<>()).add(i);
        }

        // Find all unique triplets that sum to zero
        for (int j = 1; j < arr.length - 1; j++) {
            for (int k = j + 1; k < arr.length; k++) {
                int sum = -1 * (arr[j] + arr[k]);

                if (map.containsKey(sum)) {
                    for (int i : map.get(sum)) {
                        if (i < j) { // Ensure uniqueness of indices
                            res.add(Arrays.asList(arr[i], arr[j], arr[k]));
                        }
                    }
                }
            }
        }

        return res;
    }

    public static void main(String args[]) {
        TripletswithZeroSumDay44 obj = new TripletswithZeroSumDay44();

        // Example array
        int[] arr = {0, -1, 2, -3, 1};

        // Find and print all triplets
        List<List<Integer>> result = obj.findTriplets(arr);
        System.out.println("Triplets with zero sum: ");
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }

        // Additional test case
        int[] arr2 = {3, -1, -7, 2, 4, 5, -2};
        result = obj.findTriplets(arr2);
        System.out.println("Triplets with zero sum: ");
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }
}
