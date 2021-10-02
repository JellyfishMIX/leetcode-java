package first.leetcode.no316;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 316. 去除重复字母
 * link: https://leetcode-cn.com/problems/remove-duplicate-letters/
 * 题解：https://leetcode-cn.com/problems/remove-duplicate-letters/solution/qu-chu-zhong-fu-zi-mu-by-leetcode-soluti-vuso/
 *
 * @author JellyfishMIX
 * @date 2021/9/26 15:36
 */
public class Solution {
    public String removeDuplicateLetters(String s) {
        // 分段单调递增栈，每一段单调递增，存储 charIndex，即 char - 'a'
        Deque<Character> monoStack = new LinkedList<>();
        // 栈中是否有某个字母
        boolean[] stackHas = new boolean[26];
        // 字符串中剩余字母对应个数
        int[] charNums = new int[26];
        // 填充 charNums
        for (char character : s.toCharArray()) {
            charNums[character - 'a'] += 1;
        }

        for (int i = 0; i < s.length(); i++) {
            int asciiOffset = s.charAt(i) - 'a';
            if (!stackHas[asciiOffset]) {
                while (!monoStack.isEmpty() && asciiOffset < monoStack.peek() - 'a') {
                    int top = monoStack.peek() - 'a';
                    if (charNums[top] > 0) {
                        monoStack.pop();
                        stackHas[top] = false;
                        // 后续字符串中没有栈顶字符了，拒绝出栈，跳出
                    } else {
                        break;
                    }
                }
                monoStack.push((char) (asciiOffset + 'a'));
                stackHas[asciiOffset] = true;
            }
            charNums[asciiOffset] -= 1;
        }
        StringBuilder result = new StringBuilder();
        monoStack.forEach(result::append);
        return result.reverse().toString();
    }

    @Test
    public void test() {
        String result = removeDuplicateLetters("bcabc");
        System.out.println(result);
    }
}
