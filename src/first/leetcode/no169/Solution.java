package first.leetcode.no169;

/**
 * 169. 多数元素
 * link: https://leetcode-cn.com/problems/majority-element/
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * link: https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 * 摩尔投票法
 *
 * @author JellyfishMIX
 * @date 2021/8/20 20:25
 */
public class Solution {
    public int majorityElement(int[] nums) {
        // 需要寻找的多数元素。初始值 0 不会被用到
        int specific = 0;
        // 投票计数
        int vote = 0;
        for (int num : nums) {
            if (vote == 0) {
                specific = num;
            }
            vote += specific == num ? +1 : -1;
        }
        return specific;
    }
}
