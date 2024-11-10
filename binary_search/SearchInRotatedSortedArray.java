package binary_search;

public class SearchInRotatedSortedArray {


    public static int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(nums[mid] == target) return mid;
            //checking if left half of array is sorted
            if(nums[low] <= nums[mid]) {
                //checking if target lies within the left half of the array, so eliminate right half of the array
                if(nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            //right half of array is sorted
            else {
                //checking if target lies within the right half of the array, so eliminate left half of the array
                if(nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 5;
        int result = search(nums, target);
        System.out.println(result);
    }
}
