public class SortedRotMinDay29 {

    public int findMin(int[] nums) {
        // Handle edge cases
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int start = 0, end = nums.length - 1;

        // If the array is not rotated
        if (nums[start] < nums[end]) {
            return nums[start];
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Check if mid is the pivot (minimum)
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            // Decide whether to search in the left or right half
            if (nums[start] <= nums[mid] && nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return nums[start]; // Return the start element as the minimum
    }

    public static void main(String args[]) {
        // Example usage of the findMin method
        SortedRotMinDay29 obj = new SortedRotMinDay29();

        // Test cases
        int[] nums1 = {3, 4, 5, 1, 2}; // Rotated array
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2}; // Rotated array
        int[] nums3 = {11, 13, 15, 17}; // Non-rotated array

        // Find and print the minimum element in each case
        System.out.println("Minimum in nums1: " + obj.findMin(nums1)); // Output: 1
        System.out.println("Minimum in nums2: " + obj.findMin(nums2)); // Output: 0
        System.out.println("Minimum in nums3: " + obj.findMin(nums3)); // Output: 11
    }
}
