import java.util.Arrays;

public class NonOverlappingDay26 {

    static int minRemoval(int intervals[][]) {
        // Sort intervals by their start times
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        int cnt = 0;  // Counter for the number of intervals to remove
        int minEnd = intervals[0][1];  // Track the minimum end time of the intervals
        
        for (int i = 1; i < intervals.length; i++) {
            // Skip intervals with zero length
            if (intervals[i][0] == intervals[i][1]) continue;

            // Check for overlap
            if (intervals[i][0] < minEnd) {
                cnt++;  // Increment removal count
                minEnd = Math.min(minEnd, intervals[i][1]);  // Keep the interval with the smaller end
            } else {
                minEnd = intervals[i][1];  // Update the end time
            }
        }
        return cnt;
    }

    public static void main(String args[]) {
        // Example usage of the minRemoval method
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        
        // Finding the minimum number of intervals to remove
        int result = minRemoval(intervals);
        
        // Printing the result
        System.out.println("Minimum number of intervals to remove: " + result);
    }
}
