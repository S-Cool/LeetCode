package com.interview.elppa.october2022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//        Find if any word from a given array exists in the given string input.
//
//        Implement method:
//        boolean findWordsFromString(s, words)
//        E.x.
//        "abcfoodefbartheafoobarman", [foo, bar]		-> true

public class Solution_14_10_2022 {

    /**
     * Time complexity: O(W*N*M)
     * Space complexity: O(n)
     *
     * @param initString - initial String
     * @param arrayString - array of String to find
     * @return true if at least one word from arrayString is found
     */
    public static boolean findWordsFromString(String initString, String[] arrayString) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < initString.length(); i++) {
            if (map.containsKey(initString.charAt(i))) {
                List<Integer> arrayList = map.get(initString.charAt(i));
                arrayList.add(i);
                map.put(initString.charAt(i), arrayList);
            } else {
                List<Integer> indexList = new ArrayList<>();
                indexList.add(i);
                map.put(initString.charAt(i), indexList);
            }
        }
        // Number of words - W
        for (String oneOfSearchingWord : arrayString) {
            char[] chars = oneOfSearchingWord.toCharArray();
            if (map.containsKey(chars[0])) {
                // Size of the string - N
                List<Integer> integers = map.get(chars[0]);
                for (Integer in : integers) {
                    // Max length of a word - M
                    String substring = initString.substring(in, in + oneOfSearchingWord.length());
                    if (oneOfSearchingWord.equals(substring)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
