public class MoveAllZerosDay2 {

    public static void pushZerosToEnd(int[] arr) {
        int k = 0; // Initialize index for placing non-zero elements
        
        // Traverse the array and move non-zero elements to the front
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[k] = arr[i]; 
                k++;
            }
        }
        
        // Fill the rest of the array with zeros
        while (k < arr.length) {
            arr[k] = 0;
            k++;
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 0, 4, 3, 0, 5, 0};
        pushZerosToEnd(arr);
        
        // Print the modified array
        System.out.print("Array after moving all zeros to the end: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
