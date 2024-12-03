import java.util.*;

public class NonRepeatingCharDay17 {

    static char nonRepeatingChar(String s) {
        // Using a HashMap to store character frequencies
        HashMap<Character, Integer> map = new HashMap<>();
        
        // Populate the HashMap with frequencies
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        // Find the first non-repeating character
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.get(ch) == 1) {
                return ch;
            }
        }
        
        // Return '$' if no non-repeating character is found
        return '$';
    }

    public static void main(String[] args) {
        // Test cases
        String test1 = "geeksforgeeks";
        String test2 = "abcabc";
        String test3 = "swiss";
        
        System.out.println("First non-repeating character in 'geeksforgeeks': " + nonRepeatingChar(test1)); // Output: f
        System.out.println("First non-repeating character in 'abcabc': " + nonRepeatingChar(test2));       // Output: $
        System.out.println("First non-repeating character in 'swiss': " + nonRepeatingChar(test3));       // Output: w
    }
}
