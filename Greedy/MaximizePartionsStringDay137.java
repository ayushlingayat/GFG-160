class Solution {
    public int maxPartitions(String s) {
        int last[] = new int[26];
        for(int i=0; i<s.length(); i++) 
            last[s.charAt(i) - 'a'] = i;
            
        int end = 0, res = 0;
        for(int i=0; i<s.length(); i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            
            if(i == end) 
                res++;
        }
        return res;
    }
}
