package arrays_hashing;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        //bucket sort algorithm
        //using bucket to keep track of all elements with index based frequency
        //for example bucket[frequency] stores list of elements at index of frequency
        //bucket[4] = [1,2] means, elements [1,2] have frequency 4
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int eachKey : hashMap.keySet()) {
            int freq = hashMap.get(eachKey);
            //if bucket has no element at freq's index, initiate an empty array list
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(eachKey);
        }

        int[] freqElements = new int[k];
        int counter = 0;
        //traverse from last index to first, to get K most frequent elements
        for (int pos = bucket.length - 1; pos >= 0 && counter < k; pos--) {
            if (bucket[pos] != null) {
                for (int ele : bucket[pos]) {
                    freqElements[counter++] = ele;
                }
            }
        }

        return freqElements;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,-1,2,-1,2,3};
        int k = 2;
        int[] result = topKFrequent(nums, k);
        System.out.println(Arrays.toString(result));
    }
}