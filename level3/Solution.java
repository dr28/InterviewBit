package com.dr.level3;
/*Given an array of non negative integers A, and a range (B, C),
find the number of continuous subsequences in the array which have sum S in the range [B, C] or B <= S <= C

Continuous subsequence is defined as all the numbers A[i], A[i + 1], .... A[j]
where 0 <= i <= j < size(A)

Example :
A : [10, 5, 1, 0, 2]
(B, C) : (6, 8)
ans = 3
as [5, 1], [5, 1, 0], [5, 1, 0, 2] are the only 3 continuous subsequence with their sum in the range [6, 8]

NOTE : The answer is guranteed to fit in a 32 bit signed integer. */
public class Solution {

    public int numRange(int[] A, int B, int C) {
        int counter = 0;
        int result = 0;

        for(int i =0; i< A.length; i++) {
            result = A[i];
            if( result >= B && result <= C)
                counter++;

            int k = i+1;

            while(k < A.length) {
                result = result+ A[k];
                if( result >= B && result <= C)
                    counter++;
                else if( result >C)
                    break;
                k++;
            }
        }
        return counter;

    }

    public static void main(String [ ] arg) {
        Solution sol = new Solution();

        int []  A = {10, 5, 1, 0, 2};
        int b = 6;
        int c =  8;
        System.out.print(sol.numRange(A, b, c));
    }
}
