import java.util.Arrays;

public class CountalltripletSumDay51 {
    public int countTriplets(int[] arr, int target) {
        int n = arr.length;
        int cnt = 0;

        // Sort the array to use two-pointer technique
        Arrays.sort(arr);

        for (int i = 0; i < n - 2; i++) {
            int low = i + 1, high = n - 1;
            while (low < high) {
                int sum = arr[i] + arr[low] + arr[high];
                if (sum == target) {
                    cnt++;
                
                    int tempLow = low + 1;
                    int tempHigh = high - 1;

                    // Count duplicates on the left
                    while (tempLow < high && arr[tempLow] == arr[low]) {
                        cnt++;
                        tempLow++;
                    }

                    // Count duplicates on the right
                    while (tempHigh > low && arr[tempHigh] == arr[high]) {
                        cnt++;
                        tempHigh--;
                    }

                    low++;
                    high--;
                } else if (sum < target) {
                    low++;
                } else {
                    high--;
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        CountalltripletSumDay51 obj = new CountalltripletSumDay51();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 15;

        int result = obj.countTriplets(arr, target);
        System.out.println("Number of triplets with sum " + target + ": " + result);
    }
}
