package stack;

import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(Character ch : s.toCharArray()) {
            //open brackets so push to stack
            if(ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            else{
                if(!stack.isEmpty()) {
                    if((ch == ')' && stack.peek() == '(')
                            || (ch == ']' && stack.peek() == '[')
                            || (ch == '}' && stack.peek() == '{')) {
                        stack.pop();
                    }
                    else return false;
                }
                else return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "([])";
        boolean result = isValid(s);
        System.out.println(result);
    }
}
