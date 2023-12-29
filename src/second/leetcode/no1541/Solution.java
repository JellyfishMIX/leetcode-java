package second.leetcode.no1541;

import java.util.Stack;

/**
 * @author shijie.qian
 * @date 2023/12/29 15:46
 */
public class Solution {
    private Stack<Character> leftBracketStack = new Stack<>();

    public static void main(String[] args) {
        Solution solution = new Solution();

        String input = "()()()()()(";
        int output = solution.minInsertions(input);
        System.out.println(output);
    }

    public int minInsertions(String s) {
        int needInsertBracketNum = 0;
        int maxIndex = s.length() - 1;
        // 不考虑空
        for (int currentIndex = 0; currentIndex < s.length(); currentIndex++) {
            char currentChar = s.charAt(currentIndex);
            // 当前为 '(', 直接入栈
            if (areLeftBracket(currentChar)) {
                leftBracketStack.add(currentChar);
            }
            // 当前为 ')'
            if (areRightBracket(currentChar)) {
                // 当前为最后一个元素
                if (currentIndex == maxIndex) {
                    // 栈为空，需要补一个 '(' 和一个 ')'
                    if (leftBracketStack.isEmpty()) {
                        needInsertBracketNum += 2;
                    } else {
                        // 栈不为空，出栈一个 '('，还需补充一个 ')'
                        leftBracketStack.pop();
                        needInsertBracketNum++;
                    }
                    // 当前不为最后一个元素
                } else {
                    int nextIndex = currentIndex + 1;
                    // 下一个元素为 ')'
                    char nextChar = s.charAt(nextIndex);
                    if (areRightBracket(nextChar)) {
                        // 栈为空，需要补一个 '(', 同时 index 移动至下一位
                        if (leftBracketStack.isEmpty()) {
                            needInsertBracketNum++;
                            currentIndex++;
                        } else {
                            // 栈不为空，出栈一个 '(', 无需补括号, index 移动至下一位
                            leftBracketStack.pop();
                            currentIndex++;
                        }
                        // 下一个元素不为 ')'
                    } else {
                        // 栈为空，需要补一个 '(' 和 ')', 同时 index 移动至下一位
                        if (leftBracketStack.isEmpty()) {
                            needInsertBracketNum += 2;
                            currentIndex++;
                        } else {
                            // 栈不为空，出栈一个 '(', 需补一个 ')', index 移动至下一位
                            leftBracketStack.pop();
                            needInsertBracketNum++;
                            currentIndex++;
                        }
                        // 补充一下，下一个元素为 '(' 则入栈
                        if (areLeftBracket(nextChar)) {
                            leftBracketStack.add(nextChar);
                        }
                    }
                }
            }
        }

        // needInsertBracketNum + leftBracketStack 里剩余 '(' 数量 * 2
        needInsertBracketNum += leftBracketStack.size() * 2;
        return needInsertBracketNum;
    }

    private boolean areLeftBracket(char character) {
        return '(' ==  character;
    }

    private boolean areRightBracket(char character) {
        return ')' == character;
    }
}
