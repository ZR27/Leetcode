package com.fishercoder.solutions;

import static com.fishercoder.common.utils.CommonUtils.println;

/**
 * 516. Longest Palindromic Subsequence
 *
 * Given a string s, find the longest palindromic subsequence's length in s.
 * You may assume that the maximum length of s is 1000.

 Example 1:
 Input:
 "bbbab"
 Output:
 4
 One possible longest palindromic subsequence is "bbbb".

 Example 2:
 Input:
 "cbbd"
 Output:
 2
 One possible longest palindromic subsequence is "bb".
 */
public class _516LongestPalindromicSubsequence
{

    public static class Solution1
    {
        static public int longestPalindromeSubseq(String s)
        {
        /*
            don't understand why, but
            maxLen[i][j] = s.charAt(i) == s.charAt(j) ? maxLen[i+1][j-1] + 2 : max( maxLen[i+i][j], maxLen[i][j-1])
         */

            if(s == null && s.isEmpty())
                return 0;

            int[][] maxLen = new int[s.length()+1][s.length()+1];
            for(int i = s.length()-1; i>=0; i--)
            {
                char left = s.charAt(i);
                maxLen[i][i] = 1;
                for(int j=i+1; j<s.length(); j++)
                {
                    if(left == s.charAt(j))
                        maxLen[i][j] = maxLen[i+1][j-1] + 2;
                    else
                        maxLen[i][j] = Math.max(maxLen[i+1][j], maxLen[i][j-1]);
                }
            }
            return maxLen[0][s.length() - 1];
        }
    }


    public static void main(String[]st)
    {
        println(Solution1.longestPalindromeSubseq("abacdaa"));
        println(Solution1.longestPalindromeSubseq("a"));
    }
}
