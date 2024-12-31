import java.util.HashSet;
import java.util.Set;

public class UnionofArraydupDay46 {

    public static int findUnion(int a[], int b[]) {
        // HashSet to store the unique elements from both arrays
        Set<Integer> st1 = new HashSet<>();

        // Add elements from the first array
        for (Integer el1 : a) {
            st1.add(el1);
        }

        // Add elements from the second array
        for (Integer el2 : b) {
            st1.add(el2);
        }

        // The size of the HashSet represents the number of unique elements in the union
        return st1.size();
    }

    public static void main(String args[]) {
        // Test case 1
        int[] arr1 = {1, 2, 2, 3, 4};
        int[] arr2 = {2, 2, 4, 6};
        System.out.println("Union of arrays (Test case 1): " + findUnion(arr1, arr2));  // Output: 4

        // Test case 2
        int[] arr3 = {5, 1, 3, 7, 9, 1};
        int[] arr4 = {3, 1, 1, 10, 5};
        System.out.println("Union of arrays (Test case 2): " + findUnion(arr3, arr4));  // Output: 5

        // Test case 3
        int[] arr5 = {8, 6, 7};
        int[] arr6 = {7, 8, 9, 10};
        System.out.println("Union of arrays (Test case 3): " + findUnion(arr5, arr6));  // Output: 4
    }
}
