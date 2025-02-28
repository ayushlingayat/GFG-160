class Solution {
    private class Pair{
        int val;
        int min;
        Pair(int val, int min){
            this.val = val;
            this.min = min;
        }
    }
    public Solution() {}

    Stack<Pair> minStack = new Stack<>();
    
    public void push(int x) {
        if(minStack.isEmpty()){
            minStack.push(new Pair(x, x));
        }else{
            minStack.push(new Pair(x, Math.min(x, minStack.peek().min)));
        }
        
    }

    // Remove the top element from the Stack
    public void pop() {
        if(minStack.isEmpty()) return;
        minStack.pop();
    }

    // Returns top element of the Stack
    public int peek() {
        if(minStack.isEmpty()) return -1;
        return minStack.peek().val;
    }

    // Finds minimum element of Stack
    public int getMin() {
        if(minStack.isEmpty()) return -1;
        return minStack.peek().min;
    }
}
