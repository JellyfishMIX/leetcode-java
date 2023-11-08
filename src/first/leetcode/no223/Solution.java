package first.leetcode.no223;

/**
 * 223. 矩形面积
 * link: https://leetcode-cn.com/problems/rectangle-area/
 *
 * @author JellyfishMIX
 * @date 2021/10/1 10:20
 */
public class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        // int ax1 = p1.x;
        // int ay1 = p1.y;
        // int ax2 = p2.x;
        // int ay2 = p2.y;
        // int bx1 = p3.x;
        // int by1 = p3.y;
        // int bx2 = p4.x;
        // int by2 = p4.y;
        int overLapWeight = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        int overLapHeight = Math.min(ay2, by2) - Math.max(ay1, by1);
        // 重叠面积
        int overLapArea = Math.max(overLapWeight, 0) * Math.max(overLapHeight, 0);
        int plusArea = (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1);
        // 两个矩形组合总面积
        return plusArea - overLapArea;
    }
}
