package com.dr.level7.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;
/*
Bitonic
Given an array of integers, find the length of longest subsequence which is first increasing then decreasing.

**Example: **

For the given array [1 11 2 10 4 5 2 1]

Longest subsequence is [1 2 10 4 2 1]

Return value 6
*/
public class LengthOfLongestSubsequence {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int longestSubsequenceLength(final List<Integer> A) {

        if (A.isEmpty()) return 0;
        List lis = new ArrayList();
        List lds = new ArrayList();
        for (int i = 0; i < A.size(); i++) {
            lis.add(1);
            lds.add(1);

        }
        /* Compute LIS values from left to right */
        for (int i = 1; i < A.size(); i++)
            for (int j = 0; j < i; j++)
                if (A.get(i) > A.get(j) && (Integer)lis.get(i) < (Integer)lis.get(j) + 1)
                    lis.add(i, (Integer)lis.get(j) + 1);

        /* Compute LDS values from right to left */
        for (int i = A.size()-2; i >= 0; i--)
            for (int j = A.size()-1; j > i; j--)
                if (A.get(i) > A.get(j) && (Integer)lds.get(i) < (Integer)lds.get(j) + 1)
                    lds.add(i, (Integer)lds.get(j) + 1);


        /* Return the maximum value of lis[i] + lds[i] - 1*/
        int max = (Integer)lis.get(0) + (Integer)lds.get(0) - 1;
        for (int i = 1; i < A.size(); i++)
            if ((Integer)lis.get(i) + (Integer)lds.get(i) - 1 > max)
                max = (Integer)lis.get(i) + (Integer)lds.get(i) - 1;

        return max;

    }


    public static void main (String[] args) {

        ArrayList a = new ArrayList();
       /* a.add(0);  a.add(8);
        a.add(4);  a.add(12);
        a.add(2);  a.add(10);
        a.add(6);  a.add(14);
        a.add(1);  a.add(9);
        a.add(5);*/
        
        a.add(1);  a.add(3);
        a.add(5);  a.add(6);
        a.add(4);  a.add(8);
        a.add(4);  a.add(3);
        a.add(2);  a.add(1);
        a.add(9);

        System.out.println("Length of longest subsequesnce is "+ new LengthOfLongestSubsequence().longestSubsequenceLength(a));

    }
    // From Solution
    public int longestSubsequenceLength1(final List<Integer> A) {
        if(A==null || A.size()==0)
            return 0;
        int n=A.size();
        ArrayList<Integer> inc=new ArrayList<Integer>(),dec=new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            inc.add(1);
            for(int j=0;j<i;j++){
                if(A.get(j)<A.get(i) && inc.get(j)+1>inc.get(i))
                    inc.set(i,inc.get(j)+1);
            }
        }
        for(int i=0;i<n;i++)
            dec.add(1);
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(A.get(i)>A.get(j) && dec.get(j)+1>dec.get(i))
                    dec.set(i,dec.get(j)+1);
            }
        }
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,inc.get(i)+dec.get(i)-1);
            //System.out.println(i+" "+max );
        }
        return max;
    }
}
