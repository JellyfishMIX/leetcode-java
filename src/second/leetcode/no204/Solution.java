package second.leetcode.no204;

import java.util.Arrays;

/**
 * 计算质数，只能被 1 或本身整除的是质数
 *
 * @author shijie.qian
 * @date 2024/3/21 11:20
 */
public class Solution {
    public int countPrimes(int n) {
        boolean[] primeBooleanArray = new boolean[n];
        // 初始化
        Arrays.fill(primeBooleanArray, true);
        // 寻找 [2, n) 的质数个数
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (primeBooleanArray[i]) {
                // 质数的倍数不是质数
                for (int j = 2 * i; j < n; j += i) {
                    primeBooleanArray[j] = false;
                }
            }
        }
        int primeCount = 0;
        for (int i = 2; i < n; i++) {
            if (primeBooleanArray[i]) {
                primeCount++;
            }
        }
        return primeCount;
    }
}
