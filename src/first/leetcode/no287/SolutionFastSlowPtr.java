package first.leetcode.no287;

/**
 * 287. 寻找重复数
 * link: https://leetcode-cn.com/problems/find-the-duplicate-number/
 * 快慢指针
 * 题解：https://leetcode-cn.com/problems/find-the-duplicate-number/solution/kuai-man-zhi-zhen-de-jie-shi-cong-damien_undoxie-d/
 *
 * @author JellyfishMIX
 * @date 2021/10/2 17:54
 */
class SolutionFastSlowPtr {
    public int findDuplicate(int[] nums) {
        // slow 1步/次
        // fast 2步/次
        int slow = 0;
        int fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }
        // fast 回到起点，和 slow 一起以 1步/次 的速率走
        fast = 0;
        while (true) {
            fast = nums[fast];
            slow = nums[slow];
            if (slow == fast) {
                break;
            }
        }
        return fast;
    }
}
