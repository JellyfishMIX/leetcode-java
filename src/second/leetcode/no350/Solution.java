package second.leetcode.no350;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author shijie.qian
 * @date 2024/4/4 18:30
 */
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // key: int, 次数
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            map1.merge(nums1[i], 1, Integer::sum);
        }
        for (int i = 0; i < nums2.length; i++) {
            map2.merge(nums2[i], 1, Integer::sum);
        }

        List<Integer> listResult = new ArrayList<>();
        Iterator<Integer> map1Iterator = map1.keySet().iterator();
        while (map1Iterator.hasNext()) {
            int currentInt = map1Iterator.next();
            if (map2.containsKey(currentInt)) {
                int count = Math.min(map1.get(currentInt), map2.get(currentInt));
                for (int i = 0; i < count; i++) {
                    listResult.add(currentInt);
                }
            }
        }

        int[] result = new int[listResult.size()];
        for (int i = 0; i < listResult.size(); i++) {
            result[i] = listResult.get(i);
        }
        return result;
    }
}
