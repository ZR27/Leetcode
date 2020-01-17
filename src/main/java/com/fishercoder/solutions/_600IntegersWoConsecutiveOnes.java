package com.fishercoder.solutions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static com.fishercoder.common.utils.CommonUtils.println;

/**
 * 600. Non-negative Integers without Consecutive Ones
 *
 * Given a positive integer n, find the number of non-negative integers less than or equal to n, whose binary representations do NOT contain consecutive ones.

 Example 1:
 Input: 5
 Output: 5
 Explanation:
 Here are the non-negative integers <= 5 with their corresponding binary representations:
 0 : 0
 1 : 1
 2 : 10
 3 : 11
 4 : 100
 5 : 101
 Among them, only integer 3 disobeys the rule (two consecutive ones) and the other 5 satisfy the rule.

 Note: 1 <= n <= 109
 */
public class _600IntegersWoConsecutiveOnes
{
    /*
    0:  0
    1:  1
    2:  10
    3:  11
    4:  100
    5:  101
    6:  110
    7:  111
    8:  1000
    16: 10000

    oneMore[i] = zeroLess[i-1]
    oneEqual[i] = zeroLess[i-1] + zeroEqal[i-1]
    zeroLess[i] = zeroLess[i-1] + zeroEqal[i-1] + oneEqual[i-1]
    zeroEqual[i] = zeroLess[i-1] + zeroEqal[i-1] + oneEqual[i-1]

     */

    public static class Solution1
    {
        static public int findIntegers(int num)
        {
            List<Integer> list = new ArrayList<>();
            do{
                list.add(num&1);
                num >>= 1;
            } while(num > 0);
            int[] one = new int[list.size()];
            int[] zero = new int[list.size()];
            one[0] = 1;
            zero[0] = 1;
            for(int i=1; i<one.length; i++)
            {
                one[i] = zero[i-1];
                zero[i] = one[i - 1] + zero[i - 1];
            }
            int all = one[one.length-1] + zero[zero.length-1];

            for(int i = list.size()-2; i>=0; i--)
            {
                if(list.get(i) == 1 && list.get(i+1) == 1)
                    break;
                if(list.get(i) == 0 && list.get(i+1) == 0)
                    all -= one[i];
            }

            return all;
        }

        static public void findIntegers2(int num)
        {
            println(Integer.toBinaryString(num));
            List<Integer> list = new ArrayList<>();
            while(num>0)
            {
                list.add(num&1);
                num>>=1;
            }
            Collections.reverse(list);
            //println(list.toString());

            int[] one = new int[list.size()];
            int[] zero = new int[list.size()];
            one[0] = 1;
            zero[0] = 1;
            for(int i=1; i<one.length; i++)
            {
                one[i] = zero[i-1];
                zero[i] = one[i - 1] + zero[i - 1];
            }
            println(one[one.length-1] + zero[zero.length-1]);
            //println(zero[zero.length-1]);
        }

        static public void findIntegers3(int num)
        {
            int re = 0;
            for(int i=0; i<=num; i++)
                if(!Integer.toBinaryString(i).contains("11"))
                    re++;
            println(re);
        }

    }

    static public void main(String[] m)
    {
        //Solution1.findIntegers2(1);
        //Solution1.findIntegers2(8);
        //Solution1.findIntegers2(5);
        int a = 8994199;
        //println(Integer.toBinaryString(a));
        Solution1.findIntegers3(a);
        Solution1.findIntegers2(a);
        println(Solution1.findIntegers(a));
    }


}
