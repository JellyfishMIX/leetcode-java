package second.leetcode.no912.merge;

/**
 * @author shijie.qian
 * @date 2024/2/7 16:44
 */
public class Solution {
    public int[] sortArray(int[] nums) {
        // 不考虑空
        traverse(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * 升序, 归并排序 -- dfs 后序
     */
    private void traverse(int[] nums, int start, int end) {
        // base case
        if (start >= end) {
            return;
        }
        int middle = start + (end - start) / 2;
        traverse(nums, start, middle);
        traverse(nums, middle + 1, end);
        // 后序位置，两个升序数组 merge
        merge(nums, start, middle, middle + 1, end);
    }

    /**
     * 不建议多次 merge 使用共享的 result 数组，实测和每次 merge 重新 new 一个数组耗时差距不大
     * 还是遵循迪米特法则低耦合高内聚比较好
     */
    private void merge(int[] nums, int firstStart, int firstEnd, int secondStart, int secondEnd) {
        int[] result = new int[secondEnd - firstStart + 1];
        int firstPoint = firstStart;
        int secondPoint = secondStart;
        for (int resultPoint = 0; resultPoint < result.length; resultPoint++) {
            // first 数组没有了，直接用 second 数组
            if (firstPoint > firstEnd) {
                result[resultPoint] = nums[secondPoint];
                secondPoint++;
                continue;
            }
            // second 数组没有了，直接用 first 数组
            if (secondPoint > secondEnd) {
                result[resultPoint] = nums[firstPoint];
                firstPoint++;
                continue;
            }
            int firstValue = nums[firstPoint];
            int secondValue = nums[secondPoint];
            if (firstValue == secondValue) {
                result[resultPoint] = firstValue;
                firstPoint++;
            } else if (firstValue < secondValue) {
                result[resultPoint] = firstValue;
                firstPoint++;
            } else if (firstValue > secondValue) {
                result[resultPoint] = secondValue;
                secondPoint++;
            }
        }

        int resultIndex = 0;
        // 使用 result 覆盖 nums[firstStart, secondEnd]
        for (int i = firstStart; i <= secondEnd; i++) {
            nums[i] = result[resultIndex++];
        }
    }
}
