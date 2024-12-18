import java.util.Arrays;

public class MergeExtraDay27 {

    public void mergeArrays(int a[], int b[]) {
        int n = a.length;
        int m = b.length;

        // Start comparing from the end of the first array and the start of the second array
        for (int i = n - 1, j = 0; i >= 0 && j < m; i--, j++) {
            if (a[i] > b[j]) {
                // Swap the elements
                int temp = a[i];
                a[i] = b[j];
                b[j] = temp;
            }
        }

        // Sort both arrays individually
        Arrays.sort(a);
        Arrays.sort(b);
    }

    public static void main(String args[]) {
        // Example usage of the mergeArrays method
        int[] a = {1, 3, 5, 7};
        int[] b = {2, 4, 6, 8};

        MergeExtraDay27 obj = new MergeExtraDay27();

        // Merge and sort the arrays
        obj.mergeArrays(a, b);

        // Print the merged and sorted arrays
        System.out.println("Array A after merging and sorting: " + Arrays.toString(a));
        System.out.println("Array B after merging and sorting: " + Arrays.toString(b));
    }
}
