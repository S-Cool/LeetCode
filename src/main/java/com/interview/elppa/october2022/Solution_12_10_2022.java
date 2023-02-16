package com.interview.elppa.october2022;

//        Given a list of integers (positive and negatives)
//        Find the sequence of numbers (sub array) with the largest sum.
//
//        Just return the sum
//
//        E.g.
//        [5]          			    -> 5
//        [1, 2, 3]	 			    -> 6
//        [-5, 6, -2, 20, 30]		-> 54 (sequence is the last 4 number)
//        [4, -9, 3, -2, 4, -12]	-> 5 (sequence is 3, -2, 4)
//        [-9, -3, -2, -12]		    -> -2
//        [0, 0, 0]				    -> 0
//        [-4, -9, -3, -2, -12]	    -> -2

public class Solution_12_10_2022 {

    public static int findMaxSum(int[] inputArray) {
        int max = Integer.MIN_VALUE;
        int sum;

        for (int i = 0; i < inputArray.length; i++) {
            sum = 0;
            for (int j = i; j < inputArray.length; j++) {
                sum += inputArray[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int num : nums) {
            sum += num;
            max = Math.max(sum, max);

            if (sum < 0) sum = 0;
        }
        return max;
    }

}
