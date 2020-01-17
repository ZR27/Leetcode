package com.fishercoder.solutions;

/**
 * 374. Guess Number Higher or Lower
 * We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

 -1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!
 Example:
 n = 10, I pick 6.
 Return 6.

 */
public class _374GuessNumberHigherLower
{
    public static class Solution1 {

        static  public int guessNumber(int n)
        {
            return guessNumber(1, n);
        }

        static public int guessNumber(int l, int r)
        {
            System.out.println(l + " to " + r);
            Long midl = (1L+l+r)/2;
            int mid = midl.intValue();
            int gr = guess(mid);
            if(gr < 0)
                return guessNumber(l, mid - 1);
            else if(gr>0)
                return guessNumber(mid+1, r);
            else
                return mid;
        }

        static private int guess(int num)
        {
            int expect =1702766719;

            if (num > expect) {
                return -1;
            } else if (num < expect) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[]a)
    {
        Solution1.guessNumber(2126753390);
    }
}
