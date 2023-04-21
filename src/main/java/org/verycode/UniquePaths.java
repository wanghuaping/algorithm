package org.verycode;

/**
 * @Author wanghuaping
 * @Date ${DATE} ${TIME}
 *
 * 问题：
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 *
 * 思路：
 * 这是一道经典的动态规划问题。可以使用一个二维数组 $dp$ 来记录到达每个位置的不同路径数，其中 $dp_{i,j}$ 表示从起点到 $(i,j)$ 位置的不同路径数。根据题目的要求，可以得到状态转移方程：
 * $$dp_{i,j} = dp_{i-1,j} + dp_{i,j-1}$$
 * 其中 $dp_{i-1,j}$ 表示从 $(i-1,j)$ 到 $(i,j)$ 的路径数，$dp_{i,j-1}$ 表示从 $(i,j-1)$ 到 $(i,j)$ 的路径数。边界条件为 $dp_{0,j}=1$ 和 $dp_{i,0}=1$，因为第一行和第一列的所有位置只有一条路径可以到达。
 *
 */
public class UniquePaths {
    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(2000000,200000));
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

}