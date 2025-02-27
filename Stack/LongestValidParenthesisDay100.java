class Solution {
    static int maxLength(String s) {
     
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);
        int result=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }

             else{

                stack.pop(); 

                if(!stack.isEmpty()){
                   result=Math.max(result,i-stack.peek()); 
                }
                else{
                    stack.push(i);
                }
            }
        }
        return result;
    }
}
