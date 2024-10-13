package two_pointers;

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int maxArea = 0;
        //most water = (noOfElements in between start and end index) * min of elements at start, end indices
        while(start < end) {
            //
            int noOfElementsBetween = end - start;
            int areaCovered = Math.min(height[start], height[end]);
            int totalArea = noOfElementsBetween * areaCovered;
            if(totalArea > maxArea) maxArea = totalArea;
            //as we want most water, we increment the index of min element
            if(height[start] < height[end]) start++;
            //or decrement the index of min element
            else end--;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] nums = {1,1};
        int result = maxArea(nums);
        System.out.println(result);
    }
}
