package com.dr.level2.Arrays;
import java.util.ArrayList;
import java.util.List;
/*Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example:

Given the array [-2,1,-3,4,-1,2,1,-5,4],

the contiguous subarray [4,-1,2,1] has the largest sum = 6.

For this problem, return the maximum sum.*/
public class MaxSumContiguousSubarray {
    // DO NOT MODFIY THE LIST.
    public int maxSubArray(final List<Integer> a) {
        int len = a.size();
        if (len == 0) {
            return 0;
        }
        int result = a.get(0);
        int contiguous = result;
        for (int i = 1; i < len; i++) {
            int number = a.get(i);
            if (contiguous < 0) {
                contiguous = number;
            } else {
                contiguous += number;
            }
            result = Math.max(result, contiguous);
        }
        return result;

    }
    public static void main(String[] args) {

        List A = new ArrayList();
        //[-2,1,-3,4,-1,2,1,-5,4],
        A.add(-2);A.add(1);A.add(-3);A.add(4);A.add(-1);A.add(2);A.add(1);A.add(-5);A.add(4);

        System.out.println(new MaxSumContiguousSubarray().maxSubArray(A));
    }
}
