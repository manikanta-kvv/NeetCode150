package arrays_hashing;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        //prefixArray stores the product of prefix elements till the current index
        int[] prefixArray = new int[n];
        //suffixArray stores the product of suffix elements till the current index
        int[] suffixArray = new int[n];
        //product of corresponding index elements from prefixArray and suffixArray, can be stored in productArray
        int[] productArray = new int[n];
        prefixArray[0] = 1;
        suffixArray[n - 1] = 1;
        for(int i = 1; i < n; i++) {
            prefixArray[i] = prefixArray[i-1] * nums[i-1];
        }
        for(int i = n - 2; i >= 0; i--) {
            suffixArray[i] = suffixArray[i+1] * nums[i+1];
        }

        for(int i = 0; i < n; i++) {
            productArray[i] = prefixArray[i] * suffixArray[i];
        }

        return  productArray;
    }

    public static void main(String[] args) {
        int[] nums = {-1,1,0,-3,3};
        int[] result = productExceptSelf(nums);
        System.out.println(Arrays.toString(result));
    }
}
