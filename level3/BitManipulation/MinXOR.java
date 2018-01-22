package com.dr.level3.BitManipulation;

import java.util.ArrayList;
import java.util.Collections;

/*Given an array of N integers, find the pair of integers in the array which have minimum XOR value. Report the minimum
XOR value.

Examples :
Input
0 2 5 7
Output
2 (0 XOR 2)
Input
0 4 7 9
Output
3 (4 XOR 7)

Constraints:
2 <= N <= 100 000
0 <= A[i] <= 1 000 000 000*/

public class MinXOR {
    public int findMinXor(ArrayList<Integer> A) {
        int minXOR = Integer.MAX_VALUE;

        Collections.sort(A);

        for (int i=0; i < A.size()-1; i++)
            // update minimum xor value if required
            minXOR = Math.min(minXOR, A.get(i) ^ A.get(i+1));

        return minXOR;
    }

    public static void main(String args[]) {
        ArrayList a = new ArrayList();
        a.add(15);
        a.add(5);
        a.add(1);
        a.add(10);
        a.add(2);

        System.out.println(new MinXOR().findMinXor(a));
    }
}
