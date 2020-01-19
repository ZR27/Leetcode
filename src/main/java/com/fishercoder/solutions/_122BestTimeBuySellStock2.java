package com.fishercoder.solutions;

public class _122BestTimeBuySellStock2
{
    // 7, 5, 4, 1, 3, 5, 4, 6, 1, 1, 2, 5, 6, 7, 3, 1
    public int maxProfit(int[] prices) {

        if(prices == null || prices.length==0)
            return 0;

        int buyPrice = prices[0];
        int total = 0;
        int profit = 0;
        for(int i=1; i<prices.length; i++)
        {
            if(prices[i]<prices[i-1])
            {
                total += profit;
                profit = 0;
                buyPrice = prices[i];
                continue;
            }

            if(prices[i] < buyPrice)
                buyPrice = prices[i];
            else
                profit = Math.max(prices[i]-buyPrice, profit);
        }
        total += profit;
        return total;
    }

}
