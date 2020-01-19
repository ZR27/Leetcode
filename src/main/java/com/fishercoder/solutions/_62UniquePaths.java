package com.fishercoder.solutions;

/**
 * 62. Unique Paths

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach
the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
 */
public class _62UniquePaths
{

  public static class Solution1
  {
    /**
     * Another typical DP question, use a 2d array: the first row and the first column need to be
     * initialized to be 1 since there's only one way to reach every position in the first row and
     * the first column: either from left or top.
     */
    public int uniquePaths(int m, int n)
    {
      /*

       */
      if(m<1 || n<1)
        return 0;

      int [][] pathCount = new int[m][n];
      for(int i=0; i<n; i++)
        pathCount[0][i] = 1;
      for(int i=0; i<m; i++)
        pathCount[i][0] = 1;
      for(int i=1; i<m; i++)
        for(int j=1; j<n; j++)
          pathCount[i][j] = pathCount[i-1][j] + pathCount[i][j-1];

      return pathCount[m-1][n-1];


    }
  }
}
