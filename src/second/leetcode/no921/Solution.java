package second.leetcode.no921;

import java.util.Stack;

/**
 * @author shijie.qian
 * @date 2023/12/29 01:32
 */
public class Solution {
    /**
     * 存储 '(' 或 ')'
     */
    private Stack<Character> bracketStack = new Stack<>();

    public int minAddToMakeValid(String s) {
        // 不考虑空
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (areLeftBracket(currentChar)) {
                bracketStack.add(currentChar);
            }
            if (areRightBracket(currentChar)) {
                // 栈顶为空，) 直接入栈
                if (bracketStack.isEmpty()) {
                    bracketStack.add(currentChar);
                    continue;
                }
                char topBracket = bracketStack.peek();
                // 栈顶为 (, 和当前 ) 配对，出栈
                if (areLeftBracket(topBracket)) {
                    bracketStack.pop();
                    // 栈顶非 (, 无法和当前 ) 配对，) 入栈
                } else {
                    bracketStack.add(currentChar);
                }
            }
        }
        // 栈中剩余括号数即为未配对的
        return bracketStack.size();
    }

    private boolean areLeftBracket(char character) {
        return '(' == character;
    }

    private boolean areRightBracket(char character) {
        return ')' == character;
    }
}
