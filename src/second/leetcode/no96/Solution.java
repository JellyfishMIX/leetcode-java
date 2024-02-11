package second.leetcode.no96;

/**
 * @author shijie.qian
 * @date 2024/2/12 01:39
 */
public class Solution {
    private int[][] cache;

    public int numTrees(int n) {
        cache = new int[n + 1][n + 1];
        return backtrack(1, n);
    }

    /**
     * 计算 [low, high] 的 bst 个数
     * @param low
     * @param high
     * @return
     */
    private int backtrack(int low, int high) {
        // base case
        if (low > high) {
            return 1;
        }
        int cacheValue = cache[low][high];
        if (cacheValue != 0) {
            return cacheValue;
        }
        int count = 0;
        for (int index = low; index <= high; index++) {
            int leftCount = backtrack(low, index - 1);
            int rightCount = backtrack(index + 1, high);
            // postOrder
            count += leftCount * rightCount;
        }
        cache[low][high] = count;
        return count;
    }
}
