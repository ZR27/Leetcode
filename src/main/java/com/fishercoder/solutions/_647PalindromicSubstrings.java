package com.fishercoder.solutions;

import static com.fishercoder.common.utils.CommonUtils.println;

/**
 * 647. Palindromic Substrings
 *
 *  Given a string, your task is to count how many palindromic substrings in this string.
 *  The substrings with different start indexes or end indexes are counted
 *  as different substrings even they consist of same characters.

 Example 1:
 Input: "abc"
 Output: 3
 Explanation: Three palindromic strings: "a", "b", "c".

 Example 2:
 Input: "aaa"
 Output: 6
 Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

 Note:
 The input string length won't exceed 1000.

 */

public class _647PalindromicSubstrings
{

    public static class Solution1
    {
        /*
        a:1
        aa: 1+1+1
        aaa: 3+1+1+1
        aaaa:6+all palindrome ends with charAt j
        ab: 2
        ab+b: 2+1+1
        abb+b: 4 + 1+ 1 + 1
        abbb+c: 7 + 1
        abbbc+b: 8 + 1 + 1
        abbbcb+b: 10 + 1 + 1 + 1
        abcbacabcd

        fixed + dynamic
        fixed[i] = fixed[i-1] + 1
        a: 1 + 0 = 1
        aa: 2 + 1 = 3
        aa+a: 4 + 2 = 6
        aaa+a: 7 + 3 = 10

        ab: 1+1=2
        ab+b: 3 + 1 = 4
        abb+a: 5 + 1 = 6
        abb+b: 5 + 2 = 7
        abab+a

        numSub[i] = numSub[i-1] + numOfPalindEndsWithCharAt[i]

         */
        static public int countSubstrings(String s)
        {
            if(s==null || s.isEmpty())
                return 0;
            int re = 0;
            for(int i=0; i<s.length(); i++)
            {
                re += numOfPalindEndsWithCharAt(s, i);
            }
            return re;
        }

        static public int numOfPalindEndsWithCharAt(String s, int end)
        {
            int re = 0;
            for(int i = end; i>=0; i--)
            {
                if(isParlindr(s, i, end))
                    re++;
            }
            return re;
        }
        static public boolean isParlindr(String s, int start, int end)
        {
            while(start<=end)
            {
                if(s.charAt(start) != s.charAt(end))
                    return false;
                start++; end--;
            }
            return true;
        }

    }
    public static class Solution2
    {
        static public int countSubstrings(String s)
        {
            if(s==null || s.isEmpty())
                return 0;
            boolean[][] isPalind = new boolean[s.length()+1][s.length()+1];
            int count=0;
            for(int i = s.length()-1; i>=0; i--)
            {
                for(int j=i; j<s.length(); j++)
                {
                    isPalind[i][j] = s.charAt(i) == s.charAt(j) && (j-i<3 || isPalind[i+1][j-1]);
                    if(isPalind[i][j])
                        count++;
                }
            }
            return count;
        }

    }

    public static void main(String[]st)
    {
        println(Solution1.countSubstrings("a"));
        println(Solution1.countSubstrings("aba"));
        println(Solution2.countSubstrings("aba"));
    }

}
