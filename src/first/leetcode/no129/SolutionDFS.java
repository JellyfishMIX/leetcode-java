package first.leetcode.no129;

/**
 * 129. 求根节点到叶节点数字之和
 * link: https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 * DFS 解法
 *
 * @author JellyfishMIX
 * @date 2021/8/20 11:11
 */
public class SolutionDFS {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    /**
     * 深度优先搜索
     *
     * @param node 本地递归的节点
     * @param preSum 本次递归之前递归的 sum
     * @return
     */
    private int dfs(TreeNode node, int preSum) {
        if (node == null) {
            return 0;
        }
        int sum = preSum * 10 + node.val;
        if (node.left == null && node.right == null) {
            return sum;
        } else {
            return dfs(node.left, sum) + dfs(node.right, sum);
        }
    }
}
