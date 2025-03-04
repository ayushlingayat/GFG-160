class Solution {

    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        // code here
        int n = arr.length;
        int l = 1;
        int idx = 0;
        int i = 0, j = 1;
        while(j<n) {
            int k = i;
            while(k <= j){
                if(Math.abs(arr[k] - arr[j]) > x){
                    i = k+1;
                }
                k++;
            }
            if(l < j - i + 1){
                l = j - i + 1;
                idx = i;
            }
            j++;
        }
        
        if(l == 1){
            idx = 0;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        j = idx;
        while(j < n && j < idx+l){
            ans.add(arr[j]);
            j++;
        }
        return ans;
    }
}

