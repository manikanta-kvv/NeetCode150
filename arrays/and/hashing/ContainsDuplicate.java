package arrays.and.hashing;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(nums[i])) {
                return  true;
            }
            hashMap.put(nums[i], 1);
        }
        return  false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        boolean result = containsDuplicate(arr);
        System.out.println(result);
    }

}
