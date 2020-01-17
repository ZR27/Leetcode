package com.fishercoder.solutions;

import javax.print.attribute.standard.PrinterLocation;

import static com.fishercoder.common.utils.CommonUtils.println;

/**
 * 5. Longest Palindromic Substring
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

 Example:
 Input: "babad"
 Output: "bab"
 Note: "aba" is also a valid answer.

 Example:
 Input: "cbbd"
 Output: "bb"
 */
public class _5LongestPalindromicSubstring
{

    public static class Solution1
    {
        /*
        abacaba
        ksabbadi
        xabccbax

        isPalind[i][j], substring between i and j is palindrome or not.

        isPalind[i][j] = charAt(i) == charAt(j) && isPalind[i+1][j-1]
        i loop from right as it depends on i+1, j loop from left as it depends j-1

         */
        static public String longestPalindrome(String s)
        {
            if(s==null)
                return null;
            if(s.isEmpty())
                return "";

            boolean[][] isPalind = new boolean[s.length()][s.length()];
            int maxLeft = 0;
            int maxRight = 0;

            for(int i=s.length()-2; i>=0; i--)
            {
                char left = s.charAt(i);
                for(int j=i; j<s.length(); j++)
                    if(left == s.charAt(j) && (j-i<3 || isPalind[i+1][j-1]))
                    {
                        isPalind[i][j] = true;
                        if(j-i>maxRight-maxLeft)
                        {
                            maxLeft = i;
                            maxRight = j;
                        }
                    }
            }

            return s.substring(maxLeft, maxRight+1);
        }

    }

    public static void main(String[]st)
    {
        println(Solution1.longestPalindrome("abacd"));
        println(Solution1.longestPalindrome("fssabacdcabafe"));
        println(Solution1.longestPalindrome("e"));
        println(Solution1.longestPalindrome("aec"));
    }
}
