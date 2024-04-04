package second.leetcode.no415;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author shijie.qian
 * @date 2024/4/4 17:40
 */
public class Solution {
    public String addStrings(String num1, String num2) {
        int num1Index = num1.length() - 1;
        int num2Index = num2.length() - 1;

        // 进位
        int carry = 0;
        // 求和结果，倒序存储
        List<Integer> reverseResult = new ArrayList<>();
        while (num1Index >= 0 || num2Index >= 0) {
            char num1Char = '0';
            char num2Char = '0';
            if (num1Index >= 0) {
                num1Char = num1.charAt(num1Index);
            }
            num1Index--;
            if (num2Index >= 0) {
                num2Char = num2.charAt(num2Index);
            }
            num2Index--;
            int currentBit1 = num1Char - '0';
            int currentBit2 = num2Char - '0';

            int currentResult = currentBit1 + currentBit2 + carry;
            int currentBit = currentResult % 10;
            carry = currentResult / 10;
            reverseResult.add(currentBit);

            num1Char = 0;
            num2Char = 0;
        }
        // 把最后剩余的进位补上
        if (carry > 0) {
            reverseResult.add(carry);
        }

        Collections.reverse(reverseResult);
        StringBuilder stringBulder = new StringBuilder();
        for (int i = 0; i < reverseResult.size(); i++) {
            stringBulder.append(reverseResult.get(i));
        }
        return stringBulder.toString();
    }
}
