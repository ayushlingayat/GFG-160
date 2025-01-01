import java.util.HashSet;

public class PrintAnagramsTogetherDay48 {

    // Function to check if there are two numbers in the array that sum up to the target
    boolean twoSum(int arr[], int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            int ansElement = target - i;
            if (set.contains(ansElement)) {
                return true;
            }
            set.add(i);
        }
        return false;
    }

    public static void main(String args[]) {
        PrintAnagramsTogetherDay48 obj = new PrintAnagramsTogetherDay48();
        int[] arr = {2, 7, 11, 15}; // Example array
        int target = 9;            // Example target

        // Test the twoSum method
        boolean result = obj.twoSum(arr, target);
        if (result) {
            System.out.println("Yes, there are two numbers that sum up to the target.");
        } else {
            System.out.println("No, there aren't two numbers that sum up to the target.");
        }
    }
}
