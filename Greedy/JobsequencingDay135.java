class Solution {
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        int arr[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = deadline[i]; 
            arr[i][1] = profit[i];   
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(b[1], a[1]));
        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, arr[i][0]);
        }
        int slot[] = new int[maxDeadline];  
        Arrays.fill(slot, -1);
        int totJobs = 0;
        int totProfit = 0;
        for (int i = 0; i < n; i++) {
            int deadlineIdx = arr[i][0] - 1;
            while (deadlineIdx >= 0 && slot[deadlineIdx] != -1) {
                deadlineIdx--;
            }
            if (deadlineIdx >= 0) {
                slot[deadlineIdx] = i;
                totJobs++;
                totProfit += arr[i][1];
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        res.add(totJobs);
        res.add(totProfit);
        return res;
    }
}
