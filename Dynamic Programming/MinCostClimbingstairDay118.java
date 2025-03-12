class Solution {
    static int minCostClimbingStairs(int[] cost) {
        // Write your code here
        int n=cost.length,dp[]=new int[n];
        Arrays.fill(dp,-1);
        return Math.min(rec(0,cost,dp),rec(1,cost,dp));
    }
    private static int rec(int idx,int cost[],int dp[]){
        if(idx>=cost.length) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int one=cost[idx]+rec(idx+1,cost,dp);
        int two=cost[idx]+rec(idx+2,cost,dp);
        return dp[idx]=Math.min(one,two);
    }
}