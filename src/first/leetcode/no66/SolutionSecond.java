package first.leetcode.no66;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 66. 加一
 * link: https://leetcode-cn.com/problems/plus-one/submissions/
 *
 * @author JellyfishMIX
 * @date 2021/10/21 18:02
 */
public class SolutionSecond {
    public int[] plusOne(int[] digits) {
        List<Integer> result = new ArrayList<>();
        int carry = 0;
        int sum = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            sum = digits[i] + carry;
            if (i == digits.length - 1) {
                sum += 1;
            }
            result.add(sum % 10);
            carry = sum / 10;
        }
        // 如果 carry 位溢出，则追加一个最高位
        if (carry > 0) {
            result.add(carry);
        }
        Collections.reverse(result);
        int[] resultArr = result.stream().mapToInt(Integer::intValue).toArray();
        return resultArr;
    }
}
