package binary_search;

public class KokoEatingBananas {

    /* each element in the piles array denotes each pile
     * for eating each pile, koko takes 1 hour if pile value <= h (total hours koko has to finish eating of all piles)
     * k is the eating speed to koko per hour
     * if we take k is equals to max element from piles array, then koko can finish all piles
     * but we need to find the min eating speed k
     * so, take k (eating speed) from 1 to max element of piles array
     * and for every k, we check the time taken to complete the all piles
     * time taken for each pile = pile value / eating speed
     * here, as we taking k from 1 to max element of piles array
     * instead of checking from 1, which gives O(N) as time complexity
     * we use binary search, and taking the middle element as eating speed
     * if the middle eating speed covers all piles under given hours i.e., time taken by koko with middle element value as speed <= h
     * so the middle value satisfy the condition of covering all piles
     * we need to check the minimum speed, so we will check the left side of the eating speed i.e., 1 to middle element speed
     * the search goes on and for every time taken <= h, we update the minSpeed
     * if the timeTaken > h, then we need to check on the right side, k from middle element speed to max element of piles
     *
    * */

    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = maxPile(piles);
        //by default taking the max element of piles as minSpeed
        int minSpeed = right;
        while(left <= right) {
            int middlePileSpeed = (left + right) / 2;
            int timeTaken = 0;
            //calculating the time taken by koko with speed of middlePileSpeed
            //taking the ceil value of pile/middlePileSpeed gives the time to cover the pile with middlePileSpeed
            for(int pile : piles) {
                timeTaken += Math.ceil((double) pile/middlePileSpeed);
            }
            //if the timeTaken <= h, then we may find minSpeed on left side
            if(timeTaken <= h) {
                //check on left side by modifying right with middle value
                minSpeed = middlePileSpeed;
                right = middlePileSpeed - 1;
            }
            //if the timeTaken > h, then we may find minSpeed on right side
            else {
                //check on right side by modifying left with middle value
                left = middlePileSpeed + 1;
            }
        }
        return minSpeed;
    }

    public static int maxPile(int[] piles) {
        int max = Integer.MIN_VALUE;
        for(int pile : piles) {
            if(pile > max) max = pile;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;
        int result = minEatingSpeed(piles, h);
        System.out.println(result);
    }
}
