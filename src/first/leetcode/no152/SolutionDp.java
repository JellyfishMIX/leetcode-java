package first.leetcode.no152;

/**
 * 152. 乘积最大子数组
 * link: https://leetcode-cn.com/problems/maximum-product-subarray/
 * 题解：https://leetcode-cn.com/problems/maximum-product-subarray/solution/hua-jie-suan-fa-152-cheng-ji-zui-da-zi-xu-lie-by-g/
 *
 * @author JellyfishMIX
 * @date 2021/9/24 18:33
 */
public class SolutionDp {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int imax = 1;
        int imin = 1;
        for (int num : nums) {
            // 如果是负数，则交换 imax 和 min
            if (num < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(imax * num, num);
            imin = Math.min(imin * num, num);

            max = Math.max(max, imax);
        }
        return max;
    }
}