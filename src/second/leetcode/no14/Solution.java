package second.leetcode.no14;

/**
 * @author shijie.qian
 * @date 2024/4/6 01:31
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // 不考虑空入参
        String firstStr = strs[0];
        // 纵向扫描第 i 列
        for (int i = 0; i < firstStr.length(); i++) {
            // 扫描每一个 str 的第 i 列
            for (int j = 0; j < strs.length; j++) {
                if (i == strs[j].length() || firstStr.charAt(i) != strs[j].charAt(i)) {
                    return firstStr.substring(0, i);
                }
            }
        }
        return firstStr;
    }
}
