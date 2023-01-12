package com.leetcode.string;

//        Given two strings s and t of lengths m and n respectively, return the minimum window substring
//        of s such that every character in t (including duplicates) is included in the window.
//        If there is no such substring, return the empty string "".
//
//        The testcases will be generated such that the answer is unique.
//
//        Example 1:
//        Input: s = "ADOBECODEBANC", t = "ABC"
//        Output: "BANC"
//        Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
//
//        Example 2:
//        Input: s = "a", t = "a"
//        Output: "a"
//        Explanation: The entire string s is the minimum window.
//
//        Example 3:
//        Input: s = "a", t = "aa"
//        Output: ""
//        Explanation: Both 'a's from t must be included in the window.
//        Since the largest window of s only has one 'a', return empty string.

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring_76 {

    public static void main(String[] args) {
        String s = "ABAACBAB";
        String t = "ABC";
        String result = minWindow(s, t);
        System.out.println("Result: " + result);
    }

    /**
     * Time Complexity: O(S+T) where S and T represent the lengths of strings S and T
     * Space Complexity: O(S+T) when the window size is equal to the entire string S and T has all unique characters
     *
     * @param s
     * @param t
     * @return
     */
    public static String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            int count = tMap.getOrDefault(t.charAt(i), 0);
            tMap.put(t.charAt(i), count + 1);
        }

        int leftPointer = 0;

        int haveChar = 0;
        int needChar = tMap.size();

        Map<Character, Integer> sMap = new HashMap<>();

        int windowLength = -1;
        int[] windowStartEndPointer = {0, 0};

        for (int rightPointer = 0; rightPointer < s.length(); rightPointer++) {
            // Add one character from the right to the window
            char rightChar = s.charAt(rightPointer);
            int count = sMap.getOrDefault(rightChar, 0);
            sMap.put(rightChar, count + 1);

            // If the frequency of the current character added equals to the
            // desired count in t then increment the haveChar count by 1.
            if (tMap.containsKey(rightChar) && sMap.get(rightChar).intValue() == tMap.get(rightChar).intValue()) {
                haveChar++;
            }

            // Try and contract the window till the point where it ceases to be 'desirable'.
            while (leftPointer <= rightPointer && haveChar == needChar) {
                char leftChar = s.charAt(leftPointer);
                // Save the smallest window until now.
                if (windowLength == -1 || rightPointer - leftPointer + 1 < windowLength) {
                    windowLength = rightPointer - leftPointer + 1;
                    windowStartEndPointer[0] = leftPointer;
                    windowStartEndPointer[1] = rightPointer;
                }

                // The character at the position pointed by the
                // `Left` pointer is no longer a part of the window.
                sMap.put(leftChar, sMap.get(leftChar) - 1);

                if (tMap.containsKey(leftChar) && sMap.get(leftChar) < tMap.get(leftChar)) {
                    haveChar--;
                }

                // Move the left pointer ahead, this would help to look for a new window.
                leftPointer++;
            }
        }

        return windowLength == -1 ? "" : s.substring(windowStartEndPointer[0], windowStartEndPointer[1] + 1);
    }
}