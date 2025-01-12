import java.util.ArrayList;
import java.util.HashSet;

public class CountdistinctDay57 {
    
    ArrayList<Integer> countDistinct(int arr[], int k) {
        int i = 0, j = k - 1;
        ArrayList<Integer> res = new ArrayList<>();
        
        while (j < arr.length) {
            HashSet<Integer> hs = new HashSet<>();
            for (int x = i; x <= j; x++) {
                hs.add(arr[x]);
            }
            res.add(hs.size());
            i++;
            j++;
        }
        return res;
    }

    public static void main(String args[]) {
        CountdistinctDay57 cdd = new CountdistinctDay57();
        int[] arr = {1, 2, 1, 3, 4, 2, 3};
        int k = 4;
        ArrayList<Integer> result = cdd.countDistinct(arr, k);
        System.out.println("Count of distinct elements in each subarray of size " + k + ": " + result);
    }
}
