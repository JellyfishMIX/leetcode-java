package second.leetcode.no70;

/**
 * @author shijie.qian
 * @date 2024/4/6 02:52
 */
public class Solution {
    public int climbStairs(int n) {
        // 状态转移方程 f(n) = f(n - 1) + f(n - 2)
        // f(0) = 0, f(1) = 1
        int x = 0;
        int y = 1;
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result = x + y;
            int temp = x;
            x = y;
            y = result;
        }
        return result;
    }
}
