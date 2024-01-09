package second.leetcode.no316;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author shijie.qian
 * @date 2024/1/9 11:09
 */
public class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> noDuplicateStack = new Stack<>();
        // key: char，value 表示此 char 在 noDuplicateStack 中是否包含
        Map<Character, Boolean> stackContainsMap = new HashMap<>();
        // key: char，value 表示此 char 在 inputStr 中剩余的数量
        Map<Character, Integer> charCountMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            charCountMap.merge(currentChar, 1, Integer::sum);
        }

        // 不考虑空
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            charCountMap.merge(currentChar, -1, Integer::sum);
            // 保证不重复
            if (stackContains(stackContainsMap, currentChar)) {
                continue;
            }
            // 栈顶元素字典序大于 currentChar，需要出栈
            while (!noDuplicateStack.isEmpty() && noDuplicateStack.peek() > currentChar) {
                // 剩余没有这个 char 了，不能移除
                if (charCountMap.get(noDuplicateStack.peek()) <= 0) {
                    break;
                }
                // 出栈
                char topChar = noDuplicateStack.pop();
                stackContainsMap.put(topChar, false);
            }

            // 入栈
            noDuplicateStack.push(currentChar);
            stackContainsMap.put(currentChar, true);
        }

        StringBuilder stringBuilder = new StringBuilder();
        // 输出栈中 char
        while (!noDuplicateStack.isEmpty()) {
            char topChar = noDuplicateStack.pop();
            stringBuilder.append(topChar);
        }
        // for (Character character : noDuplicateStack) {
        //     stringBuilder.append(character);
        // }
        // 栈存储的字符串顺序反着的，需要 reverse
        return stringBuilder.reverse().toString();
    }

    private boolean stackContains(Map<Character, Boolean> stackContainsMap, char currentChar) {
        Boolean containsFlag = stackContainsMap.get(currentChar);
        return containsFlag != null && containsFlag;
    }
}
