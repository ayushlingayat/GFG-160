class CountInversionDay23 {

    static int inversionCount(int[] arr) {
        if (arr.length < 2) {
            return 0;
        }
        int[] temp = new int[arr.length];
        return mergeSortAndCount(arr, temp, 0, arr.length - 1);
    }

    // Function to perform merge sort and count inversions.
    private static int mergeSortAndCount(int[] arr, int[] temp, int left, int right) {
        int mid, invCount = 0;
        if (left < right) {
            mid = (left + right) / 2;

            // Count inversions in the left half
            invCount += mergeSortAndCount(arr, temp, left, mid);

            // Count inversions in the right half
            invCount += mergeSortAndCount(arr, temp, mid + 1, right);

            // Count split inversions
            invCount += mergeAndCount(arr, temp, left, mid, right);
        }
        return invCount;
    }

    // Function to merge two sorted halves and count split inversions.
    private static int mergeAndCount(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left; // Starting index for the left subarray
        int j = mid + 1; // Starting index for the right subarray
        int k = left; // Starting index to be sorted
        int invCount = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                invCount += (mid + 1) - i; // Count the inversions
            }
        }

        // Copy the remaining elements of the left subarray, if any
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy the remaining elements of the right subarray, if any
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // Copy the sorted subarray into the original array
        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return invCount;
    }

    public static void main(String args[]) {
        // Sample input array
        int[] arr = {2, 4, 1, 3, 5};

        // Calculate and print the inversion count
        int result = inversionCount(arr);
        System.out.println("Number of inversions: " + result);

        // Print the sorted array
        System.out.print("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
