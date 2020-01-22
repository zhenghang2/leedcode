package problem1;

import java.util.Arrays;

public class ProductExceptSelf {

  public int[] productExceptSelf(int[] nums) {
    int[] res = new int[nums.length];
    int sum = 1;
    int noZeroSum = 1;
    int zeroCount = 0;
    for (int i = 0; i < nums.length; ++i) {
      if (nums[i] != 0) {
        noZeroSum *= nums[i];
      } else {
        zeroCount++;
      }
      sum *= nums[i];
    }
    if (zeroCount >1) {
      Arrays.fill(res,0);
      return res;
    }
    for (int i = 0; i < nums.length; ++i) {
      if (nums[i] == 0) {
        res[i] = noZeroSum;
      } else {
        res[i] = sum / nums[i];
      }
    }
    return res;
  }
}
