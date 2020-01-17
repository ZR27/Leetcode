package com.fishercoder.solutions;

import static com.fishercoder.common.utils.CommonUtils.println;

/**198. House Robber

 You are a professional robber planning to rob houses along a street.
 Each house has a certain amount of money stashed,
 the only constraint stopping you from robbing each of them is that adjacent houses have security
 system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 Given a list of non-negative integers representing the amount of money of each house,
 determine the maximum amount of money you can rob tonight without alerting the police.

 Example 1:
 Input: [1,2,3,1]
 Output: 4
 Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 Total amount you can rob = 1 + 3 = 4.

 Example 2:
 Input: [2,7,9,3,1]
 Output: 12
 Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 Total amount you can rob = 2 + 9 + 1 = 12.
 */

public class _198HouseRobber
{
    public static class Solution1 {
        static public int rob(int[] nums)
        {
            /*
            robbed
            canRob
            cantRob

            robbed[i] = max(canRob[i-1], cantRob[i-1]) + nums[i]
            cantRob[i] = robbed[i-1]
            canRob[i] = max(canRob[i-1], cantRob[i-1]) = max(canRob[i-1], robbed[i-2])
            robbed[0] = nums[0];
            robbed[1] = nums[1];
            canRob[0] = 0;
             */

            if(nums == null || nums.length<1)
                return 0;

            if(nums.length==1)
                return nums[0];

            if(nums.length==2)
                return Math.max(nums[0], nums[1]);

            int[] robbed = new int[nums.length];
            int[] canRob = new int[nums.length];
            int[] cantRob = new int[nums.length];
            robbed[0] = nums[0];
            robbed[1] = nums[1];
            canRob[0] = 0;
            canRob[1] = 0;
            cantRob[0] = 0;
            cantRob[1] = robbed[0];

            for(int i=2; i<nums.length; i++)
            {
                canRob[i] = Math.max(canRob[i-1], robbed[i-2]);
                robbed[i] = Math.max(canRob[i - 1], robbed[i-2]) + nums[i];
                cantRob[i] = robbed[i - 1];
            }

            return Math.max(robbed[nums.length - 1], Math.max(cantRob[nums.length - 1], canRob[nums.length - 1]));

        }
    }

    static public void main(String[] a)
    {
        println(Solution1.rob(new int[] {2,7,9,3,1}));
    }

}
