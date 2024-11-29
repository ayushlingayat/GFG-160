

import java.util.HashSet;
import java.util.Set;

public class SmallestPositiveMissingNumberDay13 {
    public int missingNumber(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int n = arr.length;
        
        // Add only positive numbers to the set
        for (int val : arr) {
            if (val > 0) {
                set.add(val);
            }
        }
        
        // Find the smallest missing positive number
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        
        // If all numbers from 1 to n are present, return n + 1
        return n + 1;
    }

    public static void main(String[] args) {
        SmallestPositiveMissingNumberDay13 spmn = new SmallestPositiveMissingNumberDay13();
        
        // Example test case
        int[] arr = {3, 4, -1, 1};
        int result = spmn.missingNumber(arr);
        
        System.out.println("The smallest positive missing number is: " + result);
    }
}
