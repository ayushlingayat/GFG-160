
class Solution {
    private static boolean isOperand(String s) {
        // Check if the string represents a valid integer
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public int evaluate(String[] arr) {
        // code here
        Stack<Integer> st = new Stack<>();

        for (String s : arr) {
            if (isOperand(s)) {
                st.push(Integer.parseInt(s));
            } else {
                // Ensure the stack has at least two elements before popping
                if (st.size() < 2) {
                    throw new IllegalArgumentException("Invalid expression: not enough operands");
                }

                int num2 = st.pop();
                int num1 = st.pop();

                int result = 0;
                char operator = s.charAt(0);

                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        if (num2 == 0) {
                            throw new ArithmeticException("Division by zero");
                        }
                        result = num1 / num2;
                        break;
                    case '%':
                        if (num2 == 0) {
                            throw new ArithmeticException("Modulo by zero");
                        }
                        result = num1 % num2;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + operator);
                }
                
                st.push(result);
            }
        }
        if (st.size() != 1) {
            throw new IllegalArgumentException("Invalid expression: too many operands");
        }

        return st.pop();
    }
}
