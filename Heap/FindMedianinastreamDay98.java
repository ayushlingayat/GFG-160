class Solution {
    public ArrayList<Double> getMedian(int[] arr) {
        // code here
        PriorityQueue<Integer>maxHeap=new PriorityQueue<>
        (Collections.reverseOrder());
        PriorityQueue<Integer>minHeap=new PriorityQueue<>();
        ArrayList<Double>list=new ArrayList<>();
        for(int val:arr){
            if(maxHeap.isEmpty()||maxHeap.peek()>=val){
                maxHeap.add(val);
            }else{
                minHeap.add(val);
            }
            if(maxHeap.size()>minHeap.size()+1){
                minHeap.add(maxHeap.poll());
            }else if(maxHeap.size()<minHeap.size()){
                maxHeap.add(minHeap.poll());
            }
            if(maxHeap.size()==minHeap.size()){
                list.add(maxHeap.peek()/2.0+minHeap.peek()/2.0);
            }else{
                list.add((double)maxHeap.peek());
            }
        }
        return list;
    }

}
