public class SearchRotatedDay30 {

    // Optimized function using binary search
    int search(int[] arr, int key) {
        if (arr == null || arr.length == 0) {
            return -1; // Handle edge cases
        }

        int start = 0, end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Check if the mid element is the key
            if (arr[mid] == key) {
                return mid;
            }

            // Determine which half is sorted
            if (arr[start] <= arr[mid]) { // Left half is sorted
                if (key >= arr[start] && key < arr[mid]) {
                    end = mid - 1; // Search in the left half
                } else {
                    start = mid + 1; // Search in the right half
                }
            } else { // Right half is sorted
                if (key > arr[mid] && key <= arr[end]) {
                    start = mid + 1; // Search in the right half
                } else {
                    end = mid - 1; // Search in the left half
                }
            }
        }

        return -1; // Key not found
    }

    public static void main(String[] args) {
        SearchRotatedDay30 obj = new SearchRotatedDay30();

        // Test cases
        int[] arr1 = {4, 5, 6, 7, 0, 1, 2};
        int key1 = 0;

        int[] arr2 = {4, 5, 6, 7, 0, 1, 2};
        int key2 = 3;

        int[] arr3 = {1};
        int key3 = 1;

        // Output results
        System.out.println("Index of " + key1 + " in arr1: " + obj.search(arr1, key1)); // Output: 4
        System.out.println("Index of " + key2 + " in arr2: " + obj.search(arr2, key2)); // Output: -1
        System.out.println("Index of " + key3 + " in arr3: " + obj.search(arr3, key3)); // Output: 0
    }
}
