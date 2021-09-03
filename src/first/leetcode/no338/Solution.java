package first.leetcode.no338;

/**
 * 338. 比特位计数
 * link: https://leetcode-cn.com/problems/counting-bits/
 * 题解：https://leetcode-cn.com/problems/counting-bits/solution/hen-qing-xi-de-si-lu-by-duadua/
 *
 * @author JellyfishMIX
 * @date 2021/9/3 14:00
 */
public class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        // base case
        result[0] = 0;
        for (int i = 1; i <= n; i++) {
            // 比特位 1 的数量，奇数 = 上一个偶数 + 1
            if (i % 2 == 1) {
                result[i] = result[i - 1] + 1;
                // 比特位 1 的数量，偶数 = 上一个偶数
            } else {
                result[i] = result[i / 2];
            }
        }
        return result;
    }
}
