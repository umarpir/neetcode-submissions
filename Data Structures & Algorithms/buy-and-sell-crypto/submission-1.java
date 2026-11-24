class Solution {
    public int maxProfit(int[] prices) {
        
        int minVal = prices[0];
        int maxProfit = 0;

        for(int sell : prices)
        {
            minVal = Math.min(sell, minVal);
            maxProfit = Math.max(maxProfit, sell - minVal);
        }
         return maxProfit;
    }
}
