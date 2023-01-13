package com.leetcode.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//        Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network
//        and is decoded back to the original list of strings.
//
//        Example 1:
//        Input: strs = ["Hello","World"]
//        Output: ["Hello","World"]
//
//        Example 2:
//        Input: strs = [""]
//        Output: [""]

public class EncodeAndDecodeStrings_271 {

    public static final Character DELIMITER = '#';

    public static void main(String[] args) {
        List<String> input = List.of("Hello", "World", "5#%^1234567890", "14#qwerty");
        String encode = encode(input);
        List<String> decode = decode(encode);
        System.out.println("Result: " + decode);
    }

    public static String encode(List<String> strs) {
        if (strs.isEmpty()) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        for (String str : strs) {
            builder.append(str.length());
            builder.append(DELIMITER);
            builder.append(str);
        }
        return builder.toString();
    }

    public static List<String> decode(String s) {
        if (s.isEmpty()) {
            return Collections.emptyList();
        }

        List<String> result = new ArrayList<>();

        char[] chars = s.toCharArray();
        int pointer = 0;
        while (pointer < s.length()) {
            StringBuilder head = new StringBuilder();
            while (chars[pointer] != DELIMITER) {
                head.append(chars[pointer++]);
            }

            if (chars[pointer] == DELIMITER) {
                int numOfChar = Integer.parseInt(head.toString());
                String substring = s.substring(pointer + 1, pointer + numOfChar + 1);
                result.add(substring);
                pointer += numOfChar + 1;
            }
        }
        return result;
    }
}
