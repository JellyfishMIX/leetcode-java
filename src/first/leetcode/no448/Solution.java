package first.leetcode.no448;

import java.util.LinkedList;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 * link: https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 *
 * @author JellyfishMIX
 * @date 2021/8/29 01:46
 */
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int length = nums.length;
        for (int num : nums) {
            int index = (num - 1) % length;
            nums[index] += length;
        }
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= length) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
