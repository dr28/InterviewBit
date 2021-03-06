package com.dr.level2.Arrays;
import java.util.Arrays;

/*Given an integer array, find if an integer p exists in the array such that the number of integers greater than p in the array equals to p
If such an integer is found return 1 else return -1.*/

public class NobleInteger {

    public int solve(int[] A) {
        Arrays.sort(A);

        int n = A.length;
        for (int i=0; i<n-1; i++)
        {
            if (A[i] == A[i+1]) continue;

            // In case of duplicates
            if (A[i] == n-i-1)
                return 1; //A[i];
        }

        if (A[n-1] == 0) return 1; //A[n-1];

        return -1;
    }

    public static void main(String args[])
    {
        int [] arr = {10, 3, 20, 40, 2};
        //int [] arr = {-1, -9, -2, -78, 0};
        int result = new NobleInteger().solve(arr);
        if (result!=-1)
            System.out.println("The noble integer is "+ result);
        else
            System.out.println("No Noble Integer Found");
    }
}
