package binary_search;

public class BinarySearch {

    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            //search in left side
            if(nums[mid] > target) end = mid - 1;
            //search in right side
            else if(nums[mid] < target) start = mid + 1;
            else return mid;

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        int result = search(nums, target);
        System.out.println(result);
    }
}
