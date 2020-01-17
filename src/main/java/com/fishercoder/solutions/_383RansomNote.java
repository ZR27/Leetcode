package com.fishercoder.solutions;

import java.util.HashMap;

/**
 * 383 Ransom Note
 *
 * Given an arbitrary ransom note string and another string containing letters
 * from all the magazines, write a function that will return true if
 * the ransom note can be constructed from the magazines ; otherwise, it will return false.
 * Each letter in the magazine string can only be used once in your ransom note.

 Note:

 You may assume that both strings contain only lowercase letters.
 canConstruct("a", "b") -> false
 canConstruct("aa", "ab") -> false
 canConstruct("aa", "aab") -> true
*/
public class _383RansomNote
{

    public static class Solution1 {
        public boolean canConstruct(String ransomNote, String magazine)
        {
            int[] ran = new int[26];
            int[] mag = new int[26];
            for(char c : ransomNote.toCharArray())
                ran[c - 'a']++;
            for(char c : magazine.toCharArray())
                mag[c - 'a']++;
            for(int i=0; i<26; i++)
                if(mag[i]<ran[i])
                    return false;

            return true;
        }
    }

}