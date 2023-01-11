package com.leetcode.string;

//        Given a string s, return the longest palindromic substring in s.
//
//        Example 1:
//        Input: s = "babad"
//        Output: "bab"
//        Explanation: "aba" is also a valid answer.
//
//        Example 2:
//        Input: s = "cbbd"
//        Output: "bb"

public class LongestPalindromicSubstring_5 {

    public static void main(String[] args) {
        String s = "babad";
        String result = longestPalindrome(s);
        System.out.println("Result: " + result);
    }

    /**
     * Time complexity : O(n^2)
     * Space complexity : O(1)
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }

        char[] sChars = s.toCharArray();

        int start = 0;
        int end = 0;

        for (int i = 0; i < sChars.length; i++) {
            int len = Math.max(expand(sChars, i, i), expand(sChars, i, i + 1));

            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expand(char[] sChars, int i, int j) {
        while (i >= 0 && j < sChars.length && sChars[i] == sChars[j]) {
            i--;
            j++;
        }
        return j - i - 1;
    }
}
