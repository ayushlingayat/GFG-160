class Solution {
    // Function to find the next greater element for each element of the array.
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            int ans =0;
            for(int j=i;j<arr.length-1;j++){
                if(arr[i]<arr[j+1]){
                    list.add(arr[j+1]);
                    ans=1;
                    break;
                }
            }
            if(ans==0)
            list.add(-1);
        }
        return list;
    }
}

 
