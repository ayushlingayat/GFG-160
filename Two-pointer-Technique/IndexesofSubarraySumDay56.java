import java.util.ArrayList;

public class IndexesofSubarraySumDay56 {

    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        int sum = 0;
        int n = arr.length;

        while (j < n) {
            // Add elements to the current sum until it reaches or exceeds the target
            while (sum < target && j < n) {
                sum += arr[j];
                j++;
            }
            // Check if the current sum equals the target
            if (sum == target) {
                list.add(i + 1); // 1-based indexing
                list.add(j);     // j is already incremented, so it points to the next index
                return list;
            }
            // If the sum exceeds the target, subtract elements from the start
            while (sum > target && i < j) {
                sum -= arr[i];
                i++;
            }
        }
        // If no subarray found, return -1
        list.add(-1);
        return list;
    }

    public static void main(String args[]) {
        int[] arr = {1, 2, 3, 7, 5};
        int target = 12;
        ArrayList<Integer> result = subarraySum(arr, target);
        System.out.println("Subarray with the given sum: " + result);
    }
}
