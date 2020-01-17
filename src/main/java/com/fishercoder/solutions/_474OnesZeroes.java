package com.fishercoder.solutions;

/**
 * 474. Ones and Zeroes
 *
 * In the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.
 * For now, suppose you are a dominator of m 0s and n 1s respectively.
 * On the other hand, there is an array with strings consisting of only 0s and 1s.
 * Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s.
 * Each 0 and 1 can be used at most once.

 Note:

 The given numbers of 0s and 1s will both not exceed 100. The size of given string array won't exceed 600.

 Example 1:
 Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
 Output: 4
 Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are “10,”0001”,”1”,”0”

 Example 2:
 Input: Array = {"10", "0", "1"}, m = 1, n = 1
 Output: 2
 Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".

 */
public class _474OnesZeroes
{
    public static class Solution1
    {
        public int findMaxForm(String[] strs, int m, int n)
        {
            /*

            // ! wrong way to analyse, m and n are states, not varibles.

            {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
            {"10", "0", "1"}, m = 1, n = 1

            variable: number of formed, num of zero, num of one

            formed
            canForm
            cantForm

            formedCount
            unformedCount
            formedZero
            unformedZero
            formedOne
            unformedOne

            if(canForm)
            {
                formed[i] = max(formed[i-1], unformed[i-1]) + 1;
                formedOne[i] -= x;
                formedZero[i] -= y;
            }
            else
            {
                formed[i] = max(formed[i-1], unformed[i-1]);
            }

            unformed[i] = max(formed[i-1], unformed[i-1]);


            */

            /*
            // ! don't understand the part why need to do bottom up iteration

            // m, n are states
            // formNum[i][j] is the max possible count of formed string formed with i zeros and j ones.
            int formNum[][] = new int[m+1][n+1];
            */


            /*
                state: 1, number of strings processed, x. 2, number of zeros used, i. 3, number of ones used, j.
                value: max count of string formed.
                formNum's length need all +1 as need to store inital state, no string processed, no zero or one used.


                int zeroCount of x string
                int oneCount
                formNum[x][i][j] = max(formNum[x-1][i-zeroCount][j-oneCount]+1, formNum[x-1][i][j])
             */

            int formNum[][][] = new int[strs.length+1][m+1][n+1];
            for(int i=0; i<=m; i++)
                for(int j=0; j<=n; j++)
                    formNum[0][i][j] = 0;

            for(int x=1; x<strs.length+1; x++)
            {
                int zeros = count(strs[x-1], '0');
                int ones = count(strs[x-1], '1');

                for(int i=0; i<=m; i++)
                    for(int j=0; j<=n; j++)
                    {
                        if(i>=zeros && j>=ones)
                            formNum[x][i][j] = Math.max(formNum[x - 1][i][j], formNum[x - 1][i - zeros][j - ones] + 1);
                        else
                            formNum[x][i][j] = formNum[x - 1][i][j];
                    }
            }

            return formNum[strs.length][m][n];
        }

        private int count(String orig, char c)
        {
            int re = 0;
            for(char x : orig.toCharArray())
                if(x == c)
                    re++;
            return re;
        }

    }

}
