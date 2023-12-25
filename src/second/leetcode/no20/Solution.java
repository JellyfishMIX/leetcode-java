package second.leetcode.no20;

import java.util.Stack;

/**
 * @author shijie.qian
 * @date 2023/12/26 01:16
 */
public class Solution {
    private Stack<Character> leftBracketStack = new Stack<>();

    public boolean isValid(String s) {
        // 不考虑空
        for (int i = 0; i < s.length(); i++) {
            char currentCharacter = s.charAt(i);
            // 是否为左括号
            if (checkLeftBracket(currentCharacter)) {
                // 左括号入栈
                leftBracketStack.push(currentCharacter);
                // 是否为右括号
            } else if (checkRightBracket(currentCharacter)) {
                // 当前为右括号，左括号栈没有剩余左括号了，直接不放行
                if (leftBracketStack.isEmpty()) {
                    return false;
                }
                // 出栈一个左括号
                char topLeftBracket = leftBracketStack.pop();
                // 检查左括号栈中是否有匹配的左括号
                if (!matchLeftAndRight(topLeftBracket, currentCharacter)) {
                    return false;
                }
            }
        }
        // 所有 char 遍历完毕，检查左括号是否还有剩余
        return leftBracketStack.size() == 0;
    }

    private boolean checkLeftBracket(char character) {
        return '(' == character || '[' == character || '{' == character;
    }

    private boolean checkRightBracket(char character) {
        return ')' == character || ']' == character || '}' == character;
    }

    private boolean matchLeftAndRight(char leftBracket, char rightBracket) {
        if (leftBracket == '(' && rightBracket == ')') {
            return true;
        } else if (leftBracket == '[' && rightBracket == ']') {
            return true;
        } else if (leftBracket == '{' && rightBracket == '}') {
            return true;
        } else {
            return false;
        }
    }
}
