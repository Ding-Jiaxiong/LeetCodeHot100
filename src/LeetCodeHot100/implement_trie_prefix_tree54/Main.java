package LeetCodeHot100.implement_trie_prefix_tree54;

/**
 * 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。
 * <p>
 * 思路：前缀树的基本概念
 *
 * @author Ding Jiaxiong
 */

public class Main {

    static class Trie {

        private Trie[] chirlren;
        private boolean isEnd;

        public Trie() {

            chirlren = new Trie[26];
            isEnd = false;
        }

        public void insert(String word) {

            Trie node = this;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = c - 'a';

                if (node.chirlren[index] == null) {
                    node.chirlren[index] = new Trie();
                }

                node = node.chirlren[index];
            }

            node.isEnd = true;
        }

        public boolean search(String word) {
            Trie node = searchPrefix(word);
            return node != null && node.isEnd;
        }

        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        private Trie searchPrefix(String prefix) {

            Trie node = this;

            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                int index = c - 'a';

                if (node.chirlren[index] == null) {
                    return null;
                }
                node = node.chirlren[index];
            }

            return node;
        }


    }

    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 返回 True
        System.out.println(trie.search("app"));     // 返回 False
        System.out.println(trie.startsWith("app")); // 返回 True
        trie.insert("app");
        System.out.println(trie.search("app"));    // 返回 True

    }
}
