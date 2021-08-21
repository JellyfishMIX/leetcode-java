package no14;

/**
 * 14. 最长公共前缀
 * link: https://leetcode-cn.com/problems/longest-common-prefix/
 * 纵向扫描
 *
 * @author JellyfishMIX
 * @date 2021/8/21 10:32
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null) {
            return "";
        }

        int strNum = strs.length;
        String specificStr = strs[0];
        for (int i = 0; i < specificStr.length(); i++) {
            for (int j = 1; j < strNum; j++) {
                if (i == strs[j].length() || specificStr.charAt(i) != strs[j].charAt(i)) {
                    return specificStr.substring(0, i);
                }
            }
        }
        return specificStr;
    }
}
