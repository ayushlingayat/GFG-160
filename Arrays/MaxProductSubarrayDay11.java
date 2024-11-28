// package Arrays;

class MaxProductSubarrayDay11 {

    int maxProduct(int[] arr) {
        int n = arr.length;
        int pref = 1, suff = 1; // Initialize both pref and suff as 1
        int ans = Integer.MIN_VALUE; // Start with the smallest integer value

        for (int i = 0; i < n; i++) {
            // Reset pref and suff to 1 if they become 0
            if (pref == 0) pref = 1;
            if (suff == 0) suff = 1;

            pref *= arr[i];
            suff *= arr[n - 1 - i];

            ans = Math.max(ans, pref);
            ans = Math.max(ans, suff);
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxProductSubarrayDay11 obj = new MaxProductSubarrayDay11();
        int[] arr = {2, 3, -2, 4, -1}; 
        int result = obj.maxProduct(arr);
        System.out.println("Maximum Product Subarray: " + result);
    }
}
