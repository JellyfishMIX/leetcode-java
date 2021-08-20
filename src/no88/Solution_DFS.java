package no88;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author JellyfishMIX
 * @date 2021/8/9 02:52
 */
public class Solution_DFS {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // nuns1 的指针
        int a = 0;
        // nuns2 的指针
        int b = 0;
        // sorted array
        int[] sortedArray = new int[m + n];
        int cur = 0;
        while (a < m || b < n) {
            if (a == m) {
                cur = nums2[b++];
            } else if (b == n) {
                cur = nums1[a++];
            } else if (nums1[a] < nums2[b]) {
                cur = nums1[a++];
            } else {
                cur = nums2[b++];
            }
            sortedArray[a + b - 1] = cur;
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = sortedArray[i];
        }
    }

    @Test
    public void test() {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
