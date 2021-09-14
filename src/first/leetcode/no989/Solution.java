package first.leetcode.no989;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 989. 数组形式的整数加法
 * link: https://leetcode-cn.com/problems/add-to-array-form-of-integer/
 * 题解：https://leetcode-cn.com/problems/add-to-array-form-of-integer/solution/jian-dan-yi-dong-javacpythonjs-pei-yang-a8ofe/
 *
 * @author JellyfishMIX
 * @date 2021/9/14 21:58
 */
public class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        // 位标记，初始是个位
        int b1 = num.length - 1;
        // 进位
        int carry = 0;
        // 倒序结果
        List<Integer> result = new ArrayList<>();
        while (b1 >= 0 || k != 0) {
            // result[index] = x + y + carry
            int x = b1 >= 0 ? num[b1] : 0;
            int y = k != 0 ? k % 10 : 0;

            int sum = x + y + carry;
            carry = sum / 10;
            sum %= 10;
            result.add(sum);

            b1--;
            k /= 10;
        }
        // 如果 carry 有剩余
        if (carry > 0) {
            result.add(carry);
        }

        // 倒序返回
        Collections.reverse(result);
        return result;
    }
}
