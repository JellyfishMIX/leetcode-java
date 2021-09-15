package first.leetcode.no66;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 66. 加一
 * link: https://leetcode-cn.com/problems/plus-one/
 *
 * @author JellyfishMIX
 * @date 2021/9/15 20:02
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        // 倒叙
        List<Integer> resultList = new ArrayList<>();
        int index;
        // 进位
        int carry = 0;
        int sum = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            // sum = digits[i] + carry
            sum = digits[i] + carry;
            // 当 i == digits.length - 1 时，sum = digits[i] + 1 + carry;
            if (i == digits.length - 1) {
                sum += 1;
            }
            carry = sum / 10;
            sum %= 10;
            resultList.add(sum);
        }
        // 防止 carry 溢出
        if (carry > 0) {
            resultList.add(carry);
        }

        Collections.reverse(resultList);
        int[] resultArray = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArray[i] = resultList.get(i);
        }
        return resultArray;
    }
}
