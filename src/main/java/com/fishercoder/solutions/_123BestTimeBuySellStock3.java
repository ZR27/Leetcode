package com.fishercoder.solutions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 123. Best Time to Buy and Sell Stock III
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */

public class _123BestTimeBuySellStock3
{

    public static class Solution1 {

        // canBuy2 -> bought1
        // bought1 -> canBuy1
        // canBuy1 -> bought2
        // bought2 -> canBuy0

        /*
        canBuy2 = 0
        bought1[i] = max(bougth1[i-1], -price[i])
        canBuy1[i] = max(canBuy1[i-1], bought1[i-1] + price[i])
        bought2[i] = max(bought2[i-1], canBuy1[i-1] - price[i])
        canBuy0[i] = max(canBuy0[i-1], bought2[i-1] + price[i])
         */
        static public int maxProfit(int[] arr)
        {
            if(arr == null || arr.length == 0)
                return 0;

            int len = arr.length;
            int bought1[] = new int[len];
            int canBuy1[] = new int[len];
            int bought2[] = new int[len];
            int canBuy0[] = new int[len];

            bought1[0] = -arr[0];
            canBuy1[0] = 0;
            bought2[0] = Integer.MIN_VALUE;
            canBuy0[0] = 0;

            for(int i =1; i<len; i++)
            {
                bought1[i] = Math.max(bought1[i-1], -arr[i]);
                canBuy1[i] = Math.max(canBuy1[i-1], bought1[i-1] + arr[i]);
                bought2[i] = Math.max(bought2[i-1], canBuy1[i-1] - arr[i]);
                canBuy0[i] = Math.max(canBuy0[i-1], bought2[i-1] + arr[i]);

            }

            return Math.max(canBuy0[len - 1], canBuy1[len-1]);

        }
    }

    // this is a wrong solution, it tried to capture all up trends and sort,
    // but two combined up trends may give an even higher profit.
    public static class Solution2 {

        // wrong
        static public int maxProfit(int[] arr)
        {
            if(arr == null || arr.length == 0)
                return 0;


            int low = arr[0];
            int curProfit = 0;

            List<Integer> profits = new ArrayList<>();
            for(int i =1; i<arr.length; i++)
            {
                if(arr[i]<arr[i-1])
                {
                    profits.add(curProfit);
                    low = arr[i];
                    curProfit = 0;
                    continue;
                }

                if(arr[i] < low)
                    low = arr[i];
                else
                    curProfit = Math.max(curProfit, arr[i] - low);
            }
            profits.add(curProfit);
            Collections.sort(profits);
            Collections.reverse(profits);
            int re = 0;
            for(int i =0; i<2 && i<profits.size(); i++)
                re += profits.get(i);

            return re;

        }
    }

    static public void main(String[] a)
    {
        System.out.println(Solution1.maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(Solution2.maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(Solution1.maxProfit(new int[]{1,2,4,2,5,7,2,4,9,0}));
        System.out.println(Solution2.maxProfit(new int[]{1,2,4,2,5,7,2,4,9,0}));
    }
}