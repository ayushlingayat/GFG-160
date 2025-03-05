class Solution {
    static int longestSubsequence(int n, int a[]) {
        List<Integer>temp = new ArrayList<>();
        temp.add(a[0]);
        int len = 1;
        
        for(int i=1;i<n;i++){
            if(a[i]>temp.get(temp.size()-1)){
                temp.add(a[i]);
                len++;
            }else{
                int ind = Collections.binarySearch(temp,a[i]);
                if(ind<0)ind = -ind-1;
                
                temp.set(ind,a[i]);
            }
        }
        return len;
        
    }

}