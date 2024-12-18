import java.util.ArrayList;

public class InsertIntervalDay25 {

    static ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> ans = new ArrayList<>();
        int i = 0, n = intervals.length;

        // Add intervals before the new interval
        while (i < n && intervals[i][1] < newInterval[0]) {
            ans.add(intervals[i]);
            i++;
        }

        // Merge overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        
        // Add the merged new interval
        ans.add(newInterval);

        // Add intervals after the new interval
        while (i < n) {
            ans.add(intervals[i]);
            i++;
        }

        return ans;
    }

    public static void main(String args[]) {
        // Example usage of the insertInterval method
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};

        // Inserting the new interval
        ArrayList<int[]> result = insertInterval(intervals, newInterval);

        // Printing the resulting intervals
        System.out.println("Resulting intervals:");
        for (int[] interval : result) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }
}
