import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];

            if (s.equals("+")) {
                st.push(st.pop() + st.pop());
            } 
            else if (s.equals("-")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b - a);
            } 
            else if (s.equals("*")) {
                st.push(st.pop() * st.pop());
            } 
            else if (s.equals("/")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b / a);
            }
            else {
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }
}