package problem1;

import java.util.Arrays;

/**
 * 动态规划
 * 转移方程为dp[i] = MIN(dp[i], dp[i - j * j] + 1)
 */
public class NumSquares {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,0);
        for (int i = 1; i <= n; ++i) {
            dp[i] = i;
            for (int j = 1; i-j*j >=0; ++j) {
                dp[i] = Math.min(dp[i],dp[i-j*j] + 1);
            }
        }
        return dp[n];
    }
}
