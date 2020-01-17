package com.fishercoder.solutions;

import static com.fishercoder.common.utils.CommonUtils.println;

/**

 188. Best Time to Buy and Sell Stock IV

 Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most k transactions.

 Note:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

 Example 1:
 Input: [2,4,1], k = 2
 Output: 2
 Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.

 Example 2:
 Input: [3,2,6,5,0,3], k = 2
 Output: 7
 Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
 Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.

 */
public class _188BestTimeBuySellStock4
{
    static class Solution1
    {
        /*
        i is 1th day, j is jth txn
        hold[i][j]
        unhold[i][j]

        hold[i][j] = max(hold[i-1][j], unhold[i-1][j-1] - price[i])
        unhold[i][j] = max(unhold[i-1][j], hold[i-1][j] + price[i])
         */
        static public int maxProfit(int k, int[] prices)
        {
            if(prices == null || prices.length==0 || k<=0)
                return 0;

            if(k>prices.length/2)
            {
                int max = 0;
                for(int i=1; i<prices.length; i++)
                    if(prices[i]>prices[i-1])
                        max += prices[i] - prices[i-1];
                return max;
            }


            int hold[][] = new int[prices.length][k + 1];
            int unhold[][] = new int[prices.length][k + 1];

            // first day, buy once, all -pricse[0]
            for(int i=0; i<k+1; i++)
                hold[0][i] = -prices[0];

            // first day, can't sell best profit is 0
            for(int i=0; i<k+1; i++)
                unhold[0][i] = 0;

            // 0 txn, 0 profit
            for(int i=0; i<prices.length; i++)
            {
                hold[i][0] = 0;
                unhold[i][0] = 0;
            }

            for(int i = 1; i<prices.length; i++)
            {
                for(int j = 1; j<k+1; j++)
                {
                    hold[i][j] = Math.max(hold[i - 1][j], unhold[i - 1][j - 1] - prices[i]);
                    unhold[i][j] = Math.max(unhold[i - 1][j], hold[i - 1][j] + prices[i]);
                }
            }

            int max = 0;
            for(int i=0; i<k+1; i++)
                max = Math.max(max, unhold[prices.length - 1][i]);
            return max;


        }
    }

    // wrong solution, can't k-- like this,
    static class Solution2
    {
        /*
        bought[i] = max(bought[i-1], canBuy[i-1] - price[i])
        canBuy[i] = max(canBuy[i-1], bought[i-1] + price[i])
        cantBuy[i] = max(cantBuy[i-1], canBuy[i-1])
        quota
         */
        static public int maxProfit(int k, int[] prices)
        {
            if(prices==null || prices.length==0 || k<1)
                return 0;

            int len = prices.length;
            int bought[] = new int[len];
            int sold[] = new int[len];
            bought[0] = -prices[0];
            sold[0] = 0;
            for(int i=1; i<len; i++)
            {
                if(k>0)
                {
                    if(sold[i-1]-prices[i] > bought[i-1])
                    {
                        bought[i] = sold[i-1]-prices[i];
                        k--;
                    }
                    else
                        bought[i] = bought[i - 1];

                    sold[i] = Math.max(sold[i - 1], bought[i - 1] + prices[i]);
                }
                else if(k<=0)
                {
                    bought[i] = bought[i-1];
                    sold[i] = Math.max(sold[i - 1], bought[i - 1] + prices[i]);
                }
            }
            return sold[len - 1];
        }
    }
    static public void main(String[] a)
    {
        println(Solution2.maxProfit(2, new int[] {3,2,6,5,0,3}));
        println(Solution1.maxProfit(2, new int[] {3,2,6,5,0,3}));
    }
}
