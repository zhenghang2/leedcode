package problem1;

import java.util.Arrays;

/**
 * 动态规划，其中dp[]表示在nums[]中，以i为结尾最长子序列长度
 */
public class LengthOfLIS {

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        LengthOfLIS ls = new LengthOfLIS();
        int res = ls.lengthOfLIS(nums);
        System.out.println(res);
    }
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1){
            return 1;
        }
        int[] dp = new int[nums.length];
        int maxLength = 0;
        Arrays.fill(dp,1);
        for (int i = 1; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            maxLength = Math.max(maxLength,dp[i]);
        }
        return maxLength;
    }
}
