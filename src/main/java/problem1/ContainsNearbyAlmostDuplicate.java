package problem1;

public class ContainsNearbyAlmostDuplicate {
  public static void main(String[] args) {
    int[] nums = {2147483647,-2147483647};
    int k = 1;
    int t = 2147483647;
    ContainsNearbyAlmostDuplicate cnad = new ContainsNearbyAlmostDuplicate();
    System.out.println(cnad.containsNearbyAlmostDuplicate(nums,k,t));
  }

  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    if (nums.length < 2) {
      return false;
    }
    if (k == 0) {
      return false;
    }
    int pre = 0;
    int post = pre+1;
    while (pre < nums.length-1) {
      if ((post - pre)>k || post > nums.length-1) {
        pre++;
        post = pre+1;
        continue;
      }
      long var1 = nums[post];
      long var2 = nums[pre];
      long curSum = var1 - var2;
      if (Math.abs(curSum)<=t && (post - pre)<=k) {
        return true;
      }
      post++;
    }
    return false;
  }
}
