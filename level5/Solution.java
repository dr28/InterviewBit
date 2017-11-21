package com.dr.level5;

import java.util.HashSet;
/*Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Example:
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.*/
public class Solution {

    public int longestConsecutive(final int[] A) {
        HashSet<Integer> set = new HashSet<Integer>();
        int maxLength = 0;

        for (int i=0; i < A.length; ++i)
            set.add(A[i]);

        for (int i=0; i < A.length; ++i) {

            int num = A[i];
            if (!set.contains(num - 1)) {

                int j = num;
                while (set.contains(j))
                    j++;

                if (maxLength < j - num)
                    maxLength = j - num;

            }
        }
        return maxLength;
    }

    public static void main(String[] args) {

        int[] a = {100, 4, 200, 1, 3, 2};
        System.out.println("result == "+new Solution().longestConsecutive(a));
    }
}
