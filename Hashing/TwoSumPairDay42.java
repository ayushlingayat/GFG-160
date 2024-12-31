import java.util.HashSet;

public class TwoSumPairDay42 {

    // Function to find if there exists a pair with the given sum
    boolean twoSum(int arr[], int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            int ansElement = target - i;
            if (set.contains(ansElement)) {
                return true; // Pair found
            }
            set.add(i);
        }
        return false; // No pair found
    }

    public static void main(String[] args) {
        TwoSumPairDay42 obj = new TwoSumPairDay42();

        // Example array and target
        int[] arr = {2, 7, 11, 15};
        int target = 9;

        // Output the result
        boolean result = obj.twoSum(arr, target);
        if (result) {
            System.out.println("A pair with the given sum exists in the array.");
        } else {
            System.out.println("No pair with the given sum exists in the array.");
        }

        // Additional test
        target = 20;
        result = obj.twoSum(arr, target);
        if (result) {
            System.out.println("A pair with the given sum exists in the array.");
        } else {
            System.out.println("No pair with the given sum exists in the array.");
        }
    }
}
