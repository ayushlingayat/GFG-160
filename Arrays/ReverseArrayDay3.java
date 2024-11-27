class ReverseArrayDay3 {

    // Make the method static or use an instance in main
    public static void reverseArray(int arr[]) {
        int start = 0;
        int end = arr.length - 1;
        
        // Swap elements until the middle of the array is reached
        while (start < end) {
            // Swap the elements at start and end
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            
            // Move the pointers towards the center
            start++;
            end--;
        }
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4, 5};
        
        // Call the static method
        reverseArray(arr);

        // Print the reversed array
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
