package problem1;

public class MinimumSizeSubarraySum {

  public int minSubArrayLen(int s, int[] nums) {
    int sum = 0;
    int pre = 0;
    int point = 0;
    int minLen = Integer.MAX_VALUE;
    int len = 0;
    while (point<nums.length) {
      if (sum<s) {
        sum += nums[point];
        point++;
        len++;
      } else {
        minLen = Math.min(minLen,len);
        sum-=nums[pre];
        pre++;
        len--;
      }
    }
    if(sum<s && len==nums.length){
      return 0;
    }

    while (sum>=s) {
      sum -=nums[pre];
      if (sum <s) {
        break;
      }
      pre++;
      len--;
    }
    minLen = Math.min(minLen,len);
    return minLen;
  }
}
