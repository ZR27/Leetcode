package com.fishercoder.solutions;

import java.util.*;
import java.util.Map.Entry;

/**
 * 347. Top K Frequent Elements
 *
 * Given a non-empty array of integers, return the k most frequent elements.

 For example,
 Given [1,1,1,2,2,3] and k = 2, return [1,2].

 Note:
 You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 Your algorithm's time complexity must be better than O(n log n), where n is the array's size.*/

public class _347TopKFrequentElements
{

	public static class Solution1 {
		/**
		 * Use buckets to hold numbers of the same frequency
     * It's averaged at 30 ms on Leetcode.
		 */
		public List<Integer> topKFrequent(int[] nums, int k)
		{
			List<Integer> re = new ArrayList<>();


			Map<Integer, Integer> count = new HashMap<>();
			int maxFreq = 0;
			for(int i : nums)
			{
				count.put(i, count.getOrDefault(i, 0) + 1);
				maxFreq = Math.max(count.get(i), maxFreq);
			}

			List<Integer>[] bucket = new List[maxFreq + 1];
			for(Entry<Integer, Integer> en : count.entrySet())
			{
				int freq = en.getValue();
				if(bucket[freq] == null)
					bucket[freq] = new ArrayList<>();
				bucket[freq].add(en.getKey());
			}

			for(int i=maxFreq; i>0 && k>0; i--)
			{
				List<Integer> list = bucket[i];
				if(list == null)
					continue;
				if(list.size()<=k)
				{
					re.addAll(list);
					k-=list.size();
				}
				else
				{
					for(int j=0; j<k; j++)
						re.add(list.get(j));
					k=0;
				}
			}
			return re;
		}
	}

}
