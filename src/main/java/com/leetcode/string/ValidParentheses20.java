package com.leetcode.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses20 {

    public static void main(String[] args) {
        String str = "({[]})";
        boolean valid = isValid(str);
        System.out.println("Result: " + valid);
    }

    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        if (chars.length % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (Character character : chars) {
            if (character.equals('(') || character.equals('{') || character.equals('[')) {
                stack.push(character);
            }
            if (character.equals(')') || character.equals('}') || character.equals(']')) {
                if (stack.empty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (pop.equals('[') && !character.equals(']')) {
                    return false;
                }
                if (pop.equals('{') && !character.equals('}')) {
                    return false;
                }
                if (pop.equals('(') && !character.equals(')')) {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public static boolean isValidMap(String s) {
        Stack<Character> stack = new Stack();
        Map<Character, Character> map = new HashMap<>();

        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(map.get(c));
            } else {
                if (stack.empty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
