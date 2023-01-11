package com.leetcode.string;

//        Given a string s, return the number of palindromic substrings in it.
//
//        A string is a palindrome when it reads the same backward as forward.
//
//        A substring is a contiguous sequence of characters within the string.
//
//        Example 1:
//        Input: s = "abc"
//        Output: 3
//        Explanation: Three palindromic strings: "a", "b", "c".
//
//        Example 2:
//        Input: s = "aaa"
//        Output: 6
//        Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

public class PalindromicSubstrings_647 {

    public static void main(String[] args) {
        String s = "aaa";
        int result = countSubstrings(s);
        System.out.println("Result: " + result);
    }

    /**
     * Time complexity : O(n^2)
     * Space complexity : O(1)
     *
     * @param s
     * @return
     */
    public static int countSubstrings(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int count = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            count = extend(count, chars, i, i);
            count = extend(count, chars, i, i + 1);
        }

        return count;
    }

    private static int extend(int count, char[] chars, int left, int right) {
        while (left >= 0 && right <= chars.length - 1 && chars[left] == chars[right]) {
            count++;
            left--;
            right++;
        }
        return count;
    }

}
