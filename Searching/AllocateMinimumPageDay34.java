public class AllocateMinimumPageDay34 {

    // Function to find the minimum number of pages to allocate
    public static int findPages(int[] arr, int m) {
        int n = arr.length;
        if (m > n) {
            return -1; // Not possible to allocate
        }

        int start = 0, end = 0, mid, ans = 0;
        for (int i = 0; i < n; i++) {
            start = Math.max(start, arr[i]); // Maximum value in array
            end += arr[i]; // Sum of all pages
        }

        while (start <= end) {
            mid = start + (end - start) / 2;
            int pages = 0;
            int count = 1;

            // Check if we can allocate with the current mid value
            for (int i = 0; i < n; i++) {
                pages += arr[i];
                if (pages > mid) {
                    count++;
                    pages = arr[i];
                }
            }

            if (count <= m) {
                ans = mid; // Update answer
                end = mid - 1; // Try for a smaller maximum
            } else {
                start = mid + 1; // Try for a larger maximum
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // Example input
        int[] arr = {12, 34, 67, 90}; // Array of pages
        int m = 2; // Number of students

        // Calculate the minimum pages
        int result = findPages(arr, m);

        // Print the result
        System.out.println("The minimum number of pages is: " + result);
    }
}
