package first.leetcode.no307;

/**
 * Time limit exceeded
 *
 * @author JellyfishMIX
 * @date 2020/10/1 14:43
 */
class NumArray {

    /**
     * sum[i] stores the sum of the first i elements
     */
    private int[] sum;
    /**
     * record the origin array
     */
    private int[] data;

    public NumArray(int[] nums) {
        data = nums;
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    public void update(int i, int val) {
        data[i] = val;
        for (int j = i + 1; j < sum.length; j++) {
            sum[j] = sum[j - 1] + data[j - 1];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
