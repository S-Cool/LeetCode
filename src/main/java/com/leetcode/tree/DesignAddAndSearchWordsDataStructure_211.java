package com.leetcode.tree;

//        Design a data structure that supports adding new words and finding if a string matches any previously
//        added string.
//
//        Implement the WordDictionary class:
//        WordDictionary() Initializes the object.
//        void addWord(word) Adds word to the data structure, it can be matched later.
//        bool search(word) Returns true if there is any string in the data structure that matches word
//        or false otherwise. word may contain dots '.' where dots can be matched with any letter.
//
//        Example:
//        Input
//        ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
//        [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
//        Output
//        [null,null,null,null,false,true,true,true]
//
//        Explanation
//        WordDictionary wordDictionary = new WordDictionary();
//        wordDictionary.addWord("bad");
//        wordDictionary.addWord("dad");
//        wordDictionary.addWord("mad");
//        wordDictionary.search("pad"); // return False
//        wordDictionary.search("bad"); // return True
//        wordDictionary.search(".ad"); // return True
//        wordDictionary.search("b.."); // return True

public class DesignAddAndSearchWordsDataStructure_211 {

    public static void main(String[] args) {

        WordDictionary wordDictionary = new WordDictionary();
        System.out.println("Trie created;");

        wordDictionary.addWord("bad");
        System.out.println("Inserted - *bad*");

        wordDictionary.addWord("dad");
        System.out.println("Inserted - *dad*");

        wordDictionary.addWord("mad");
        System.out.println("Inserted - *mad*");

        boolean isPadExist = wordDictionary.search("pad");
        System.out.println("Search *pad*. Result - " + isPadExist);

        boolean isBadExist = wordDictionary.search("bad");
        System.out.println("Search *bad*. Result - " + isBadExist);

        boolean isXadExist = wordDictionary.search(".ad");
        System.out.println("Search *.ad*. Result - " + isXadExist);

        boolean isBXXExist = wordDictionary.search("b..");
        System.out.println("Search *b..*. Result - " + isBXXExist);
    }

    public static class WordDictionary {
        private final WordDictionary[] children;
        private boolean isEndOfWord;

        public WordDictionary() {
            children = new WordDictionary[26];
            isEndOfWord = false;
        }

        /**
         * Time complexity : O(n)
         * Space complexity : O(n)
         *
         * @param word
         */
        public void addWord(String word) {
            WordDictionary curr = this;
            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null)
                    curr.children[c - 'a'] = new WordDictionary();
                curr = curr.children[c - 'a'];
            }
            curr.isEndOfWord = true;
        }

        /**
         * Time complexity : O(m * n)
         * Space complexity : O(n)
         *
         * @param word
         * @return
         */
        public boolean search(String word) {
            WordDictionary curr = this;
            for (int i = 0; i < word.length(); ++i) {
                char c = word.charAt(i);
                if (c == '.') {
                    for (WordDictionary ch : curr.children)
                        if (ch != null && ch.search(word.substring(i + 1))) {
                            return true;
                        }
                    return false;
                }
                if (curr.children[c - 'a'] == null) return false;
                curr = curr.children[c - 'a'];
            }
            return curr != null && curr.isEndOfWord;
        }
    }
}
