package stack;

import java.util.Stack;

public class LargestRectangleInHistogram {

    /* for each and every element find the nse(next small element) and pse(previous small element)
     * find the length between nse and pse using the formula  = (nse - pse - 1)
     * calculate area of the length of the block using formula = element * (nse - (pse) - 1)
     * if the current element is less than the top element of the stack, means we found a nse for the top element of the stack
     * so we look back in the stack if we found pse for the top element of the stack
     * as we are calculating the area for the top element of the stack, element = top element of the stack
     * length will be (nse - pse - 1)
     * after looping through all elements of the stack, if the stack is not empty
     * then, we can say the those elements in the stack doesn't have nse for them, so take n as nse for these elements
     * pse will be top element of the stack until it is empty, it is empty, then pse will be -1
     * calculate the area same as above
     */

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int element = heights[stack.pop()];
                int nse = i;
                int pse = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max(maxArea, (element * (nse - (pse) - 1)));
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int nse = n;
            int element = heights[stack.pop()];
            int pse = stack.isEmpty() ? -1 : stack.peek();
            maxArea = Math.max(maxArea, (element * (nse - (pse) - 1)));
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        int result = largestRectangleArea(heights);
        System.out.println(result);
    }
}
