package stack;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        //while pushing the value, check the minimum value from minStack
        //if the value from minStack is minimum, update the top of minStack with minimum
        //or push the current minimum value again into the minStack
        stack.push(val);
        //if the minStack is empty, consider current value as minimum and push it to minStack
        //else compare the current value and top element of the minStack(minStack.peek())
        val = Math.min(val, minStack.isEmpty() ? val : minStack.peek());
        //now push the minVal stored in value to the minStack
        minStack.push(val);
    }

    public void pop() {
        //when we pop the element from stack, pop the element from minStack as well
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());
    }
}
