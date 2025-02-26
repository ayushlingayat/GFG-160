class Solution {
    static boolean isBalanced(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(stack.empty())
                stack.push(ch);
            else if(stack.peek()+1==ch||stack.peek()+2==ch)
                stack.pop();
            else
                stack.push(ch);
        }
        return stack.empty();
    }
}
