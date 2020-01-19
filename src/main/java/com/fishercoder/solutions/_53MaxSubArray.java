package com.fishercoder.solutions;

public class _53MaxSubArray
{
    static public Integer maxSubArray(int[] arr)
    {

        if(arr == null || arr.length==0)
            return null;

        int re = arr[0];
        int curSum = arr[0];
        int r = 1, l = 0;
        while(l<arr.length-1)
        {
            while(r<arr.length && arr[r]<0)
                curSum += arr[r++];

            while( r<arr.length && arr[r]>=0)
                curSum += arr[r++];

            re = Math.max(re, curSum);

            while(arr[l]>0 && l<r-1)
                curSum -= arr[l++];

            while(arr[l]<=0 && l<r-1)
                curSum -= arr[l++];

            re = Math.max(re, curSum);
        }
        return re;

    }

    static public void main(String[] arr)
    {
        //System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        //System.out.println(maxSubArray(new int[]{-1, 0, -2}));
        System.out.println(maxSubArray(new int[]{-2, -1, -2}));

    }
}
