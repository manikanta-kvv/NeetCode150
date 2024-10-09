package arrays_hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {

    //approach 1
    public static boolean containsDuplicate_ap1(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(nums[i])) {
                return  true;
            }
            hashMap.put(nums[i], 1);
        }
        return  false;
    }

    //approach 2
    public static boolean containsDuplicates_ap2(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]) return  true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        boolean result = containsDuplicate_ap1(arr);
        System.out.println(result);
    }

}
