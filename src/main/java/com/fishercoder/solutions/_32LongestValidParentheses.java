package com.fishercoder.solutions;

import java.util.LinkedList;

/**
 * 32. Longest Valid Parentheses
 *
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
public class _32LongestValidParentheses
{
    /*
    (()
    (()()
    ((())()
    ))()((
    ()(())
    ()()
    ((())
    ()((()

    validLen[i] = match(s[i-1-validLen[i-1]], s[i]) ? validLen[i-1]+2 : 0

    */
    static public int longestValidParentheses(String s)
    {
        LinkedList<Character> chars = new LinkedList<>();
        LinkedList<Integer> idx = new LinkedList<>();
        int max = 0;
        for(int i =0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            if(c == '(')
            {
                chars.push(c);
                idx.push(i);
            }
            else if(c == ')')
            {
                if(!chars.isEmpty() && chars.peek()=='(')
                {
                    chars.pop();
                    int ip = idx.pop();
                }
                else
                {
                    chars.push(c);
                    idx.push(i);
                }
            }
        }

        System.out.println(chars);
        System.out.println(idx);
        if(idx.isEmpty())
            return s.length();

        idx.addLast(-1); //idx.push(s.length());

        int pre = s.length();
        for(int i : idx)
        {
            //System.out.println(i);
            max = Math.max(max, pre-i-1);
            pre = i;
        }

        return max;

    }

    static  public void main(String[] argu)
    {
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses("()())"));
        System.out.println(longestValidParentheses("(()())())()"));
    }
}
