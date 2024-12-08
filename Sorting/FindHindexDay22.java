import java.util.*;

public class FindHindexDay22 {

    public int hIndex(int[] citations) {
        // Sort citations in ascending order
        Arrays.sort(citations);
        int n = citations.length;
        int hIndex = 0;

        for (int i = 0; i < n; i++) {
            // Calculate the number of papers with citations >= citations[i]
            int h = n - i;
            if (citations[i] >= h) {
                hIndex = h;
                break;
            }
        }

        return hIndex;
    }

    public static void main(String[] args) {
        FindHindexDay22 solution = new FindHindexDay22();
        
        // Example test cases
        int[] citations1 = {3, 0, 6, 1, 5};
        System.out.println("H-Index: " + solution.hIndex(citations1)); // Output: 3

        int[] citations2 = {1, 3, 1};
        System.out.println("H-Index: " + solution.hIndex(citations2)); // Output: 1

        int[] citations3 = {0, 0, 0};
        System.out.println("H-Index: " + solution.hIndex(citations3)); // Output: 0

        int[] citations4 = {10, 8, 5, 4, 3};
        System.out.println("H-Index: " + solution.hIndex(citations4)); // Output: 4
    }
}
