package first.codinginterviews2.no3;

/**
 * 剑指 Offer II 003. 前 n 个数字二进制中 1 的个数
 * link: https://leetcode-cn.com/problems/w3tCBm/
 *
 * @author JellyfishMIX
 * @date 2021/9/14 21:31
 */
public class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        result[0] = 0;
        for (int i = 1; i <= n; i++) {
            // 奇数 比特位中 1 的个数为上一个偶数 + 1
            if (i % 2 == 1) {
                result[i] = result[i - 1] + 1;
                // 偶数 比特位中 1 的个数与 /2 的数字相同
            } else {
                result[i] = result[i / 2];
            }
        }
        return result;
    }
}
