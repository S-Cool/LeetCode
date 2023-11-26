package com.yandex.practicum.array;

import java.util.HashMap;
import java.util.Map;

//Problem: Maximum Unique Sequence
//        Given an array of integers nums, find the digit with the maximum unique sequence. A unique sequence is defined
//        as a subarray where no digit is repeated. Your task is to implement the findDigitWithMaxUniqueSequence method
//        that returns the digit with the maximum unique sequence.

//        Example: 1
//        int[] nums = {1, 2, 3, 2, 1, 4, 2, 5};
//        Expected Output: 4

public class MaxUniqueSequence {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 1, 4, 2, 5};
        int result = findDigitWithMaxUniqueSequence(array);
        System.out.println("Digit with max unique sequence: " + result);
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param array - array of integers nums
     * @return - the digit with the maximum unique sequence
     */
    public static int findDigitWithMaxUniqueSequence(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;

        int indexMaxPrevMeet = 0;
        for (int currentIndex = 0; currentIndex < array.length; ++currentIndex) {
            if (map.containsKey(array[currentIndex])) {
                indexMaxPrevMeet = Math.max(indexMaxPrevMeet, map.get(array[currentIndex]) + 1);
            }

            map.put(array[currentIndex], currentIndex);
            maxLength = Math.max(maxLength, currentIndex - indexMaxPrevMeet + 1);
        }
        return maxLength;
    }
}