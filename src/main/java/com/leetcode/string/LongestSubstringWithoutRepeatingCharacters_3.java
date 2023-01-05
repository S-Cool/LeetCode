package com.leetcode.string;

import java.util.HashMap;
import java.util.Map;

//        Given a string s, find the length of the longest substring without repeating characters.
//
//        Example 1:
//        Input: s = "abcabcbb"
//        Output: 3
//        Explanation: The answer is "abc", with the length of 3.
//
//        Example 2:
//        Input: s = "bbbbb"
//        Output: 1
//        Explanation: The answer is "b", with the length of 1.
//
//        Example 3:
//        Input: s = "pwwkew"
//        Output: 3
//        Explanation: The answer is "wke", with the length of 3.
//
//        Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

public class LongestSubstringWithoutRepeatingCharacters_3 {
    public static void main(String[] args) {
        int result = lengthOfLongestSubstring("abcabcbb");
        System.out.println("Result: " + result);
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;

        for (int left = 0, right = 0; left < s.length(); ++left) {

            if (map.containsKey(s.charAt(left))) {
                right = Math.max(right, map.get(s.charAt(left)) + 1);
            }

            map.put(s.charAt(left), left);
            maxLength = Math.max(maxLength, left - right + 1);
        }
        return maxLength;
    }
}
