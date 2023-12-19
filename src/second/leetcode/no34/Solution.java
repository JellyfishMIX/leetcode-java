package second.leetcode.no34;

/**
 * @author shijie.qian
 * @date 2023/12/20 00:42
 */
public class Solution {
    private int count = 0;

    public static void main(String[] args) {
        // int[] nums = new int[] {5,7,7,8,8,10};
        // int target = 8;
        int[] nums = new int[] {2,2};
        int target = 3;

        Solution solution = new Solution();
        int[] result = solution.searchRange(nums, target);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] searchRange(int[] nums, int target) {
        int targetLeftest = findTargetLeftest(nums, target);
        int targetRightest = findTargetRightest(nums, target);
        return new int[] {targetLeftest, targetRightest};
    }

    public int findTargetLeftest(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        // 不考虑空
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                // 缩小右侧搜索边界，最终目的是找到最左 target 边界
                right = middle;
            } else if (nums[middle] < target) {
                // 缩小左侧搜索边界
                left = middle + 1;
            } else if (nums[middle] > target) {
                // 缩小右侧搜索边界
                right = middle;
            }
        }
        if (left >= nums.length) {
            return -1;
        }
        return nums[left] == target ? (left) : -1;
    }

    public int findTargetRightest(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        // 不考虑空
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                // 缩小左侧搜索边界，最终目的是找到最右 target 边界
                left = middle + 1;
            } else if (nums[middle] < target) {
                // 缩小左侧搜索边界
                left = middle + 1;
            } else if (nums[middle] > target) {
                // 缩小右侧搜索边界
                right = middle;
            }
        }
        if (right - 1 < 0) {
            return -1;
        }
        return nums[right - 1] == target ? (right - 1) : -1;
    }
}
