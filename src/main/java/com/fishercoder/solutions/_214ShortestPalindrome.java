package com.fishercoder.solutions;

import static com.fishercoder.common.utils.CommonUtils.println;

/**
 214. Shortest Palindrome

 Given a string S, you are allowed to convert it to a palindrome
 by adding characters in front of it.
 Find and return the shortest palindrome you can find by performing this transformation.

 For example:

 Given "aacecaaa", return "aaacecaaa".

 Given "abcd", return "dcbabcd".
 */
public class _214ShortestPalindrome
{

    public static class Solution1
    {
        static public String shortestPalindrome(String s)
        {
            /*
            a -> a
            ab -> bab
            babc -> cbabc
            ababacbc -> cbabc

            aaaba

            find longest palindrome starts from left, then mirror the none palindrome part
             */

            if(s == null)
                return null;
            if(s.isEmpty())
                return "";

            int palindEnd = 0;
            for(int i = s.length()-1; i>=0; i--)
            {
                if(isPalindrome(s, i))
                {
                    palindEnd = i;
                    break;
                }
            }
            if(palindEnd == s.length()-1)
                return s;

            StringBuilder sb = new StringBuilder();
            sb.append(s.substring(palindEnd + 1));
            sb.reverse();
            sb.append(s);
            return sb.toString();
        }

        static public boolean isPalindrome(String s, int to)
        {
            for(int from =0; from<=to; from++, to--)
            {
                if(s.charAt(from) != s.charAt(to))
                    return false;
            }
            return true;
        }

    }

    public static void main(String[]st)
    {
        println(Solution1.shortestPalindrome("abacd"));
        println(Solution1.shortestPalindrome("a"));
    }

}
