package com.fishercoder.solutions;

import java.util.*;

/**336. Palindrome Pairs
 *
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

 Example 1:
 Given words = ["bat", "tab", "cat"]
 Return [[0, 1], [1, 0]]
 The palindromes are ["battab", "tabbat"]
 Example 2:
 Given words = ["abcd", "dcba", "lls", "s", "sssll"]
 Return [[0, 1], [1, 0], [3, 2], [2, 4]]
 The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
 */
public class _336PalindromePairs
{

    public static class Solution1
    {
        public List<List<Integer>> palindromePairs(String[] words)
        {
            List<List<Integer>> pairs = new ArrayList();
            for(int i = 0; i<words.length; i++)
            {
                for(int j=0; j<words.length; j++)
                {
                    if(i == j)
                        continue;
                    if(isPalind(words[i], words[j]))
                    {
                        List<Integer> pair = new ArrayList<>();
                        pair.add(i);
                        pair.add(j);
                        pairs.add(pair);
                    }

                }
            }
            return pairs;
        }

        public boolean isPalind(String s1, String s2)
        {
            int len = s1.length() + s2.length();

            for(int l=0, r=len-1; l<=r; l++, r--)
            {
                char charl = l < s1.length() ? s1.charAt(l) : s2.charAt(len - l);
                char charr = r < s1.length() ? s1.charAt(r) : s2.charAt(r - s1.length());
                if(charl!=charr)
                    return false;
            }
            return true;
        }

        public boolean isPalind(String s)
        {
            for(int l=0, r=s.length()-1; l<=r; l++, r--)
                if(s.charAt(l)!=s.charAt(r))
                    return false;
            return true;
        }

    }
}
