package com.dr.level3.BinarySearch;
/*Implement int sqrt(int x).

Compute and return the square root of x.

If x is not a perfect square, return floor(sqrt(x))

Example :

Input : 11
Output : 3
DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY*/
public class SquareRoot {
    public long sqrt(int a) {

        int k = 1;
        // Base Cases
        if (a == 0 || a == 1)
            return a;

        // Do Binary Search for floor(sqrt(x))
        long start = 1, end = a/2, ans=0;
        while (start <= end)
        {
            long mid = (start + end) / 2;

            // If x is a perfect square
            if (mid*mid == a)
                return mid;

            // To get floor, update ans when mid*mid is smaller than x, and move closer to sqrt(x)
            if (mid*mid < a) {
                start = mid + 1;
                ans = mid;
            }
            else   // If mid*mid is greater than x
                end = mid - 1;
        }
        return ans;
    }
    
    public static void main(String args[]) {
        System.out.println(new SquareRoot().sqrt(2147483647));
    }
}
