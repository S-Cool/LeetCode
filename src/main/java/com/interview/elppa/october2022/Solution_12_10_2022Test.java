package com.interview.elppa.october2022;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Solution_12_10_2022Test {

    @ParameterizedTest
    @MethodSource("provideTestData")
    void findMaxSum(int[] array, int expected) {

        int actual = Solution_12_10_2022.findMaxSum(array);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void maxSubArray(int[] array, int expected) {

        int actual = Solution_12_10_2022.maxSubArray(array);

        assertEquals(expected, actual);
    }

//        E.g.
//        [5]          			    -> 5
//        [1, 2, 3]	 			    -> 6
//        [-5, 6, -2, 20, 30]		-> 54 (sequence is the last 4 number)
//        [4, -9, 3, -2, 4, -12]	-> 5 (sequence is 3, -2, 4)
//        [-9, -3, -2, -12]		    -> -2
//        [0, 0, 0]				    -> 0
//        [-4, -9, -3, -2, -12]	    -> -2
    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(new int[]{5}, 5),
                Arguments.of(new int[]{1, 2, 3}, 6),
                Arguments.of(new int[]{-5, 6, -2, 20, 30}, 54),
                Arguments.of(new int[]{4, -9, 3, -2, 4, -12}, 5),
                Arguments.of(new int[]{-9, -3, -2, -12}, -2),
                Arguments.of(new int[]{0, 0, 0}, 0),
                Arguments.of(new int[]{-4, -9, -3, -2, -12}, -2)
        );
    }
}