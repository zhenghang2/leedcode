package problem1;

import java.util.*;

public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = {1,2,1,3,2,5};
        SingleNumber sn = new SingleNumber();
        int[] res = sn.singleNumber(nums);
        for (int i : res) {
            System.out.println(i);
        }
    }

    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        Set<Integer> container = new HashSet<Integer>();

        for (int i = 0; i < nums.length; ++i) {
            if (!container.contains(nums[i])) {
                container.add(nums[i]);
            } else {
                container.remove(nums[i]);
            }
        }
        int i=0;
        for (int num : container) {
            res[i] = num;
            i++;
        }
        return res;
    }
}
