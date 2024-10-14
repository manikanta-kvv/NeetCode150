package two_pointers;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TrappingRainWater {

    public static int trap(int[] height) {
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        int[] minLeftRight = new int[height.length];
        maxLeft[0] = 0;
        maxRight[height.length - 1] = 0;
        for(int i = 1; i < height.length; i++){
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }
        for(int i = height.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }

        System.out.println(Arrays.toString(maxLeft));
        System.out.println(Arrays.toString(maxRight));

        for(int i = 0; i < height.length; i++) {
            minLeftRight[i] = Math.min(maxLeft[i], maxRight[i]);
        }
        System.out.println(Arrays.toString(minLeftRight));

        int sum = 0;
        for(int i = 0; i < height.length; i++) {
            int currentSum = minLeftRight[i] - height[i];
            sum += (currentSum < 0) ? 0 : currentSum;
        }
        return sum;
    }

    public static int trap_ap2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        //leftmax contains value of the max element so far to the left of the current element
        int leftMax = height[left];
        //rightmax contains value of the max element so far to the right of the current element
        int rightMax = height[right];
        int sum = 0;
        while(left < right) {
            //as we have to find the most water, if leftmax element < rightmax element, then increment left by 1
            if(leftMax < rightMax) {
                left++;
                //if the current element > leftmax, update leftmax with max value
                leftMax = Math.max(leftMax, height[left]);
                //subtract current element value from leftmax, to get the water stored at current element (or index)
                sum += leftMax - height[left];
            }
            else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                sum += rightMax - height[right];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        int result = trap(nums);
        System.out.println(result);
        int result2 = trap_ap2(nums);
        System.out.println(result2);
    }
}
