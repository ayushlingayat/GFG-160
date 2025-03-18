class Solution {
    static boolean equalPartition(int arr[]) {
        // code here
        int n=arr.length,arSum=0;
        for(int i:arr) arSum+=i;
        Boolean dp[][]=new Boolean[n][arSum+1];
        return rec(n-1,arr,arSum,0,dp);
    }
    private static boolean rec(int id,int arr[],int arSum,int sum,Boolean dp[][]){
        if(arSum==sum) return true;
        if(id<0 || sum>arSum) return false;
        if(dp[id][arSum]!=null) return dp[id][arSum];
        boolean p=rec(id-1,arr,arSum-arr[id],sum+arr[id],dp);
        boolean np=rec(id-1,arr,arSum,sum,dp);
        return dp[id][arSum]=p || np;
    }
}