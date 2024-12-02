import java.util.*;

public class AnagramDay16 {

    public static boolean validAnagram(String s1, String s2) {
        // Convert strings to character arrays
        char[] ss1 = s1.toCharArray();
        char[] ss2 = s2.toCharArray();

        // Sort the character arrays
        Arrays.sort(ss1);
        Arrays.sort(ss2);

        // Compare the sorted arrays by converting them back to strings
        return Arrays.equals(ss1, ss2);
    }

    public static void main(String args[]) {
        // Scanner to take input from the user
        Scanner sc = new Scanner(System.in);

        // Prompt the user for input strings
        System.out.println("Enter the first string:");
        String s1 = sc.nextLine();

        System.out.println("Enter the second string:");
        String s2 = sc.nextLine();

        // Check if the strings are anagrams
        if (validAnagram(s1, s2)) {
            System.out.println("The strings are anagrams.");
        } else {
            System.out.println("The strings are not anagrams.");
        }

        sc.close();
    }
}
