package first.leetcode.no337;

import java.util.HashMap;
import java.util.Map;

/**
 * 337. 打家劫舍 III
 * link: https://leetcode-cn.com/problems/house-robber-iii/
 * 题解：https://leetcode-cn.com/problems/house-robber-iii/solution/san-chong-fang-fa-jie-jue-shu-xing-dong-tai-gui-hu/
 *
 * @author JellyfishMIX
 * @date 2021/10/2 10:24
 */
public class Solution {
    /**
     * <root, calculated money of the root>
     */
    private Map<TreeNode, Integer> map = new HashMap<>();

    public int rob(TreeNode root) {
        // base case
        if (root == null) {
            return 0;
        }
        // 如果已经计算过 root 的 money，直接返回
        Integer calculatedMoney = map.get(root);
        if (calculatedMoney != null) {
            return calculatedMoney;
        }

        // 一个爷爷和四个孙子的钱
        int grandpaAndGrandsonMoney = root.val;
        if (root.left != null) {
            grandpaAndGrandsonMoney += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            grandpaAndGrandsonMoney += rob(root.right.left) + rob(root.right.right);
        }

        // 两个儿子的钱
        int sonMoney = 0;
        if (root.left != null) {
            sonMoney += rob(root.left);
        }
        if (root.right != null) {
            sonMoney += rob(root.right);
        }

        int result = Math.max(grandpaAndGrandsonMoney, sonMoney);
        map.put(root, result);
        return result;
    }
}
