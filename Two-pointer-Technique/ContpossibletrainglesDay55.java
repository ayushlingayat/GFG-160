import java.util.Arrays;

public class ContpossibletrainglesDay55 {
    static int countTriangles(int arr[]) {
        Arrays.sort(arr); // Sort the array to use the two-pointer technique
        int n = arr.length;
        int ans = 0;

        for (int i = n - 1; i >= 0; i--) {
            int l = 0, r = i - 1;
            while (l < r) {
                int sum = arr[l] + arr[r];
                if (sum > arr[i]) {
                    ans += (r - l); // All elements from l to r-1 can form a triangle with arr[r] and arr[i]
                    r--;
                } else {
                    l++;
                }
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        int[] arr = {10, 21, 22, 100, 101, 200, 300};
        int result = countTriangles(arr);
        System.out.println("Number of possible triangles: " + result);
    }
}
