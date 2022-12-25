package com.interview.elppa.october2022;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Solution_14_10_2022Test {

    @ParameterizedTest
    @MethodSource("provideTestData")
    void findWordsFromStringTest(String str, String[] array, boolean expected) {


        boolean actual = Solution_14_10_2022.findWordsFromString(str,array);

        assertEquals(expected, actual);
    }

//        E.g.
//        "abcfoodefbartheafoobarman", {"foo", "bar"}           -> true
//        "abcfodefbtheafbman", {"foo", "bar"}	 			    -> false
    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of("abcfoodefbartheafoobarman", new String[]{"foo", "bar"}, true),
                Arguments.of("abcfodefbtheafbman", new String[]{"foo", "bar"}, false)
        );
    }

}