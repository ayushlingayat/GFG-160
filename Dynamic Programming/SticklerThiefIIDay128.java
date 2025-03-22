class Solution {
    int maxValue(int[] nums) {
        if (nums.length == 1) return nums[0];

        // Case 1: Consider houses from index 0 to n-2
        int prev2 = 0, prev = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            int take = nums[i] + (i > 1 ? prev2 : 0);
            int notTake = prev;
            int curr = Math.max(take, notTake);
            prev2 = prev;
            prev = curr;
        }
        int max1 = prev;

        // Case 2: Consider houses from index 1 to n-1
        prev2 = 0;
        prev = nums[1];
        for (int i = 2; i < nums.length; i++) {
            int take = nums[i] + (i > 2 ? prev2 : 0);
            int notTake = prev;
            int curr = Math.max(take, notTake);
            prev2 = prev;
            prev = curr;
        }
        int max2 = prev;

        return Math.max(max1, max2);
    }
}