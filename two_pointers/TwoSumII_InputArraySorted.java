package two_pointers;

import java.util.Arrays;

public class TwoSumII_InputArraySorted {


    public static int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        while(start < end) {
            int sum = numbers[start] + numbers[end];
            if(sum == target) {
                return new int[]{start + 1, end + 1};
            }
            else if(sum > target) {
                end--;
            }
            else {
                start++;
            }
        }
        return new int[]{-1, -1};
    }


    public static void main(String[] args) {
        int[] nums = {-1,0};
        int target = -1;
        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
