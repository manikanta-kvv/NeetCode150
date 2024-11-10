package binary_search;

public class FindMinimumInRotatedSortedArray {

    public static int findMin(int[] nums) {
        int minValue = Integer.MAX_VALUE;
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            //as array is sorted and rotated,
            //if the min value present in the left half, update minValue and look for minValue in right half
            if(nums[low] <= nums[mid]) {
                minValue = Math.min(nums[low], minValue);
                low = mid + 1;
            }
            //else look for minValue in right half
            else {
                minValue = Math.min(nums[mid], minValue);
                high = mid - 1;
            }

        }
        return minValue;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        int result = findMin(nums);
        System.out.println(result);
    }
}
