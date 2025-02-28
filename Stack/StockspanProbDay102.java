class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {

        //Time complexity-O(N) and Monotonic decreasing stack algorithm is used here

//Instead of comparing each day with all previous days (like in the brute-force //approach), we use a stack to store indices of previous days — but only those days //where the stock price was higher than or equal to today’s price. This lets us efficiently //“jump over” lower prices.

        ArrayList<Integer> list=new ArrayList<>();
        Stack<Integer> st=new Stack<>();
        list.add(1);
        st.push(0);//pushing index
        
        for(int i=1;i<arr.length;i++){
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                st.pop();
            }
            list.add(st.isEmpty()? (i+1) : (i - st.peek()));
            st.push(i);
        }
        return list;

        // Time complexity-O(n) and brute force
        // ArrayList<Integer> list=new ArrayList<>();
        // list.add(1);
        
        // for(int i=1;i<arr.length;i++){
        //     int count=1;
        //     int j=i-1;
        //     while( j>=0  && arr[j]<=arr[i]){
        //         count++;
        //         j--;
        //     }
        //     list.add(count);
            
        // }
        // return list;
    }
