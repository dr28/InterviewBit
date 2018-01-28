package com.dr.level8;

import java.util.ArrayList;
/*Given three prime number(p1, p2, p3) and an integer k. Find the first(smallest) k integers which have only p1, p2, p3
or a combination of them as their prime factors.

Example:

Input :
Prime numbers : [2,3,5]
k : 5

If primes are given as p1=2, p2=3 and p3=5 and k is given as 5, then the sequence of first 5 integers will be:

Output:
{2,3,4,5,6}

Explanation :
4 = p1 * p1 ( 2 * 2 )
6 = p1 * p2 ( 2 * 3 )

Note: The sequence should be sorted in ascending order
*/
public class SmallestSeqWithPrimeNo {
    public ArrayList<Integer> solve(int p1,int p2,int p3,int k) {
        ArrayList<Integer> finalAnswer = new ArrayList<Integer>();
        int[] nextBestNumbers = new int[3];
        int[] currIndex = new int[3];
        int[] prime = new int[3];

        nextBestNumbers[0] = prime[0] = p1;
        nextBestNumbers[1] = prime[1] = p2;
        nextBestNumbers[2] = prime[2] = p3;

        currIndex[0] = currIndex[1] = currIndex[2] = -1;

        for(int j=1;j<=k;j++) {
            int nextNumber = Math.min(nextBestNumbers[0],Math.min(nextBestNumbers[1],nextBestNumbers[2]));
            finalAnswer.add(nextNumber);

            for(int i=0;i<3;i++) {
                if(nextNumber==nextBestNumbers[i]) {
                    currIndex[i]++;
                    nextBestNumbers[i] = finalAnswer.get(currIndex[i])*prime[i];
                }
            }
        }

        return finalAnswer;
    }
    public static void main(String[] args) {
        System.out.println(new SmallestSeqWithPrimeNo().solve(2,3,5,5));
    }
}
