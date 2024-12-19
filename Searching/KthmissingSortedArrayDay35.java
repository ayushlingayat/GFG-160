import java.util.HashSet;

public class KthmissingSortedArrayDay35 {

    // Function to find the kth missing number
    public int kthMissing(int[] arr, int k) {
        int cnt = 0;
        HashSet<Integer> set = new HashSet<>();

        // Add all array elements to the set
        for (int num : arr) {
            set.add(num);
        }

        // Iterate through numbers starting from 1
        for (int i = 1; i <= Integer.MAX_VALUE; i++) {
            if (!set.contains(i)) { // Check if the number is missing
                cnt++;
                if (cnt == k) { // Found the kth missing number
                    return i;
                }
            }
        }
        return -1; // Return -1 if kth missing number is not found (edge case)
    }

    public static void main(String[] args) {
        // Example input
        int[] arr = {2, 3, 4, 7, 11}; // Sorted array
        int k = 5; // Kth missing number to find

        // Create an instance of the class
        KthmissingSortedArrayDay35 obj = new KthmissingSortedArrayDay35();

        // Find the kth missing number
        int result = obj.kthMissing(arr, k);

        // Print the result
        System.out.println("The " + k + "th missing number is: " + result);
    }
}
