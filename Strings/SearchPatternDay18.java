import java.util.ArrayList;

public class SearchPatternDay18 {

    // Method to search for all occurrences of a pattern in a text using KMP algorithm
    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> res = new ArrayList<>();
        int m = pat.length();
        int n = txt.length();

        // Step 1: Compute the longest prefix-suffix (LPS) array for the pattern
        int[] lps = computeLPSArray(pat);

        // Step 2: Perform the KMP search
        int i = 0; // Index for txt
        int j = 0; // Index for pat
        while (i < n) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }
            if (j == m) {
                // Pattern found, add the index (1-based indexing)
                res.add(i - j + 1); // Adding 1 to make it 1-based index
                j = lps[j - 1]; // Use the LPS array to avoid unnecessary comparisons
            } else if (i < n && pat.charAt(j) != txt.charAt(i)) {
                // Mismatch after j matches
                if (j != 0) {
                    j = lps[j - 1]; // Use the LPS array to skip characters
                } else {
                    i++;
                }
            }
        }
        return res;
    }

    // Method to compute the Longest Prefix Suffix (LPS) array for the pattern
    private int[] computeLPSArray(String pat) {
        int m = pat.length();
        int[] lps = new int[m];
        int length = 0; // Length of the previous longest prefix suffix
        int i = 1;

        // Build the LPS array
        while (i < m) {
            if (pat.charAt(i) == pat.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1]; // Try the previous longest prefix suffix
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    // Main method for testing the code
    public static void main(String[] args) {
        SearchPatternDay18 sp = new SearchPatternDay18();

        // Example usage
        String text = "ababcabcabababd";
        String pattern = "ababd";

        ArrayList<Integer> result = sp.search(pattern, text);

        // Printing the result
        if (result.isEmpty()) {
            System.out.println("Pattern not found in the text.");
        } else {
            System.out.println("Pattern found at positions: " + result);
        }
    }
}
