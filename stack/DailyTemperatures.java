package stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        //stack to store if the current element is not greater than top element of stack
        //thus, the stack contains elements in monotonic decreasing order
        //stack = stack(int[element, index])
        Stack<int[]> stack = new Stack<>();
        for(int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[i] > stack.peek()[0]) {
                //take the distance from top element of the stack and the current element index
                int distance = i - stack.peek()[1];
                //as we found the greater element in the stack than current element
                //we have to populate the topElement Index in ans array with the distance
                int topElementIndex = stack.peek()[1];
                //remove the top element from stack, as we done with calculating distance for this element
                stack.pop();
                //populating ans array at topElementIndex with the distance
                ans[topElementIndex] = distance;
            }
            stack.add(new int[]{temperatures[i], i});
        }


        return ans;
    }

    public static void main(String[] args) {
        int[] temperatures = {30,40,50,60};
        int[] result = dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(result));
    }
}
