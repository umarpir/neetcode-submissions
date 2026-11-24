class Solution {
    public int maxProfit(int[] prices) {
        
        int minVal = prices[0];
        int maxProfit = 0;

        for(int price: prices){
            minVal = Math.min(price, minVal);
            int currentProfit = price - minVal;
            maxProfit = Math.max(currentProfit, maxProfit);
        }

        return maxProfit;
    }
}
