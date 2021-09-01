package first.leetcode.no461;

/**
 * 461. 汉明距离
 * link: https://leetcode-cn.com/problems/hamming-distance/
 *
 * @author JellyfishMIX
 * @date 2021/8/30 16:42
 */
public class Solution {
    public int hammingDistance(int x, int y) {
        int xorResult = x ^ y;
        int result = 0;
        while (xorResult != 0) {
            int tailBinary = xorResult & 1;
            if (tailBinary == 1) {
                result += 1;
            }
            xorResult >>= 1;
        }
        return result;
    }
}
