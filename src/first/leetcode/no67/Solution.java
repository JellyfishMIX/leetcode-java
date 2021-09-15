package first.leetcode.no67;

/**
 * 67. 二进制求和
 * link: https://leetcode-cn.com/problems/add-binary/
 *
 * @author JellyfishMIX
 * @date 2021/9/15 21:42
 */
public class Solution {
    public String addBinary(String a, String b) {
        int s1Index = a.length() - 1;
        int s2Index = b.length() - 1;
        // 结果，逆序
        StringBuilder result = new StringBuilder();
        int carry = 0;
        while (s1Index >= 0 || s2Index >= 0) {
            int x = s1Index >= 0 ? a.charAt(s1Index) - '0' : 0;
            int y = s2Index >= 0 ? b.charAt(s2Index) - '0' : 0;
            // sum = x + y + carry
            int sum = x + y + carry;
            // 二进制
            carry = sum / 2;
            sum %= 2;
            result.append(sum);
            // 下一次迭代
            s1Index--;
            s2Index--;
        }
        // carry 有剩余进位，result 最高位追加一位
        if (carry > 0) {
            result.append(carry);
        }
        // 逆转为正序
        return result.reverse().toString();
    }
}
