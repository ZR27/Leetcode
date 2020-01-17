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

public class _213HouseRobber2
{



    public static class Solution1 {
        static public int rob(int[] nums)
        {
            /*
            Wrong solution, reduced array length reduced possible combination.

            robbed
            canRob
            cantRob

            robbed[i] = max(canRob[i-1], cantRob[i-1]) + nums[i]
            cantRob[i] = robbed[i-1]
            canRob[i] = max(canRob[i-1], cantRob[i-1]) = max(canRob[i-1], robbed[i-2])
            robbed[0] = nums[0];
            robbed[1] = nums[1];
            canRob[0] = 0;

            the last one and first one, only one of them can be robbed, so can consider them as one
            house with the higher money amount.
             */

            if(nums == null || nums.length<1)
                return 0;

            if(nums.length==1)
                return nums[0];

            nums[0] = Math.max(nums[0], nums[nums.length - 1]);

            if(nums.length <= 3)
                return Math.max(nums[0], nums[1]);


            int[] robbed = new int[nums.length - 1];
            int[] canRob = new int[nums.length - 1];
            int[] cantRob = new int[nums.length - 1];
            robbed[0] = nums[0];
            robbed[1] = nums[1];
            canRob[0] = 0;
            canRob[1] = 0;
            cantRob[0] = 0;
            cantRob[1] = robbed[0];

            for(int i=2; i<robbed.length; i++)
            {
                canRob[i] = Math.max(canRob[i-1], robbed[i-2]);
                robbed[i] = Math.max(canRob[i - 1], robbed[i-2]) + nums[i];
                cantRob[i] = robbed[i - 1];
            }

            return Math.max(robbed[robbed.length - 1], Math.max(cantRob[robbed.length - 1], canRob[robbed.length - 1]));

        }

    }
    public static class Solution2 {
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

            the last one and first one, only one of them can be robbed
            so try two arrays, one without last, one without first.
             */

            if(nums == null || nums.length<1)
                return 0;

            if(nums.length==1)
                return nums[0];

            if(nums.length == 2)
                return Math.max(nums[0], nums[1]);

            if(nums.length == 3)
                return Math.max(nums[0], Math.max(nums[2], nums[1]));

            return Math.max(robSub(nums, 0, nums.length-1), robSub(nums, 1, nums.length-1));

        }

        static private int robSub(int[] nums, int start, int len)
        {
            int[] robbed = new int[len];
            int[] canRob = new int[len];
            int[] cantRob = new int[len];

            robbed[0] = nums[start];
            robbed[1] = nums[start + 1];
            canRob[0] = 0;
            canRob[1] = 0;
            cantRob[0] = 0;
            cantRob[1] = robbed[0];

            for(int i=2; i<robbed.length; i++)
            {
                canRob[i] = Math.max(canRob[i-1], robbed[i-2]);
                robbed[i] = Math.max(canRob[i - 1], robbed[i-2]) + nums[start + i];
                cantRob[i] = robbed[i - 1];
            }

            return Math.max(robbed[robbed.length - 1], Math.max(cantRob[robbed.length - 1], canRob[robbed.length - 1]));
        }

    }

    static public void main(String[] a)
    {
        println(Solution1.rob(new int[] {1,2,3,1}));
        println(Solution1.rob(new int[] {1,2,1,1}));
        println(Solution2.rob(new int[] {1,2,1,1}));
    }

}
