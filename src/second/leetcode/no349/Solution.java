package second.leetcode.no349;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author shijie.qian
 * @date 2024/4/4 18:07
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        // 不考虑空入参
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }

        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            int currentInt = nums2[i];
            if (set1.contains(currentInt)) {
                result.add(currentInt);
            }
        }

        Iterator<Integer> iterator = result.iterator();
        int[] intResult = new int[result.size()];
        int resultIndex = 0;
        while (iterator.hasNext()) {
            int currentInt = iterator.next();
            intResult[resultIndex] = currentInt;
            resultIndex++;
        }
        return intResult;
    }
}
