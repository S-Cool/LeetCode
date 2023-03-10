package com.leetcode.dynamic;

import java.util.Arrays;
import java.util.List;

//        Given a string s and a dictionary of strings wordDict, return true if s can be segmented into
//        a space-separated sequence of one or more dictionary words.
//
//        Note that the same word in the dictionary may be reused multiple times in the segmentation.
//
//        Example 1:
//        Input: s = "leetcode", wordDict = ["leet","code"]
//        Output: true
//        Explanation: Return true because "leetcode" can be segmented as "leet code".
//
//        Example 2:
//        Input: s = "applepenapple", wordDict = ["apple","pen"]
//        Output: true
//        Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
//        Note that you are allowed to reuse a dictionary word.
//
//        Example 3:
//        Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
//        Output: false

public class WordBreak_139 {

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        boolean result = wordBreak(s, wordDict);
        System.out.println("Result: " + result);
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;

        int maxLength = 0;
        for (String word : wordDict) {
            maxLength = Math.max(maxLength, word.length());
        }

        for (int i = 0; i <= length; i++) {
            for (int j = 0; i > j; j++) {

                if (i - j > maxLength) {
                    continue;
                }

                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[length];
    }
}
