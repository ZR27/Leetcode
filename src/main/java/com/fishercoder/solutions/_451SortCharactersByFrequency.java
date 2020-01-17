package com.fishercoder.solutions;

import java.util.*;

/**
 * 451. Sort Characters By Frequency
 *
 * Given a string, sort it in decreasing order based on the frequency of characters.

 Example 1:

 Input:
 "tree"

 Output:
 "eert"

 Explanation:
 'e' appears twice while 'r' and 't' both appear once.
 So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

 Example 2:

 Input:
 "cccaaa"

 Output:
 "cccaaa"

 Explanation:
 Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 Note that "cacaca" is incorrect, as the same characters must be together.

 Example 3:

 Input:
 "Aabb"

 Output:
 "bbAa"

 Explanation:
 "bbaA" is also a valid answer, but "Aabb" is incorrect.
 Note that 'A' and 'a' are treated as two different characters.

 */
public class _451SortCharactersByFrequency
{

    public static class Solution1 {
        public String frequencySort(String s)
        {
            Map<Character, Integer> map = new HashMap<>();
            int maxFreq = 0;
            for(char c : s.toCharArray())
            {
                int freq = map.getOrDefault(c, 0) + 1;
                map.put(c, freq);
                maxFreq = Math.max(maxFreq, freq);
            }

            String[] bucket = new String[maxFreq+1];
            for(Map.Entry<Character, Integer> en : map.entrySet())
            {
                int i = en.getValue();

                if(bucket[i]==null)
                    bucket[i] = "";

                bucket[i] = bucket[i] + en.getKey();
            }
            StringBuilder sb = new StringBuilder();

            for(int i = maxFreq; i>0; i--)
            {
                if(bucket[i] == null)
                    continue;
                for(char a : bucket[i].toCharArray())
                {
                    for(int j=0; j<i; j++)
                        sb.append(a);
                }

            }

            return sb.toString();
        }
    }
}
