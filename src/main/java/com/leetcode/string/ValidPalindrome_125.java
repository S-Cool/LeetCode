package com.leetcode.string;

//        A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and
//        removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric
//        characters include letters and numbers.
//
//        Given a string s, return true if it is a palindrome, or false otherwise.
//
//        Example 1:
//        Input: s = "A man, a plan, a canal: Panama"
//        Output: true
//        Explanation: "amanaplanacanalpanama" is a palindrome.
//
//        Example 2:
//        Input: s = "race a car"
//        Output: false
//        Explanation: "raceacar" is not a palindrome.
//
//        Example 3:
//        Input: s = " "
//        Output: true
//        Explanation: s is an empty string "" after removing non-alphanumeric characters.
//        Since an empty string reads the same forward and backward, it is a palindrome.

public class ValidPalindrome_125 {

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        boolean result = isPalindrome(str);
        System.out.println("Result: " + result);
    }

    public static boolean isPalindrome(String s) {
        String str = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        if (str.length() == 1) {
            return true;
        }

        for (int i = 0; i < str.length() / 2; i++) {
            char leftChar = str.charAt(i);
            int rightIndex = str.length() - i - 1;
            char rightChar = str.charAt(rightIndex);
            if (leftChar != rightChar) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindromeShift(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            while (start <= end && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            while (start <= end && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }
            if (start <= end && Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
