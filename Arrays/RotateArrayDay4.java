class RotateArrayDay4 {

    static void rotateArr(int arr[], int d) {
        int n = arr.length;
        
        // Handle cases where d is greater than n
        d = d % n;

        // Step 1: Reverse the first d elements
        reverseArray(arr, 0, d - 1);
        
        // Step 2: Reverse the remaining n - d elements
        reverseArray(arr, d, n - 1);
        
        // Step 3: Reverse the entire array
        reverseArray(arr, 0, n - 1);
    }
    
    // Helper function to reverse a portion of an array from start to end (inclusive)
    static void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        // Sample input for demonstration
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int d = 2;  // Number of rotations

        System.out.println("Original array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        // Rotate the array
        rotateArr(arr, d);

        // Print the rotated array
        System.out.println("\nRotated array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
