package sliding_window;

public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minStock = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < minStock) minStock = prices[i];
            int currentProfit = prices[i] - minStock;
            if(currentProfit > maxProfit) {
                maxProfit = currentProfit;
            }
        }
        return maxProfit;
    }


    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        int result = maxProfit(nums);
        System.out.println(result);
    }
}
