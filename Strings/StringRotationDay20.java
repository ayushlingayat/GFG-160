class StringRotationDay20{

    public static boolean areRotations(String s1, String s2) {
        // Your code here
        if (s1.length() != s2.length()) return false;
        String concatenated = s1 + s1;
        return kmpSearch(concatenated, s2);
    }
    private static boolean kmpSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int[] lps = computeLPSArray(pattern);
        int i = 0, j = 0;
        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == m) return true;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }
    private static int[] computeLPSArray(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0;
        int i = 1;
        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
    public static void main(String[] args) {
        String s1 = "ABCD";
        String s2 = "CDAB";
        String s3 = "ABCD";
        String s4 = "ACBD";

        System.out.println("Are \"" + s1 + "\" and \"" + s2 + "\" rotations? " + areRotations(s1, s2));
        System.out.println("Are \"" + s3 + "\" and \"" + s4 + "\" rotations? " + areRotations(s3, s4));
    }
}