class Solution {
    int missingNum(int arr[]) {
        // code here
       int sum=0;
       for(int i=1;i<=arr.length;i++){
           sum=sum^i^arr[i-1];
       }
       return sum^arr.length+1;
    }
}
