package stack;

import java.util.Objects;
import java.util.Stack;

public class EvaluateReversePolishNotation {

    public static int evalRPN(String[] tokens) {
        Stack<Integer> numberStack = new Stack<>();
        for(String st : tokens) {
            if(st.equals("+")) {
                numberStack.add(numberStack.pop() + numberStack.pop());
            }
            else if(st.equals("-")) {
                int firstTop = numberStack.pop();
                int secondTop = numberStack.pop();
                numberStack.add(secondTop - firstTop);
            }
            else if(st.equals("*")) {
                numberStack.add(numberStack.pop() * numberStack.pop());
            }
            else if(st.equals("/")) {
                int firstTop = numberStack.pop();
                int secondTop = numberStack.pop();
                numberStack.add(secondTop / firstTop);
            }
            else {
                numberStack.add(Integer.parseInt(st));
            }
        }
        return numberStack.pop();
    }


    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        int result = evalRPN(tokens);
        System.out.println(result);
    }
}
