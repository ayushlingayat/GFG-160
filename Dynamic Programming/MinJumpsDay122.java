class Solution {
    static int minJumps(int[] arr) {
        // code here
        int max=0,jump=0,current=0;
        for(int i=0;i<arr.length;i++){
            max=Math.max(max,i+arr[i]);
            if(current==i){
                if(i!=arr.length-1){
                    jump++;
                }
                current=max;
            }else{
                continue;
            }
        }
        if(current<arr.length-1){
                return -1;
        }
        return jump;
    }
}