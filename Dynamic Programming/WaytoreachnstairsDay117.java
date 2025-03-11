class Solution {
    int countWays(int n) {
        // your code here
        if(n==1)
        {
            return 1;
        }
        if(n==2)
        {
            return 2;
        }
        int a = 1;
        int b = 2;
        int result = 0;
        for(int i=3;i<=n;i++)
        {
            result = a+b;
            a = b;
            b = result;
        }
        return result;
        
    }

}