package problem1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MajorityElement {

  public static void main(String[] args) {
    MajorityElement me = new MajorityElement();
    int[] nums = {1,1,1,3,3,2,2,2};
    List<Integer> res = me.majorityElement(nums);
    for (int i : res) {
      System.out.println(i);
    }
  }

  public List<Integer> majorityElement(int[] nums) {
    int modeNum = nums.length/3;
    List<Integer> res = new ArrayList<Integer>();
    if (nums.length < 1) {
      return res;
    }

    Arrays.sort(nums);
    int curNum = nums[0];
    int curCount = 1;

    for (int i = 1; i < nums.length; ++i) {
      if (curNum != nums[i]) {
        if (curCount > modeNum) {
          res.add(curNum);
        }
        curNum = nums[i];
        curCount = 1;
      } else {
        curCount++;
      }
    }
    if (curCount > modeNum) {
      res.add(curNum);
    }
    return res;
  }
}
