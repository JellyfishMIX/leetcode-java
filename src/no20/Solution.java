package no20;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 20. 有效的括号
 * link: https://leetcode-cn.com/problems/valid-parentheses/
 *
 * @author JellyfishMIX
 * @date 2021/8/18 13:03
 */
public class Solution {
    private Map<Character, Character> pairs = new HashMap<>() {
        {
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }
    };

    public boolean isValid(String s) {
        int length = s.length();
        // 奇数长度的字符串直接返回 false
        if (length % 2 == 1) {
            return false;
        }

        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            char character = s.charAt(i);
            if (pairs.containsKey(character)) {
                if (!stack.isEmpty() && stack.peek() == pairs.get(character)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(character);
            }
        }
        return stack.isEmpty();
    }
}
