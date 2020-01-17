package com.fishercoder.solutions;

public class _714BestTimeBuySellStockTxnFee
{
    static class Solution1
    {
        public int maxProfit(int[] prices, int fee)
        {
            /*
            hold[i] = max(hold[i-1], unhold[i-1] - price[i] - fee)
            unhold[i] = max(unhold[i-1], hold[i-1] + price[i])
             */
            if(prices==null || prices.length == 0)
                return 0;

            int hold[] = new int[prices.length];
            int unhold[] = new int[prices.length];
            hold[0] = -prices[0] - fee;
            unhold[0] = 0;
            for(int i=0; i<prices.length; i++)
            {
                hold[i] = Math.max(hold[i - 1], unhold[i - 1] - prices[i] - fee);
                unhold[i] = Math.max(unhold[i - 1], hold[i - 1] + prices[i]);
            }

            return unhold[prices.length - 1];
        }
    }
}
