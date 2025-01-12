import java.util.HashMap;

public class LongestSubstringDay58 {
    
    public int longestUniqueSubstr(String s) {
        int i = 0, max = 0;
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int j = 0; j < n; j++) {
            char ch = s.charAt(j);

            if (map.containsKey(ch)) {
                i = Math.max(map.get(ch) + 1, i);  // Move the start pointer to avoid repeating characters
            }

            map.put(ch, j);  // Update the latest index of the character
            max = Math.max(max, j - i + 1);  // Calculate the length of the current substring
        }

        return max;
    }

    public static void main(String args[]) {
        LongestSubstringDay58 lsd = new LongestSubstringDay58();
        String s = "abcabcbb";
        int result = lsd.longestUniqueSubstr(s);
        System.out.println("Length of the longest substring without repeating characters: " + result);
    }
}
