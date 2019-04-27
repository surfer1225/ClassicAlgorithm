package main.java.Trie;

public class TrieNode {
    boolean isEnd;
    TrieNode[] children;

    public TrieNode() {
        children = new TrieNode[26];
    }
}
