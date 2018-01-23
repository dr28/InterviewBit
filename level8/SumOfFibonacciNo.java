package com.dr.level8.Graphs;

import java.util.ArrayList;
/*How many minimum numbers from fibonacci series are required such that sum of numbers should be equal to a given Number
N?
Note : repetition of number is allowed.

Example:

N = 4
Fibonacci numbers : 1 1 2 3 5 .... so on
here 2 + 2 = 4
so minimum numbers will be 2 */
public class SumOfFibonacciNo {
    int[] fib;
    public int fibsum(int A) {

        if(A <= 2)
            return 1;

        int a = 1;
        int b = 1;
        int c = 1;

        ArrayList<Integer> fibNums = new ArrayList<Integer>();
        fibNums.add(1);
        fibNums.add(1);
        while(true){
            c = a + b;
            if(c <= A)
                fibNums.add(c);
            else
                break;

            a = b;
            b = c;
        }

        int count = 0;
        int num = A;
        int index = fibNums.size() - 1;
        while(num > 0) {
            int fib = fibNums.get(index);

            if(num >= fib) {

                count += (num/fib);
                num %= fib;

            }
            index--;
        }
        return count;
    }

    public static void main(String[] args){
        int a = 10;
        System.out.println(new SumOfFibonacciNo().fibsum(a));

    }
}
