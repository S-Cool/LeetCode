package com.leetcode.heap;

//        Given an integer array nums and an integer k, return the k most frequent elements. You may return
//        the answer in any order.
//
//        Example 1:
//        Input: nums = [1,1,1,2,2,3], k = 2
//        Output: [1,2]
//
//        Example 2:
//        Input: nums = [1], k = 1
//        Output: [1]

import java.util.*;

public class TopKFrequentElements_347 {

    public static void main(String[] args) {
        int[] list = {1, 1, 1, 2, 2, 3};
        int[] ints = topKFrequent(list, 2);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int frequency = entry.getValue();
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(entry.getKey());
        }

        int[] res = new int[k];
        for (int pos = bucket.length - 1; pos >= 0 && k > 0; pos--) {
            if (bucket[pos] != null) {
                for (int value : bucket[pos]) {
                    res[k - 1] = value;
                    k--;
                }
            }
        }

        return res;
    }
}
