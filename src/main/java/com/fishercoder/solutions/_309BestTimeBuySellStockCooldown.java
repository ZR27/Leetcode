package com.fishercoder.solutions;

/**
 * 309. Best Time to Buy and Sell Stock with Cooldown
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 Example:

 prices = [1, 2, 3, 0, 2]
 maxProfit = 3
 transactions = [buy, sell, cooldown, buy, sell]
 */
public class _309BestTimeBuySellStockCooldown
{
    // bought -> cooldown
    // cooldown -> canBuy
    // canBuy -> bought
    //bought[i] = max(bought[i-1], canBuy[i-1] - price[i]
    //cool[i] = bought[i-1] + price[i]
    //canBuy[i] = max(canBuy[i-1], cool[i-1])

    /*
    bought[0] = -1 * prices[0];
    canBuy[0] = 0
    cool[0] = MIN
    */

    public int maxProfit(int[] prices)
    {
        if(prices == null || prices.length==0)
            return 0;

        int[] bought = new int[prices.length];
        int[] canBuy = new int[prices.length];
        int[] cooldown = new int[prices.length];

        bought[0] = -1*prices[0];
        canBuy[0] = 0;
        cooldown[0] = Integer.MIN_VALUE;

        for(int i =1; i<prices.length; i++)
        {
            bought[i] = Math.max(bought[i - 1], canBuy[i - 1] - prices[i]);
            cooldown[i] = bought[i - 1] + prices[i];
            canBuy[i] = Math.max(canBuy[i-1], cooldown[i-1]);
        }
        return Math.max(canBuy[prices.length - 1], cooldown[prices.length - 1]);
    }
}
