package dsa.leetcode150;

//https://leetcode.com/problems/implement-trie-prefix-tree/

public class Trie {
    private TrieNode root = new TrieNode();
    public Trie() {
    }

    public void insert(String word) {
        TrieNode node = root;
        for(char c: word.toCharArray()) {
            node = node.addChild(c);
        }
        node.setWord(true);
    }

    public boolean search(String word) {
        TrieNode node = root;
        for(char c: word.toCharArray()) {
            node = node.getChild(c);
            if(node==null)return false;
        }
        return node.isWord();
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(char c: prefix.toCharArray()) {
            node = node.getChild(c);
            if(node==null)return false;
        }
        return true;
    }
}
