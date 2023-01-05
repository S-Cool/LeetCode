package com.leetcode.string;

//        Given two strings s and t, return true if t is an anagram of s, and false otherwise.
//
//        An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using
//        all the original letters exactly once.
//
//        Example 1:
//        Input: s = "anagram", t = "nagaram"
//        Output: true
//
//        Example 2:
//        Input: s = "rat", t = "car"
//        Output: false

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram_242 {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        boolean anagramMap = isAnagramMap(s, t);
        boolean anagramSort = isAnagramSort(s, t);
        boolean anagramUnicode = isAnagramUnicode(s, t);

        System.out.println("Result: '\n' MAP - " + anagramMap
                + "'\n' SORT - " + anagramSort
                + "'\n' SORT - " + anagramUnicode);
    }


    public static boolean isAnagramMap(String s, String t) {
        final int DEFAULT_VALUE = 1;

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!mapS.containsKey(s.charAt(i))) {
                mapS.put(s.charAt(i), DEFAULT_VALUE);
            } else {
                Integer value = mapS.get(s.charAt(i));
                mapS.put(s.charAt(i), ++value);
            }

            if (!mapT.containsKey(t.charAt(i))) {
                mapT.put(t.charAt(i), DEFAULT_VALUE);
            } else {
                Integer value = mapT.get(t.charAt(i));
                mapT.put(t.charAt(i), ++value);
            }
        }
        return mapS.equals(mapT);
    }

    public static boolean isAnagramSort(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();

        Arrays.sort(ss);
        Arrays.sort(tt);

        for (int i = 0; i < ss.length; i++) {
            if (ss[i] != tt[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagramUnicode(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();

        int[] intArray = new int[128];

        for (char c : charArrayS) {
            intArray[Character.getNumericValue(c)]++;
        }

        for (char c : charArrayT) {
            intArray[Character.getNumericValue(c)]--;
        }

        for (int i : intArray) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
