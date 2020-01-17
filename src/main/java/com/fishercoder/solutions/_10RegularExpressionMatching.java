package com.fishercoder.solutions;
import static com.fishercoder.common.utils.CommonUtils.println;



/**
 * 10. Regular Expression Matching
 *
 * Implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 *
 * The matching should cover the entire input string (not partial).
 *
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 *
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 */

public class _10RegularExpressionMatching
{

    public static class Solution1
    {

        static public boolean isMatch(String s, String p)
        {
            /*
            abcda: a*a, a.cda, a*, *, | ab*d, a.b*, .,
            if p[0-i] matches to s[0-j] then isMatch[i][j] = true;

            !! wrong solution
            isMatch[i][j] = p[i] matches s[j] && (i<1 || j<1 ||isMatch[i-1][j-1])
             */

            boolean[][] isMatch = new boolean[p.length()][s.length()];
            /*
            for(int i =0; i<p.length(); i++)
            {
                char cp = p.charAt(i);
                for(int j=0; j<s.length(); j++)
                {
                    isMatch[i][j] = matchChar(s.charAt(j), cp) && (i<1 || j<1 || isMatch[i-1][j-1]);
                }
            }*/

            for(int i=0, j=0; i<p.length() && j<s.length();)
            {
                char cp = p.charAt(i);
                char cs = s.charAt(j);
                if(cp=='*')
                {
                    for(int n=j; n<s.length(); n++)
                        isMatch[i][n] = true;
                    i++;
                }
                else if(cp=='.' || cp==cs)
                {
                    isMatch[i][j] = (i<1 || j<1 || isMatch[i-1][j-1]);
                    i++; j++;
                }
                else
                {
                    isMatch[i][j] = false;
                    //i++;
                    j++;
                }

            }

            return isMatch[p.length() - 1][s.length() - 1];
        }

        static public boolean matchChar(char s, char p)
        {
            if(p=='*' || p=='.')
                return true;
            return s==p;
        }
    }
    public static class Solution2
    {

        static public boolean isMatch(String s, String p)
        {
            System.out.println(s + " : " + p);
            if(s.equals(p))
                return true;

            if(p.isEmpty())
                return false;

            char pp = p.charAt(0);
            if(s.isEmpty() && pp != '*')
                return  false;

            String subS = s.length() > 1 ? s.substring(1) : "";
            String subP = p.length() > 1 ? p.substring(1) : "";
            // * can be
            //  1, ignored, isMatch(s, p.substring(1))
            //  2, matched and continue matching, isMatch(s.substring(1), p)
            //  3, matched and stop matching, isMatch(s.substring(1), p.substring(1))
            if(pp=='*')
                return p.length()==1 || isMatch(subS, subP) ||(!s.isEmpty() && isMatch(subS, p) )||(!p.isEmpty() &&isMatch(s, subP));


            char ss = s.charAt(0);
            if(pp=='.' || pp==ss)
                return isMatch(subS, subP);
            else
                return false;
        }

    }

    public static void main(String[]st)
    {
        //Solution1.isMatch("a", "*");
        //System.out.println(Solution1.isMatch("abcs", "*"));
        //System.out.println(Solution1.isMatch("abcs", "a*"));
        //System.out.println(Solution1.isMatch("abfdljaslfdlj", "a*lj"));
        //System.out.println(Solution2.isMatch("abfdljaslfdlj", "a*l.as..**rrlj"));
        System.out.println(Solution2.isMatch("fsfdsflj", "*lj*"));
        //System.out.println(Solution1.isMatch("as", "*s"));
    }


}
