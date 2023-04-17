package com.leetcode.graph;

//        There is a new alien language that uses English alphabet. However, the order among the letters
//        is unknown to you.
//
//        You are given a list of strings words from the alien language's dictionay, where the strings in
//        words are sorted lexicographically by the rules of this new language.
//
//        Return a string of the unique letters in the new alien language sorted in lexicographically
//        increasing order by the new language's rules. If there is no solution, return "".
//        If there are multiple solutions, return any of them.
//
//        A string s is lexicographically smaller that a string t if at the first letter where they differ,
//        the letteris s comes before the letter t in the alien language. If the first min(s.length, t.length)
//        letters are the same, then s is smaller if and only if s.length < t.length.
//
//        Example1:
//        Input: words = ["wrt", "wrf", "er", "ett", "rftt"]
//        Output: "wertf"
//
//        Example2:
//        Input: words = ["z", "x", "z"]
//        Output: ""

import java.util.*;

public class AlienDictionary269 {

    public static void main(String[] args) {
        String result = alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"});
        System.out.println("Result: " + result);
    }

    public static String alienOrder(String[] words) {
        int[] indegree = new int[26];
        Map<Character, Set<Character>> g = new HashMap<>();
        buildGraph(g, words, indegree);
        return bfs(g, indegree);
    }

    private static String bfs(Map<Character, Set<Character>> g, int[] indegree) {
        StringBuilder sb = new StringBuilder();
        int totalChars = g.size();
        Queue<Character> q = new LinkedList<>();
        for (char c : g.keySet()) {
            if (indegree[c - 'a'] == 0) {
                sb.append(c);
                q.offer(c);
            }
        }

        while (!q.isEmpty()) {
            char cur = q.poll();
            if (g.get(cur) == null || g.get(cur).isEmpty()) {
                continue;
            }

            for (char neigh : g.get(cur)) {
                indegree[neigh - 'a']--;
                if (indegree[neigh - 'a'] == 0) {
                    q.offer(neigh);
                    sb.append(neigh);
                }
            }
        }
        return sb.length() == totalChars ? sb.toString() : "";
    }


    private static void buildGraph(Map<Character, Set<Character>> g, String[] words, int[] indegree) {
        for (String word : words) {
            for (char c : word.toCharArray()) {
                g.putIfAbsent(c, new HashSet<>());
            }
        }

        for (int i = 1; i < words.length; i++) {
            String first = words[i - 1];
            String second = words[i];
            int len = Math.min(first.length(), second.length());

            for (int j = 0; j < len; j++) {
                if (first.charAt(j) != second.charAt(j)) {
                    char out = first.charAt(j);
                    char in = second.charAt(j);

                    if (!g.get(out).contains(in)) {
                        g.get(out).add(in);
                        indegree[in - 'a']++;
                    }

                    break;
                }
            }
        }
    }
}
