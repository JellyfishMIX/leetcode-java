package second.leetcode.no49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shijie.qian
 * @date 2024/3/19 01:54
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> resultMap = new HashMap<>();
        // 不考虑空入参
        for (String currentStr : strs) {
            char[] currentChars = currentStr.toCharArray();
            Arrays.sort(currentChars);
            String key = new String(currentChars);
            List<String> valueSet = resultMap.computeIfAbsent(key, (thisKey) -> new ArrayList<>());
            valueSet.add(currentStr);
        }

        List<List<String>> resultList = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : resultMap.entrySet()) {
            resultList.add(new ArrayList<>(entry.getValue()));
        }
        return resultList;
    }
}
