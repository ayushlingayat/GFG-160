import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MajorityElementDay6 {

    public static List<Integer> findMajority(int[] nums) {
        int n = nums.length;
        if (n == 0) return new ArrayList<>();
        
        // Variables to store potential candidates and their counts
        int candidate1 = 0, candidate2 = 0, count1 = 0, count2 = 0;
        
        // Finding potential candidates
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        
        // Validating candidates
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }
        
        List<Integer> res = new ArrayList<>();
        if (count1 > n / 3) {
            res.add(candidate1);
        }
        if (count2 > n / 3) {
            res.add(candidate2);
        }
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        System.out.println(findMajority(nums)); // Output: [3]

        int[] nums2 = {1, 1, 1, 3, 3, 2, 2, 2};
        System.out.println(findMajority(nums2)); // Output: [1, 2]
    }
}
