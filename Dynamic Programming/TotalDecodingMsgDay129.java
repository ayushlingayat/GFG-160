class Solution {
    public int countWays(String digits) {
        // code here
        return f(digits.toCharArray(),0,new Integer[digits.length()]);
    }
    
    public int f(char[] chArr,int i,Integer[]dp){
        if(i==chArr.length) return 1;
        if(dp[i]!=null) return dp[i];
        if( !(chArr[i]>'0' && chArr[i]<='9')) return dp[i]= 0; 
        // ith char = 0 or something else other than 1 to 9 can never contribute to answer
        // 0 is only allowed incase of taking pair  or see like this 0******* 
        // string starting with zero will give 0 as result.
        
        int takeOne=f(chArr,i+1,dp);
        
        int takeTwo=0; // initially assume you cannot take 2 chars directly 
        
        //Check can you take really 2 chars.
        if(i+1!=chArr.length){
            int tens=chArr[i]-'0';
            int ones=chArr[i+1]-'0';
            int num=tens*10+ones;
            if(num>=1 &&num<=26){
                takeTwo=f(chArr,i+2,dp);
            }
        }
        return dp[i]=takeOne+takeTwo;
    }
}
