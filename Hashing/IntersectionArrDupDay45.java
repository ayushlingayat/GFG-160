import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionArrDupDay45 {

    public ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
        // ArrayList to store the intersection elements
        ArrayList<Integer> l = new ArrayList<>();
        int i = 0, j = 0;
        int n1 = a.length, n2 = b.length;

        // Sort both arrays
        Arrays.sort(a);
        Arrays.sort(b);

        // Find the intersection
        while (i < n1 && j < n2) {
            if (a[i] == b[j]) {
                l.add(a[i]);
                i++;
                j++;

                // Skip duplicates in both arrays
                while (i < n1 && a[i - 1] == a[i]) {
                    i++;
                }
                while (j < n2 && b[j - 1] == b[j]) {
                    j++;
                }
            } else {
                if (a[i] > b[j]) {
                    j++;
                } else {
                    i++;
                }
            }
        }

        return l;
    }

    public static void main(String[] args) {
        IntersectionArrDupDay45 obj = new IntersectionArrDupDay45();

        // Test case 1
        int[] arr1 = {1, 2, 2, 3, 4};
        int[] arr2 = {2, 2, 4, 6};
        ArrayList<Integer> result = obj.intersectionWithDuplicates(arr1, arr2);
        System.out.println("Intersection of arrays (Test case 1): " + result);

        // Test case 2
        int[] arr3 = {5, 1, 3, 7, 9, 1};
        int[] arr4 = {3, 1, 1, 10, 5};
        result = obj.intersectionWithDuplicates(arr3, arr4);
        System.out.println("Intersection of arrays (Test case 2): " + result);

        // Test case 3
        int[] arr5 = {8, 6, 7};
        int[] arr6 = {7, 8, 9, 10};
        result = obj.intersectionWithDuplicates(arr5, arr6);
        System.out.println("Intersection of arrays (Test case 3): " + result);
    }
}
