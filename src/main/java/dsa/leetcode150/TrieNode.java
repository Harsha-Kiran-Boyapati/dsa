package dsa.leetcode150;

import lombok.Getter;
import lombok.Setter;

public class TrieNode {
    TrieNode[] children;
    @Getter
    @Setter
    private boolean word = false;

    public TrieNode() {
    }
    public TrieNode addChild(char c) {
        if(this.children == null) {
            this.children = new TrieNode[26];
        }
        if(this.children[c-'a'] == null) {
            this.children[c-'a'] = new TrieNode();
        }
        return this.children[c-'a'];
    }

    public TrieNode getChild(char c) {
        if(this.children != null) return this.children[c-'a'];
        else return null;
    }

}
