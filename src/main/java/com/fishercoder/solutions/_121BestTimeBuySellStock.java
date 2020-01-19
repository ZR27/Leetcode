package com.fishercoder.solutions;

public class _121BestTimeBuySellStock
{
    public int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int profit = 0;
        for(int i=1; i<prices.length; i++)
        {
            if(prices[i] < buyPrice)
                buyPrice = prices[i];
            else
                profit = Math.max(prices[i]-buyPrice, profit);
        }
        return profit;
    }

}
