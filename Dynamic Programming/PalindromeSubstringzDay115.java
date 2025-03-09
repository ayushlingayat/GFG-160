class Solution {
    public int isPalindrome(int s, int e, String temp) {
        int cnt = 0;
        int n = temp.length();
        while (s >= 0 && e < n && temp.charAt(s) == temp.charAt(e)) {
            if(e-s+1 >= 2){
                cnt++; 
            }
            
            s--;   
            e++;  
        }
        
        return cnt;
    }

    public int countPS(String s) {
        int n = s.length();
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            cnt += isPalindrome(i, i, s);
            cnt += isPalindrome(i, i + 1, s);
        }

        return cnt;
    }
}