package second.leetcode.no17;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shijie.qian
 * @date 2024/4/6 20:12
 */
public class Solution {
    private StringBuilder candidates = new StringBuilder();
    private List<String> result = new ArrayList<>();
    private int targetLength = 0;

    Map<Character, String> digitMap = new HashMap<Character, String>(){{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        this.targetLength = digits.length();
        char[] digitChars = digits.toCharArray();
        // 不考虑 null 入参
        if (digitChars.length == 0) {
            return result;
        }
        backtrack(digitChars, 0);
        return result;
    }

    private void backtrack(char[] digitChars, int digitIndex) {
        // base case
        if (digitIndex == targetLength) {
            result.add(candidates.toString());
            return;
        }

        String digitStr = digitMap.get(digitChars[digitIndex]);
        for (int i = 0; i < digitStr.length(); i++) {
            // 选择
            candidates.append(String.valueOf(digitStr.charAt(i)));
            // 递归
            backtrack(digitChars, digitIndex + 1);
            // 撤销选择
            candidates.deleteCharAt(digitIndex);
        }
    }
}
