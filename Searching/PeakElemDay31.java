public class PeakElemDay31 {

    // Function to find a peak element
    public int peakElement(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1; // Edge case: Empty array
        }

        // Handle small arrays
        if (arr.length == 1) {
            return 0; // Single element is always a peak
        }
        if (arr.length == 2) {
            return arr[0] > arr[1] ? 0 : 1; // Return the larger element's index
        }

        // Use binary search for O(log n) solution
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;

            // Check if mid is a peak
            if ((mid == 0 || arr[mid] > arr[mid - 1]) && (mid == arr.length - 1 || arr[mid] > arr[mid + 1])) {
                return mid;
            }

            // Move to the larger neighbor
            if (mid > 0 && arr[mid - 1] > arr[mid]) {
                end = mid - 1; // Move to the left half
            } else {
                start = mid + 1; // Move to the right half
            }
        }

        return start; // The peak element's index
    }

    public static void main(String[] args) {
        PeakElemDay31 obj = new PeakElemDay31();

        // Test cases
        int[] arr1 = {1, 2, 3, 1};
        int[] arr2 = {1, 3, 20, 4, 1, 0};
        int[] arr3 = {10};
        int[] arr4 = {1, 2};
        int[] arr5 = {2, 1};

        // Output results
        System.out.println("Peak element index in arr1: " + obj.peakElement(arr1)); // Output: 2
        System.out.println("Peak element index in arr2: " + obj.peakElement(arr2)); // Output: 2
        System.out.println("Peak element index in arr3: " + obj.peakElement(arr3)); // Output: 0
        System.out.println("Peak element index in arr4: " + obj.peakElement(arr4)); // Output: 1
        System.out.println("Peak element index in arr5: " + obj.peakElement(arr5)); // Output: 0
    }
}
