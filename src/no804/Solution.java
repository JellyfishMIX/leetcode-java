package no804;

import java.util.TreeSet;
import java.util.HashMap;

/**
 * 804. 唯一摩尔斯密码词
 *
 * @author JellyfishMIX
 * @date 2020/6/30 11:07
 */
public class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        // TreeSet<String> set = new TreeSet<>();
        HashMap<String, Integer> hashMap = new HashMap<>(100);
        for (String word : words) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                stringBuilder.append(codes[word.charAt(i) - 'a']);
            }
            // set.add(stringBuilder.toString());
            hashMap.put(stringBuilder.toString(), null);
        }

        // return set.size();
        return hashMap.size();
    }
}
