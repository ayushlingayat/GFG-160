import java.util.*;

public class KadanesAlgoDay10 {


    // Function to find the sum of the contiguous subarray with the maximum sum
    public static int maxSubarraySum(int[] arr) {
        int cursum = 0, max = Integer.MIN_VALUE;

        for (int i : arr) {
            cursum += i;
            if (cursum > max) {
                max = cursum;
            }
            if (cursum < 0) {
                cursum = 0;
            }
        }
        return max;
    }
    public static void main(String args[]){
        int[] arr = {2, 3, -8, 7, -1, 2, 3};

        int result = maxSubarraySum(arr);

        System.out.println("Maximum sum of contiguous subarray: " + result);
    }
}
