package two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < n; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            //two pointers
            int j = i + 1;
            int k = n - 1;
            while(j < k) {
                int sum = nums[i] +nums[j] + nums[k];
                if(sum > 0) {
                    k--;
                }
                else if(sum < 0) {
                    j++;
                }
                else {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(nums[i]);
                    tempList.add(nums[j]);
                    tempList.add(nums[k]);
                    ansList.add(tempList);
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j - 1]) j++;
                    while(j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }
        return ansList;
    }


    public static void main(String[] args) {
        int[] nums = {0,0,0};
        List<List<Integer>> resultList = threeSum(nums);
        System.out.println(resultList);
    }
}
