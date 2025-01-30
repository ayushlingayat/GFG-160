import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class PermutationofStringsDay75 {

    public ArrayList<String> findPermutation(String s) {
        Set<String> permutations = new HashSet<>();
        generatePermutations("", s, permutations);
        ArrayList<String> result = new ArrayList<>(permutations);
        Collections.sort(result); // Sorting lexicographically
        return result;
    }

    private void generatePermutations(String p, String up, Set<String> permutations) {
        if (up.isEmpty()) {
            permutations.add(p);
            return;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String l = p.substring(i);
            generatePermutations(f + ch + l, up.substring(1), permutations);
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        PermutationofStringsDay75 obj = new PermutationofStringsDay75();
        ArrayList<String> permutations = obj.findPermutation(input);

        System.out.println("Unique Permutations:");
        for (String perm : permutations) {
            System.out.println(perm);
        }
        scanner.close();
    }
}
