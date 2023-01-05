package com.leetcode.string;

//        Given an array of strings strs, group the anagrams together. You can return the answer in any order.
//
//        An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
//        typically using all the original letters exactly once.
//
//        Example 1:
//        Input: strs = ["eat","tea","tan","ate","nat","bat"]
//        Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
//
//        Example 2:
//        Input: strs = [""]
//        Output: [[""]]
//
//        Example 3:
//        Input: strs = ["a"]
//        Output: [["a"]]

import java.util.*;

public class GroupAnagrams_49 {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(strs);
        System.out.println("Result: " + result);
    }

    /**
     * Time Complexity: O(M*N logN)
     * Space Complexity: O(M*N)
     *
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> result = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String value = String.valueOf(chars);
            if (!result.containsKey(value)) {
                result.put(value, new ArrayList<>(List.of(str)));
            } else {
                result.get(value).add(str);
            }
        }

        return new ArrayList<>(result.values());
    }
}
