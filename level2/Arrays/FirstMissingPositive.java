package com.dr.level2.Arrays;
import java.util.ArrayList;
/*Given an unsorted integer array, find the first missing positive integer.

Example:
Given [1,2,0] return 3,
[3,4,-1,1] return 2,
[-8, -7, -6] returns 1
Your algorithm should run in O(n) time and use constant space.*/
public class FirstMissingPositive {
    public int firstMissingPositive(ArrayList<Integer> a) {
        int i = 0;
        int n = a.size();
        while(i < n){
            if(a.get(i) != i+1 &&
                    a.get(i) >= 1 &&
                    a.get(i) <= n &&
                    a.get(a.get(i)-1) != a.get(i)){
                int temp = a.get(a.get(i)-1);
                a.set(a.get(i)-1, a.get(i));
                a.set(i, temp);
            }
            else
                i++;
        }
        i = 0;
        for (i = 0; i < a.size(); i++)
            if (a.get(i) != i + 1)
                return i + 1;

        return a.size() + 1;
    }

    public int firstMissingPositive(int[] A) {
        int i = 0;
        while (i < A.length) {
            if (A[i] != i + 1 && A[i] >= 1 && A[i] <= A.length && A[A[i] - 1] != A[i]) {
                int tmp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = tmp;
            } else
                i++;
        }
        for (i = 0; i < A.length; i++)
            if (A[i] != i + 1)
                return i + 1;

        return A.length + 1;
    }

    public static void main(String[] args){
        //int[] B = {3,4,-1,1};
        //System.out.println(new FirstMissingPositive().firstMissingPositive(B));
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(3);A.add(4);A.add(-1);A.add(1);

        System.out.println(new FirstMissingPositive().firstMissingPositive(A));
    }
}
