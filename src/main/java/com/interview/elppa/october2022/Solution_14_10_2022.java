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

    public static boolean findWordsFromString(String initString, String[] arrayString) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < initString.toCharArray().length; i++) {
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

        for (String oneOfSearchingWord : arrayString) {
            char[] chars = oneOfSearchingWord.toCharArray();
            if (map.containsKey(chars[0])) {
                List<Integer> integers = map.get(chars[0]);
                for (Integer in : integers) {
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
