package com.leetcode.string;

//        Given two strings needle and haystack, return the index of the first occurrence of needle in
//        haystack, or -1 if needle is not part of haystack.
//
//        Example 1:
//        Input: haystack = "sadbutsad", needle = "sad"
//        Output: 0
//        Explanation: "sad" occurs at index 0 and 6.
//        The first occurrence is at index 0, so we return 0.
//
//        Example 2:
//        Input: haystack = "leetcode", needle = "leeto"
//        Output: -1
//        Explanation: "leeto" did not occur in "leetcode", so we return -1.

public class FindTheIndexOfTheFirstOccurrenceInaString_28 {

    public static void main(String[] args) {
        String haystack = "sadbutsad", needle = "sad";
        int i = strStr(haystack, needle);
        System.out.println("Result: " + i);
    }

    public static int strStr(String haystack, String needle) {
        int left = 0;
        int right = 1;

        int[] pattern = new int[needle.length()];

        while (right < needle.length()) {
            if (needle.charAt(left) == needle.charAt(right)) {
                left += 1;
                pattern[right] = left;
                right += 1;
            } else {
                if (left == 0) {
                    pattern[right] = 0;
                    right += 1;
                } else {
                    left = pattern[left - 1];
                }
            }
        }

        int haystackPointer = 0;
        int needlePointer = 0;

        while (haystackPointer < haystack.length()) {
            if (haystack.charAt(haystackPointer) == needle.charAt(needlePointer)) {

                needlePointer += 1;
                haystackPointer += 1;

                if (needlePointer == needle.length()) {
                    return haystackPointer - needle.length();
                }
            } else {
                if (needlePointer == 0) {
                    haystackPointer += 1;
                } else {
                    needlePointer = pattern[needlePointer - 1];
                }
            }
        }

        return -1;
    }
}
