package arrays_hashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        //populate set with all elements from array
        for(int num : nums) hashSet.add(num);
        int longest = 0;
        int count = 0;
        //check for a starting element to find the longest consecutive sequence
        for(int num : hashSet) {
            //if the previous element of the current element is not present in the hashset,
            //then the current element might be the starting element of a sequence and its count will start from 1
            if(!hashSet.contains(num-1)) {
                count = 1;
                //check for its sub-sequence by incrementing the current element by 1
                //if the next element is present in the hashset, then increment count, num by 1 till the next element is not present
                while(hashSet.contains(num + 1)) {
                    count++;
                    num++;
                }
                //store longest value out of count and longest
                longest = Math.max(count, longest);
            }
        }

        return  longest;

    }

    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        int result = longestConsecutive(nums);
        System.out.println(result);
    }
}
