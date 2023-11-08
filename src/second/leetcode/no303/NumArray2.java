package second.leetcode.no303;

/**
 * @link https://leetcode.cn/problems/range-sum-query-immutable/description/
 * @author shijie.qian
 * @date 2023/11/8 18:45
 */
class NumArray2 {
    public final int[] preSumArr;

    public NumArray2(int[] nums) {
        // 不考虑判空
        int[] preSumArr = new int[nums.length + 1];
        for (int i = 1; i < preSumArr.length; i++) {
            preSumArr[i] = nums[i - 1] + preSumArr[i - 1];
        }
        this.preSumArr = preSumArr;
    }

    public int sumRange(int left, int right) {
        return preSumArr[right + 1] - preSumArr[left];
    }

    public static void main(String[] args) {
        new NumArray(new int[]{4, 3, 2, 8});
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */

/**
 * 4, 3, 2, 8
 * 0, 4, 7, 9, 17
 * left: 0, right: 3
 */
