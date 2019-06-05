package main.java.trie;

public class Trie {

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;

        for (char c:word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index]==null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }

        node.isEnd = true;
    }

    private TrieNode searchWord(String word) {
        TrieNode node = root;

        for (char c:word.toCharArray()) {
            if (node.children[c-'a']==null) return null;
            else node=node.children[c-'a'];
        }

        return node;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchWord(word);
        return node!=null && node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchWord(prefix)!=null;
    }
}
