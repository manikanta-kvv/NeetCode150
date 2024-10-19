package sliding_window;

import java.util.*;

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {

        int[] ansArray = new int[nums.length - k + 1];
        int index = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < nums.length; i++) {
            //if dequeue is not empty and remove numbers out of range of the window
            //as dequeue stores index of elements, if the index is out of range of the current sliding winddow
            //then pop the first element from the dequeue to match the current window length
            if(!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            //here the dequeue always stores the maximum element at front
            //so if the current element > maximum element at front of dequeue, it means we found another maximum element
            //so delete the values < current element from dequeue and push the current element to dequeue to store it as maximum
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            //storing index of element in the dequeue
            deque.offer(i);
            //if the current window length >= (given k - 1) length, we populate ans array with each element popped out from dequeue
            if(i >= (k - 1)) {
                ansArray[index++] = nums[deque.peekFirst()];
            }
        }


        return ansArray;

    }


    public static void main(String[] args) {
        int[] nums = {7,2,4};
        int k = 2;
        int[] result = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(result));
    }
}
