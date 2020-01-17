package problem1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SummaryRanges {
  public List<String> summaryRanges(int[] nums) {
    List<String> res = new ArrayList<String>();
    if (nums.length == 0) {
      return res;
    }
    for (int i = 0, j = 0; j < nums.length; ++j) {
      if (j + 1 < nums.length && nums[j+1] == nums[j] + 1) {
        continue;
      }
      if (i == j) {
        res.add(nums[i] + "");
      } else {
        res.add(nums[i] + "->" + nums[j]);
      }
      i = j + 1;
    }
    return res;
  }
}
