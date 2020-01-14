package problem1;

import java.util.Arrays;

public class FindKthLargest {
  public static void main(String[] args) {
    int[] nums = {3,2,3,1,2,4,5,5,6};
    int k = 4;
    FindKthLargest fkl = new FindKthLargest();
    System.out.println(fkl.findKthLargest(nums,k));
  }

  public int findKthLargest(int[] nums, int k) {
    Arrays.sort(nums);
    return nums[nums.length-k];
  }
}
