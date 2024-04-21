package second.leetcode.no406;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shijie.qian
 * @date 2024/4/19 19:20
 */
public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                // 第一个元素不相等时，按第一个元素降序
                return o2[0] - o1[0];
            } else {
                // 第一个元素相等，按第二个元素升序
                return o1[1] - o2[1];
            }
        });

        List<int[]> resultList = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            // 结果集中人数小于等于第 i 人前排队人数时，直接放到结果集末尾
            if (resultList.size() <= people[i][1]) {
                resultList.add(resultList.size(), people[i]);
            } else {
                // 结果集中人数大于第 i 人前排队人数时，插入到结果集的 people[i][1] 位置，即第 i 人前应有的排队人数位置
                resultList.add(people[i][1], people[i]);
            }
        }

        return resultList.toArray(new int[resultList.size()][]);
    }
}
