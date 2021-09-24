package first.leetcode.no152;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 152. 乘积最大子数组
 * link: https://leetcode-cn.com/problems/maximum-product-subarray/
 * 前缀积
 *
 * @author JellyfishMIX
 * @date 2021/9/24 17:25
 */
public class SolutionPreMultiply {
    public int maxProduct(int[] nums) {
        List<List<Integer>> segmentArrayList = new ArrayList<>();
        // 把 nums 从 0 处切分为多个数组
        List<Integer> eachArray = new ArrayList<>();
        for (int num : nums) {
            if (num == 0) {
                segmentArrayList.add(eachArray);
                eachArray = new ArrayList<>();
                continue;
            }
            eachArray.add(num);
        }
        // 把 foreach 中最后一个 0 后面的数组添加进 segmentArrayList
        segmentArrayList.add(eachArray);
        int result = Integer.MIN_VALUE;
        for (List<Integer> array : segmentArrayList) {
            result = Math.max(result, eachMaxProduct(array.stream().mapToInt(Integer::intValue).toArray()));
        }
        // 如果 nums 中有 0，需要把切分后的子数组最小乘积和 0 比较，因为切分后的子数组中没有 0
        if (segmentArrayList.size() > 1) {
            return Math.max(result, 0);
        }
        return result;
    }

    private int eachMaxProduct(int[] nums) {
        // 前缀积
        int[] preMultiply = new int[nums.length + 1];
        preMultiply[0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            preMultiply[i] = preMultiply[i - 1] * nums[i - 1];
        }
        // [i, j] 的积为 preMultiply[j + 1] / preMultiply[i]
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                result = Math.max(result, preMultiply[j + 1] / preMultiply[i]);
            }
        }
        return result;
    }

    @Test
    public void test0() {
        int result = maxProduct(new int[]{2, 3, -2, 4});
        System.out.println(result);
    }

    @Test
    public void test1() {
        int result = maxProduct(new int[]{-2, 0, -1});
        System.out.println(result);
    }
}
