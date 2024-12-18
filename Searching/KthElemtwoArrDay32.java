public class KthElemtwoArrDay32 {
    // Function to find the k-th element in two sorted arrays
    static int kthElement(int[] a, int[] b, int k) {
        int n = a.length, m = b.length;

        // Ensure that the first array is the smaller one
        if (n > m) {
            return kthElement(b, a, k);
        }

        // Binary search to find the k-th element
        int lo = Math.max(0, k - m), hi = Math.min(k, n);

        while (lo <= hi) {
            int mid1 = (lo + hi) / 2;
            int mid2 = k - mid1;

            // Handle edge cases for l1, r1, l2, and r2
            int l1 = (mid1 == 0 ? Integer.MIN_VALUE : a[mid1 - 1]);
            int r1 = (mid1 == n ? Integer.MAX_VALUE : a[mid1]);

            int l2 = (mid2 == 0 ? Integer.MIN_VALUE : b[mid2 - 1]);
            int r2 = (mid2 == m ? Integer.MAX_VALUE : b[mid2]);

            // Check if the partition is valid
            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2); // The k-th element
            }

            // Adjust the binary search range
            if (l1 > r2) {
                hi = mid1 - 1; // Move to the left part
            } else {
                lo = mid1 + 1; // Move to the right part
            }
        }

        return 0; // Default return (this should not be reached)
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 6, 7, 9};
        int[] b = {1, 4, 8, 10};
        int k = 5;

        // Find the k-th element
        int result = kthElement(a, b, k);

        // Print the result
        System.out.println("The " + k + "-th element is: " + result);
    }
}
