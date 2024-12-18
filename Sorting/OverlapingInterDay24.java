import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class OverlappingInterDay24 {

    public List<int[]> mergeOverlap(int[][] arr) {
        // Sort the intervals based on the starting value
        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> ans = new ArrayList<>();
        // Add the first interval to the list
        ans.add(arr[0]);
        for (int[] interval : arr) {
            // Check if the current interval overlaps with the last interval in the list
            if (interval[0] <= ans.get(ans.size() - 1)[1]) {
                // Merge the intervals by updating the end value of the last interval
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], interval[1]);
            } else {
                // Add the current interval to the list
                ans.add(interval);
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        // Example usage of the mergeOverlap method
        OverlappingInterDay24 obj = new OverlappingInterDay24();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        
        // Merging the overlapping intervals
        List<int[]> mergedIntervals = obj.mergeOverlap(intervals);
        
        // Printing the merged intervals
        System.out.println("Merged intervals:");
        for (int[] interval : mergedIntervals) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }
}
