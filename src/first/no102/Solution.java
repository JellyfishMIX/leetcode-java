package first.no102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author JellyfishMIX
 * @date 2021/8/9 13:45
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 最后需要返回的结果
        List<List<Integer>> result = new ArrayList<>();
        // 判空处理
        if (root == null) {
            return result;
        }
        // 使用队列进行存储遍历到的节点
        Queue<TreeNode> linkedQueue = new LinkedList<>();
        // 先把根节点加入队列
        linkedQueue.add(root);
        // 开始遍历
        while (!linkedQueue.isEmpty()) {
            // 记录当前 level 的节点的值
            List<Integer> currentLevelList = new ArrayList<>();
            int currentSize = linkedQueue.size();
            for (int i = 1; i <= currentSize; i++) {
                TreeNode current = linkedQueue.poll();
                currentLevelList.add(current.val);
                if (current.left != null) {
                    linkedQueue.add(current.left);
                }
                if (current.right != null) {
                    linkedQueue.add(current.right);
                }
            }
            // 添加进结果
            result.add(currentLevelList);
        }
        return result;
    }
}
