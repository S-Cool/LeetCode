package com.leetcode.tree;

//        Given an m x n board of characters and a list of strings words, return all words on the board.
//
//        Each word must be constructed from letters of sequentially adjacent cells, where adjacent
//        cells are horizontally or vertically neighboring. The same letter cell may not be used
//        more than once in a word.
//
//        Example 1:
//        Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]],
//        words = ["oath","pea","eat","rain"]
//        Output: ["eat","oath"]
//
//        Example 2:
//        Input: board = [["a","b"],["c","d"]], words = ["abcb']
//        Output: []

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordSearchII_212 {

    public static void main(String[] args) {

        char[][] matrix = {{'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}};

        String[] words = {"oath", "pea", "eat", "rain"};

        WordSearchII_212 searchII212 = new WordSearchII_212();
        List<String> strings = searchII212.findWords(matrix, words);
        System.out.println("Result: " + strings.toString());
    }

    TrieNode root = new TrieNode();
    boolean[][] flag;

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        flag = new boolean[board.length][board[0].length];

        addToTrie(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.child[board[i][j] - 'a'] != null) {
                    search(board, i, j, root, "", result);
                }
            }
        }

        return new LinkedList<>(result);
    }

    private void addToTrie(String[] words) {
        for (String word : words) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (node.child[ch - 'a'] == null) {
                    node.child[ch - 'a'] = new TrieNode();
                }
                node = node.child[ch - 'a'];
            }
            node.isEndOfWord = true;
        }
    }

    private void search(char[][] board, int i, int j, TrieNode node, String word, Set<String> result) {
        if (i >= board.length || i < 0 || j >= board[i].length || j < 0 || flag[i][j]) {
            return;
        }

        if (node.child[board[i][j] - 'a'] == null) {
            return;
        }

        flag[i][j] = true;
        node = node.child[board[i][j] - 'a'];
        if (node.isEndOfWord) {
            result.add(word + board[i][j]);
        }

        search(board, i - 1, j, node, word + board[i][j], result);
        search(board, i + 1, j, node, word + board[i][j], result);
        search(board, i, j - 1, node, word + board[i][j], result);
        search(board, i, j + 1, node, word + board[i][j], result);

        flag[i][j] = false;
    }

    private static class TrieNode {
        boolean isEndOfWord;
        TrieNode[] child;

        public TrieNode() {
            this.isEndOfWord = false;
            this.child = new TrieNode[26];
        }
    }
}