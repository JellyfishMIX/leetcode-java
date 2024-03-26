package second.leetcode.test;

import second.leetcode.no128.Solution;

/**
 * @author shijie.qian
 * @date 2024/3/19 12:49
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = new int[] {100,4,200,1,3,2};
        int outcome = solution.longestConsecutive(input);
        System.out.println(outcome);
    }
}
