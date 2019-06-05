package main.java.trie;

public class TrieNode {
    boolean isEnd;
    TrieNode[] children;

    public TrieNode() {
        children = new TrieNode[26];
    }
}
