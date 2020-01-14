package problem1;

import java.util.Arrays;

public class Rob {
  public static void main(String[] args) {
    Rob rob = new Rob();
    int[] nums = {1,3,1,3,100};
    int res = rob.robMoney(nums);
    System.out.println(res);
  }

  public int robMoney(int[] nums) {
    if (nums.length <0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }
    if (nums.length == 2) {
      return Math.max(nums[0],nums[1]);
    }
    return Math.max(myRob(Arrays.copyOfRange(nums,0,nums.length-1)),
      myRob(Arrays.copyOfRange(nums,1,nums.length)));
  }

  public int myRob(int[] nums) {
    int[] map = new int[nums.length];
    if (nums.length <0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }
    if (nums.length == 2) {
      return Math.max(nums[0],nums[1]);
    }
    map[0] = nums[0];
    map[1] = Math.max(nums[0],nums[1]);
    for (int i=2; i<nums.length; i++) {
      map[i] = Math.max((map[i-2]+nums[i]),map[i-1]);
    }
    return map[nums.length-1];
  }
}
