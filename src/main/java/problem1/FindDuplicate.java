package problem1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindDuplicate {
    public static void main(String[] args) {
        FindDuplicate fd = new FindDuplicate();
        int[] nums = {3, 1, 3, 4, 2};
        int res = fd.findDuplicate(nums);
        System.out.println(res);
    }

    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return -1;
    }
}
