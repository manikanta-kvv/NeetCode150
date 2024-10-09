package arrays_hashing;

import java.util.Arrays;
import  java.util.Map;
import  java.util.HashMap;
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(target - nums[i])) {
                return  new int[] {hashMap.get(target - nums[i]), i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {3, 3};
        int target = 6;
        int[] resultArray = twoSum(nums, target);
        System.out.println(Arrays.toString(resultArray));
    }

}
