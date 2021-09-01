package first.leetcode.no70;

/**
 * 70. 爬楼梯
 * link: https://leetcode-cn.com/problems/climbing-stairs/
 *
 * @author JellyfishMIX
 * @date 2021/8/27 11:36
 */
public class Solution {
    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 0; i < n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
