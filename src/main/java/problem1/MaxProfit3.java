package problem1;

/**
 * dp[i][j] 表示 [0, i] 区间内，到第 i 天（从 0 开始）状态为 j 时的最大收益。
 * j一共有三种状态：0 表示不持股；1 表示持股；2 表示处在冷冻期。
 * 状态转移方程：
 * 1、不持股可以由这两个状态转换而来：（1）昨天不持股，今天什么都不操作，仍然不持股。（2）昨天持股，今天卖了一股。
 2、持股可以由这两个状态转换而来：（1）昨天持股，今天什么都不操作，仍然持股；（2）昨天处在冷冻期，今天买了一股；
 3、处在冷冻期只可以由不持股转换而来，因为题目中说，刚刚把股票卖了，需要冷冻 1 天。

 */
public class MaxProfit3 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int[][] dp = new int[prices.length][3];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;

        for (int i = 1; i < prices.length; ++i) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][2] - prices[i]);
            dp[i][2] = dp[i-1][0];
        }
        return Math.max(dp[prices.length-1][0],dp[prices.length-1][2]);
    }
}
