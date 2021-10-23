package first.leetcode.no492;

/**
 * 492. 构造矩形
 * link: https://leetcode-cn.com/problems/construct-the-rectangle/
 * 题解：https://leetcode-cn.com/problems/construct-the-rectangle/solution/wei-rao-li-lun-yin-shi-fen-jie-qiu-zui-j-n1u2/
 *
 * @author JellyfishMIX
 * @date 2021/10/23 20:35
 */
public class Solution {
    public int[] constructRectangle(int area) {
        int weight = 1;
        int length = area;
        for (int i = 1; i <= Math.sqrt(area); i++) {
            if (area % i == 0) {
                weight = i;
                length = area / weight;
            }
        }

        return new int[]{length, weight};
    }
}
