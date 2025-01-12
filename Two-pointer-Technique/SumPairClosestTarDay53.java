import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumPairClosestTarDay53 {
    public List<Integer> sumClosest(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        int l = 0, r = n - 1;
        int minDiff = Integer.MAX_VALUE;
        List<Integer> ans = new ArrayList<>();
        
        while (l < r) {
            int sum = arr[l] + arr[r];
            
            if (Math.abs(target - sum) < minDiff) {
                minDiff = Math.abs(target - sum);
                ans = Arrays.asList(arr[l], arr[r]);
            }
            
            if (sum < target) {
                l++;
            } else if (sum > target) {
                r--;
            } else {
                return ans;
            }
        }
        
        return ans;
    }

    public static void main(String args[]) {
        SumPairClosestTarDay53 spc = new SumPairClosestTarDay53();
        int[] arr = {10, 22, 28, 29, 30, 40};
        int target = 54;
        List<Integer> result = spc.sumClosest(arr, target);
        System.out.println("Pair closest to target " + target + ": " + result);
    }
}
