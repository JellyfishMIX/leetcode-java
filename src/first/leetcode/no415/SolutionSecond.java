package first.leetcode.no415;

import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 415. 字符串相加
 * link: https://leetcode-cn.com/problems/add-strings/
 *
 * @author JellyfishMIX
 * @date 2021/9/15 20:41
 */
public class SolutionSecond {
    public String addStrings(String num1, String num2) {
        int s1Index = num1.length() - 1;
        int s2Index = num2.length() - 1;
        // 进位
        int carry = 0;
        // 运算结果，逆序
        List<Integer> result = new LinkedList<>();
        while (s1Index >= 0 || s2Index >= 0) {
            int x = s1Index >= 0 ? num1.charAt(s1Index) - '0' : 0;
            int y = s2Index >= 0 ? num2.charAt(s2Index) - '0' : 0;
            // sum = x + y + carry
            int sum = x + y + carry;
            carry = sum / 10;
            sum %= 10;

            result.add(sum);
            // 下一次迭代
            s1Index--;
            s2Index--;
        }
        // 如果 carry 进位有剩余，最高位追加一位
        if (carry > 0) {
            result.add(carry);
        }
        // 逆转回正序
        Collections.reverse(result);
        // 拼接结果字符串
        StringBuilder builder = new StringBuilder();
        for (Integer integer : result) {
            builder.append(integer);
        }
        return builder.toString();
    }

    @Test
    public void test() {
        String result = addStrings("11", "123");
        System.out.println(result);
    }
}
