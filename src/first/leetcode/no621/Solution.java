package first.leetcode.no621;

/**
 * 621. 任务调度器
 * link: https://leetcode-cn.com/problems/task-scheduler/
 * 题解：https://leetcode-cn.com/problems/task-scheduler/solution/tong-zi-by-popopop/
 *
 * @author JellyfishMIX
 * @date 2021/10/2 10:56
 */
public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] taskCounts = new int[26];
        int maxTaskCount = 0;
        for (char task : tasks) {
            taskCounts[task - 'A']++;
            maxTaskCount = Math.max(maxTaskCount, taskCounts[task - 'A']);
        }
        int maxTaskCountNum = 0;
        for (int taskCount : taskCounts) {
            if (taskCount == maxTaskCount) {
                maxTaskCountNum++;
            }
        }

        return Math.max(tasks.length, (maxTaskCount - 1) * (n + 1) + maxTaskCountNum);
    }
}
