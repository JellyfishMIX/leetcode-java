package first.no350;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author JellyfishMIX
 * @date 2020/7/2 22:35
 */
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // 第一个参数是key，第二个参数value表示频次
        HashMap<Integer, Integer> map = new HashMap<>();
        // TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums1) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num)) {
                list.add(num);
                map.put(num, map.get(num) - 1);
                if (map.get(num) == 0) {
                    map.remove(num);
                }
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
