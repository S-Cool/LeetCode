package com.leetcode.tree;

//        A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store
//        and retrieve keys in a dataset of strings. There are various applications of this data
//        structure, such as autocomplete and spellchecker.
//
//        Implement the Trie class:
//
//        Trie() Initializes the trie object.
//        void insert(String word) Inserts the string word into the trie.
//        boolean search(String word) Returns true if the string word is in the trie
//        (i.e., was inserted before), and false otherwise.
//        boolean startsWith(String prefix) Returns true if there is a previously inserted string
//        word that has the prefix, and false otherwise.
//
//        Example 1:
//        Input
//        ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
//        [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
//        Output
//        [null, null, true, false, true, null, true]
//
//        Explanation
//        Trie trie = new Trie();
//        trie.insert("apple");
//        trie.search("apple");   // return True
//        trie.search("app");     // return False
//        trie.startsWith("app"); // return True
//        trie.insert("app");
//        trie.search("app");     // return True

public class ImplementTriePrefixTree_208 {

    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");
        trie.search("app");
        boolean result = trie.startsWith("app");
        System.out.println("Start with *app*-. Result - " + result);
        trie.insert("app");
        trie.search("app");
    }

    public static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
            System.out.println("Trie created;");
        }

        public void insert(String word) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                int character = word.charAt(i) - 'a';
                if (current.children[character] == null) {
                    current.children[character] = new TrieNode();
                    current.children[character].isEnd = false;
                }
                current = current.children[character];
            }
            current.isEnd = true;
            System.out.println("Inserted - *" + word + "*");
        }

        public boolean search(String word) {
            TrieNode current = root;
            int i = -1;
            int length = word.length();
            while (++i < length) {
                int id = word.charAt(i) - 'a';
                if ((current = current.children[id]) == null) return false;
            }
            System.out.println("Search *" + word + "*. Result - *" + current.isEnd + "*");
            return current.isEnd;
        }

        public boolean startsWith(String prefix) {
            TrieNode current = root;
            int i = -1;
            int length = prefix.length();
            while (++i < length) {
                int id = prefix.charAt(i) - 'a';
                if ((current = current.children[id]) == null) return false;
            }
            return true;
        }
    }

    public static class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        public TrieNode() {
            isEnd = true;
            children = new TrieNode[26];
        }
    }
}