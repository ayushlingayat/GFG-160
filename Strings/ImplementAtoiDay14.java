public class ImplementAtoiDay14 {
    public static void main(String args[]) {
        // Test cases for the myAtoi function
        Solution solution = new Solution();
        
        String test1 = "42";
        String test2 = "   -42";
        String test3 = "4193 with words";
        String test4 = "words and 987";
        String test5 = "-91283472332";
        
        System.out.println("Input: \"" + test1 + "\", Output: " + solution.myAtoi(test1)); // Expected: 42
        System.out.println("Input: \"" + test2 + "\", Output: " + solution.myAtoi(test2)); // Expected: -42
        System.out.println("Input: \"" + test3 + "\", Output: " + solution.myAtoi(test3)); // Expected: 4193
        System.out.println("Input: \"" + test4 + "\", Output: " + solution.myAtoi(test4)); // Expected: 0
        System.out.println("Input: \"" + test5 + "\", Output: " + solution.myAtoi(test5)); // Expected: -2147483648
    }
}

class Solution {
    public int myAtoi(String s) {
        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        int sign = 1;
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }

        long result = 0; 
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            result = result * 10 + (s.charAt(i) - '0');
            
            if (result * sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (result * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            i++;
        }

        return (int) (result * sign);
    }
}
