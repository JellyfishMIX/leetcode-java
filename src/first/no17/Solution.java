package first.no17;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * link: https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 *
 * @author JellyfishMIX
 * @date 2021/8/22 02:08
 */
public class Solution {
    private static Map<Character, String> phoneMap = new HashMap<>() {
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };
    private String digits;
    private List<String> result;
    private StringBuilder combination;

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return result;
        }
        this.digits = digits;
        result = new LinkedList<>();
        combination = new StringBuilder();
        backTrack(0);
        return result;
    }

    private void backTrack(int index) {
        if (index == digits.length()) {
            result.add(combination.toString());
            return;
        }
        char digit = digits.charAt(index);
        String letters = phoneMap.get(digit);
        for (int i = 0; i < letters.length(); i++) {
            // 动态维护输出结果
            combination.append(letters.charAt(i));
            backTrack(index + 1);
            // 撤销操作
            combination.deleteCharAt(index);
        }
    }
}
