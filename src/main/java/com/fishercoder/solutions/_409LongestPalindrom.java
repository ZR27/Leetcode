package com.fishercoder.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * 409. Longest Palindrome
 *
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 *
 * Note:
 * Assume the length of given string will not exceed 1,010.
 *
 * Example:
 * Input:
 * "abccccdd"
 *
 * Output:
 * 7
 *
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class _409LongestPalindrom
{
  public static class Solution1 {
    public int longestPalindrome(String s)
    {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray())
        {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        boolean hasOdd = false;
        int re = 0;
        for(Integer i : map.values())
        {
            if(i%2==1)
            {
                hasOdd = true;
                re += i-1;
            }
            else
                re += i;
        }
        if(hasOdd)
            re+=1;
        return re;


    }
  }
}
