package no415;

/**
 * @author JellyfishMIX
 * @date 2021/8/9 02:26
 */
public class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        // 进位位
        int add = 0;
        // 结果
        StringBuilder result = new StringBuilder();
        // 模拟竖式相加
        while (i >= 0 || j >= 0 || add > 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int current = x + y + add;
            add = current / 10;
            current = current % 10;
            result.append(current);
            i--;
            j--;
        }
        // 计算后得到的结果需要翻转
        result.reverse();
        return result.toString();
    }
}
