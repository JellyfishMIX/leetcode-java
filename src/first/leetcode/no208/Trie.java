package first.leetcode.no208;

/**
 * 208. 实现 Trie (前缀树)
 * link: https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 * 题解：https://leetcode-cn.com/problems/implement-trie-prefix-tree/solution/trie-tree-de-shi-xian-gua-he-chu-xue-zhe-by-huwt/
 *
 * @author JellyfishMIX
 * @date 2021/9/24 22:13
 */
public class Trie {
    public boolean isEnd;
    public Trie[] children = new Trie[26];

    /** Initialize your data structure here. */
    public Trie() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie pointer = this;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (pointer.children[index] == null) {
                pointer.children[index] = new Trie();
            }
            pointer = pointer.children[index];
        }
        pointer.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie pointer = this;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (pointer.children[index] == null) {
                return false;
            }
            pointer = pointer.children[index];
        }
        return pointer.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie pointer = this;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (pointer.children[index] == null) {
                return false;
            }
            pointer = pointer.children[index];
        }
        return true;
    }
}
