package com.fishercoder.solutions;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 4. Median of Two Sorted Arrays

 There are two sorted arrays nums1 and nums2 of size m and n respectively.

 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 Example 1:
 nums1 = [1, 3]
 nums2 = [2]
 The median is 2.0

 Example 2:
 nums1 = [1, 2]
 nums2 = [3, 4]
 The median is (2 + 3)/2 = 2.5
 */
public class _4MedianTwoSortedArrays
{

    class Solution1
    {
        /*
        [1, 3, 6, 10], [4, 5, 7]

        */
        public double findMedianSortedArrays(int[] nums1, int[] nums2)
        {
            int len = nums1.length + nums2.length;

            int v1 = nums1.length>0 ? nums1[0] : nums2[0];
            int v2 = v1;
            for(int i=0, j=0, x=0; x<len/2 + 1; x++)
            {
                v2 = v1;
                if(i >= nums1.length)
                {
                    v1 = nums2[j];
                    j++;
                }
                else if(j >= nums2.length)
                {
                    v1 = nums1[i];
                    i++;
                }
                else if(nums1[i] < nums2[j])
                {
                    v1 = nums1[i];
                    i++;
                }
                else
                {
                    v1 = nums2[j];
                    j++;
                }
            }
            return len%2 == 1 ? v1 : (v1 + v2)/2.0;
        }
    }

}
