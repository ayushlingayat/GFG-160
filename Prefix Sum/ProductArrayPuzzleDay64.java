class ProductArrayPuzzleDay64 {
    public static int[] productExceptSelf(int arr[]) {
        int n = arr.length;
        int left[] = new int[n];
        
        // Fill left array with cumulative product from the left
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = arr[i - 1] * left[i - 1];
        }
        
        // Initialize right product
        int right = 1;
        // Update the array to store the product of left and right for each element
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = left[i] * right;
            right *= arr[i];
        }
        
        return arr;
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4};
        int result[] = productExceptSelf(arr);

        System.out.print("Product array except self is: ");
        for (int value : result) {
            System.out.print(value + " ");
        }
    }
}
