package second.leetcode.no394;

import java.util.Stack;

/**
 * @author shijie.qian
 * @date 2024/4/19 18:55
 */
public class Solution {
    private int multiNum = 0;
    private StringBuilder result = new StringBuilder();
    private Stack<Integer> multiNumStack = new Stack<>();
    private Stack<StringBuilder> resultStack = new Stack<>();

    public String decodeString(String s) {
        char[] inputChars = s.toCharArray();


        for (int i = 0; i < inputChars.length; i++) {
            char currentChar = inputChars[i];
            if ('[' == currentChar) {
                // 遇到 [, 使用栈记录当前 multiNum 和当前 result, 当前值置零
                multiNumStack.push(multiNum);
                resultStack.push(result);
                multiNum = 0;
                result = new StringBuilder();
            } else if (']' == currentChar) {
                // 遇到 ], 栈中 multiNum 和栈中 result 出栈，叠加当前值
                int multiNum = multiNumStack.pop();
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < multiNum; j++) {
                    temp.append(result);
                }
                result = resultStack.pop().append(temp);
            } else if ('0' <= currentChar && '9' >= currentChar) {
                multiNum = multiNum * 10 + (currentChar - '0');
            } else {
                result.append(currentChar);
            }
        }
        return result.toString();
    }
}
