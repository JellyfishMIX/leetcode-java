package second.leetcode.no88;

/**
 * @author shijie.qian
 * @date 2024/4/15 21:57
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] mergedArray = new int[m + n];
        int pointer1 = 0;
        int pointer2 = 0;
        int mergedIndex = 0;
        while (pointer1 < m && pointer2 < nums2.length) {
            int mergeResult = 0;
            int value1 = nums1[pointer1];
            int value2 = nums2[pointer2];
            if (value1 < value2) {
                mergeResult = value1;
                pointer1++;
            } else {
                mergeResult = value2;
                pointer2++;
            }
            mergedArray[mergedIndex] = mergeResult;
            mergedIndex++;
        }

        while (pointer1 < m) {
            mergedArray[mergedIndex] = nums1[pointer1];
            pointer1++;
            mergedIndex++;
        }

        while (pointer2 < nums2.length) {
            mergedArray[mergedIndex] = nums2[pointer2];
            pointer2++;
            mergedIndex++;
        }

        System.arraycopy(mergedArray, 0, nums1, 0, m + n);
    }
}
