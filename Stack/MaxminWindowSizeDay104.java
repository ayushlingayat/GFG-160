class Solution {
    
    static int[] maxOfMin(int[] arr, int n) {
       int min=arr[0]; //finding min too
        
       Deque<Integer> ps=new ArrayDeque<>(); //previous smaller element
       int[] PS=new int[n];
       for(int i=0;i<n;i++){
           while(ps.isEmpty()==false && arr[i]<=arr[ps.peek()]){
               ps.pop();
           }
           PS[i]=(ps.isEmpty())?-1:ps.peek();
           ps.push(i);
           
           min=Math.min(arr[i],min);
       }
       
       Deque<Integer> ns=new ArrayDeque<>(); //next smaller element
       int[] NS=new int[n];
       for(int i=n-1;i>=0;i--){
           while(ns.isEmpty()==false && arr[i]<=arr[ns.peek()]){
               ns.pop();
           }
           NS[i]=(ns.isEmpty())? n: ns.peek() ;
           ns.push(i);
       }
       
       int[] res=new int[n];
       for(int i=0;i<n;i++){
           int in=NS[i]-PS[i]-1; //in is window size
           if(res[in-1]<arr[i]){ // as 0th index represent size 1 window size so on
               res[in-1]=arr[i];//thats why in-1
           }
       }
       
       for(int i=n-1;i>=0;i--){
           if(res[i]<min){
               res[i]=min;
           }
           else{
               min=res[i];
           }
       }
       
       return res;
    }
}
