public class MaxCircularsubarraysumDay12 {
    
    // Function to calculate the maximum circular subarray sum
    public int circularSubarraySum(int arr[]) {
        // Either max positive subarray or total sum minus max negative subarray
        int total = 0;
        int ans_max = Integer.MIN_VALUE, cur_max = 0;
        int ans_min = Integer.MAX_VALUE, cur_min = 0;
        
        for (int i : arr) {
            total += i;
            
            cur_max = Math.max(cur_max + i, i);
            ans_max = Math.max(cur_max, ans_max);
            
            cur_min = Math.min(cur_min + i, i);
            ans_min = Math.min(cur_min, ans_min);
        }
        
        if (total == ans_min) {
            return ans_max;
        }
        
        return Math.max(ans_max, total - ans_min);
    }

    // Main method to test the function
    public static void main(String[] args) {
        MaxCircularsubarraysumDay12 solution = new MaxCircularsubarraysumDay12();
        
        int[] arr = {8, -8, 9, -9, 10, -11, 12}; // Example input
        int result = solution.circularSubarraySum(arr);
        
        System.out.println("The maximum circular subarray sum is: " + result);
    }
}
