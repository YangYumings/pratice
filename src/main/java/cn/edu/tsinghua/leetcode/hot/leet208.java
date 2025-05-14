package cn.edu.tsinghua.leetcode.hot;

public class leet208 {


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");   // 返回 True
        trie.search("app");     // 返回 False
        trie.startsWith("app"); // 返回 True
        trie.insert("app");
        trie.search("app");     // 返回 True
    }

    /**
     * 前缀树
     *
     * 208. 实现 Trie (前缀树)
     *
     * 思路：字典树
     */
    static class Trie {
        private Trie[] children;
        private boolean isEnd;

        public Trie() {
            children = new Trie[26];
            isEnd = false;
        }

        public void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int index = ch - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new Trie();
                }
                node = node.children[index];
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
            for(int i = 0; i < prefix.length(); i++){
                char ch = prefix.charAt(i);
                int index = ch - 'a';
                if(node.children[index] == null){
                    return null;
                }
                node = node.children[index];
            }
            return node;
        }
    }
}
