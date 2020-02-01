package problem1;

import java.util.ArrayList;
import java.util.List;

/**
 * 采用分治方法，对每个符号，进行左右两边计算，最后汇总结果
 */
public class DiffWaysToCompute {

    public List<Integer> diffWaysToCompute(String input) {
        return partition(input);
    }

    private List<Integer> partition(String input) {
        List<Integer> res = new ArrayList<Integer>();
        if (!input.contains("+") && !input.contains("-") && !input.contains("*")) {
            res.add(Integer.valueOf(input));
            return res;
        }

        for (int i = 0; i < input.length(); ++i) {
            if (!input.contains("+") || !input.contains("-") || !input.contains("*")) {
                for (int left : partition(input.substring(0,i))) {
                    for (int right : partition(input.substring(i+1))) {
                        if (input.charAt(i) == '+') {
                            res.add(left + right);
                        }
                        if (input.charAt(i) == '-') {
                            res.add(left - right);
                        }
                        if (input.charAt(i) == '*') {
                            res.add(left * right);
                        }
                    }
                }
            }
        }
        return res;
    }

}
