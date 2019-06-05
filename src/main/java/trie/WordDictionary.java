package main.java.trie;

/*
Design a data structure that supports the following two operations:
void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string
containing only letters a-z or .. A . means it can represent any one letter.
Example:
addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.
 */
public class WordDictionary {

    class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        public TrieNode() {
            this.isEnd = false;
            this.children = new TrieNode[26];
        }
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        this.root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = this.root;
        for (char c:word.toCharArray()) {
            int i = c-'a';
            if (node.children[i]==null) node.children[i]=new TrieNode();
            node = node.children[i];
        }
        node.isEnd = true;
    }

    private boolean searchFromNode(TrieNode node, String word) {
        if (node == null) return false;
        if (word.isEmpty()) return node.isEnd;
        char c = word.charAt(0);
        if (c=='.') {
            for (TrieNode tn:node.children) {
                if (searchFromNode(tn, word.substring(1))) return true;
            }
            return false;
        }
        else {
            return searchFromNode(node.children[c-'a'], word.substring(1));
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchFromNode(this.root, word);
    }

    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        wd.addWord("bad");
        wd.addWord("dad");
        wd.addWord("mad");
        System.out.println(wd.search("pad"));
        System.out.println(wd.search("bad"));
        System.out.println(wd.search(".ad"));
        System.out.println(wd.search("..d"));
    }
}