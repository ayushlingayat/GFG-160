class Solution {
    public static int getMaxArea(int arr[]) {
        // your code here
        int max = 0;
        for(int i=0;i<arr.length;i++){
            int minHeight = arr[i];
            for(int j=i;j<arr.length;j++){
                m = Math.min(minHeight, arr[j]);
                if(minHeight*(arr.length-i)<max)break;
                max = Math.max(max, minHeight*(j-i+1));
            }
        }
        return max;
    }
}

