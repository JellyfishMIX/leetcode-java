package first.leetcode.no739;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 739. 每日温度
 * link: https://leetcode-cn.com/problems/daily-temperatures/
 * 递减栈
 * 题解：https://leetcode-cn.com/problems/daily-temperatures/solution/leetcode-tu-jie-739mei-ri-wen-du-by-misterbooo/
 *
 * @author JellyfishMIX
 * @date 2021/9/23 14:45
 */
public class Solution {
    private class Temperature {
        private int day;
        private int temperature;

        public Temperature(int day, int temperature) {
            this.day = day;
            this.temperature = temperature;
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        // 在第 i 天，需要等几天才会有更高的温度
        int[] result = new int[temperatures.length];
        // 递减栈
        Deque<Temperature> stack = new LinkedList<>();
        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty()) {
                stack.push(new Temperature(i, temperatures[i]));
            } else {
                while (!stack.isEmpty() && temperatures[i] > stack.peek().temperature) {
                    Temperature stackTemperature = stack.pop();
                    result[stackTemperature.day] = i - stackTemperature.day;
                }
                stack.push(new Temperature(i, temperatures[i]));
            }
        }
        return result;
    }
}
