package com.fishercoder.solutions;

import com.fishercoder.common.classes.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**337. House Robber III

 The thief has found himself a new place for his thievery again.
 There is only one entrance to this area, called the "root."
 Besides the root, each house has one and only one parent house.
 After a tour, the smart thief realized that "all houses in this place forms a binary tree".
 It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:
     3
    / \
   2   3
    \   \
     3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

Example 2:
     3
    / \
   4   5
  / \   \
 1   3   1
Maximum amount of money the thief can rob = 4 + 5 = 9.
*/

public class _337HouseRobber3
{

    public static class Solution1
    {
        public int rob(TreeNode root)
        {
            /*
            total = max(rob, noRob)
            rob = left.noRob + right.noRob + val
            norub = max(left.rob, left.noRob) + max(right.rob, right.noRob)
             */

            return Math.max(robbed(root), noRob(root));
        }

        private int robbed(TreeNode node)
        {
            if(node == null)
                return 0;

            return noRob(node.left) + noRob(node.right) + node.val;
        }

        private int noRob(TreeNode node)
        {
            if(node == null)
                return 0;

            return Math.max(robbed(node.left), noRob(node.left)) + Math.max(robbed(node.right), noRob(node.right));
        }
    }


}
