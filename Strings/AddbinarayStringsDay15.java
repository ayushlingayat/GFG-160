public class AddbinarayStringsDay15 {
    public static void main(String args[]) {
        // Test cases for the addBinary method
        Solution solution = new Solution();
        
        String s1 = "1010";
        String s2 = "1011";
        System.out.println("Input: s1 = \"" + s1 + "\", s2 = \"" + s2 + "\"");
        System.out.println("Output: " + solution.addBinary(s1, s2)); // Expected: "10101"
        
        String s3 = "11";
        String s4 = "1";
        System.out.println("Input: s1 = \"" + s3 + "\", s2 = \"" + s4 + "\"");
        System.out.println("Output: " + solution.addBinary(s3, s4)); // Expected: "100"
    }
}

class Solution {
    public String addBinary(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        
        int i = n - 1;
        int j = m - 1;
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        
        // Iterate through both strings and calculate the sum bit by bit
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            
            if (i >= 0) sum += s1.charAt(i) - '0';
            if (j >= 0) sum += s2.charAt(j) - '0';
            
            ans.append(sum % 2); // Add the current bit to the result
            carry = sum / 2;     // Update the carry
            
            i--;
            j--;
        }

        // Reverse the result to get the correct binary addition
        return ans.reverse().toString();
    }
}
