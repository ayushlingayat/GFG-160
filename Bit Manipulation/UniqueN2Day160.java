class Solution {
    public int[] singleNum(int[] arr) {
        // Step 1: XOR all the numbers. The result will be XOR of the two unique numbers.
        int xor = 0;
        for (int n : arr) {
            xor ^= n;  // XOR accumulates. Duplicate numbers cancel each other out.
        }

        // Step 2: Find the rightmost set bit (i.e., a bit where the two unique numbers differ).
        // `xor & (xor - 1)` turns off the rightmost set bit. XOR-ing it back gives us that bit alone.
        int r = (xor & (xor - 1)) ^ xor;

        // Step 3: Divide the numbers into two groups based on that bit and XOR within groups.
        int a = 0, b = 0;
        for (int n : arr) {
            if ((n & r) != 0) {
                a ^= n;  // Group with the distinguishing bit set
            } else {
                b ^= n;  // Group with the distinguishing bit not set
            }
        }

        // Step 4: a and b are the two unique numbers. Sort them to maintain order.
        int[] res = {a, b};
        Arrays.sort(res);
        return res;  // Return the result as a sorted array
    }
}
