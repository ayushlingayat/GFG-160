import java.util.Arrays;

public class PairwithagivenSumDay54 {
    int countPairs(int arr[], int target) {
        Arrays.sort(arr); // Ensure the array is sorted
        int l = 0, n = arr.length, r = n - 1, ans = 0;

        while (l < r) {
            int sum = arr[l] + arr[r];
            if (sum == target) {
                int start = l + 1;
                int end = r - 1;
                ans++;
                while (start < r && arr[start] == arr[start - 1]) {
                    ans++;
                    start++;
                }
                while (l < end && arr[end] == arr[end + 1]) {
                    end--;
                    ans++;
                }
                l++;
                r--;
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        PairwithagivenSumDay54 pwgs = new PairwithagivenSumDay54();
        int[] arr = {1, 5, 7, -1, 5};
        int target = 6;
        int result = pwgs.countPairs(arr, target);
        System.out.println("Number of pairs with sum " + target + ": " + result);
    }
}
