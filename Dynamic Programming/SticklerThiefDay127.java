class Solution {

    public int solveMem(int [] arr, int idx, int [] dp){
            if(idx >= arr.length){
                return 0;
            }
            if(dp[idx] != -1){
                return dp[idx];
            }
            int include = solveMem(arr,idx + 1,dp);
            int exclude = arr[idx] + solveMem(arr,idx + 2,dp);
            return dp[idx] = Math.max(include,exclude);
        }
    
    public int findMaxSum(int arr[]) {
            int n = arr.length;
            int [] dp = new int[n + 1];
            Arrays.fill(dp,-1);
            return solveMem(arr,0,dp);
        }
    }
