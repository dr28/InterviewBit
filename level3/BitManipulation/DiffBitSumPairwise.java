package com.dr.level3.BitManipulation;

import java.util.ArrayList;

/*We define f(X, Y) as number of different corresponding bits in binary representation of X and Y. For example,
f(2, 7) = 2, since binary representation of 2 and 7 are 010 and 111, respectively. The first and the third bit differ,
so f(2, 7) = 2.

You are given an array of N positive integers, A1, A2 ,…, AN. Find sum of f(Ai, Aj) for all pairs (i, j) such that
1 ≤ i, j ≤ N. Return the answer modulo 109+7.

For example,

A=[1, 3, 5]

We return

f(1, 1) + f(1, 3) + f(1, 5) +
f(3, 1) + f(3, 3) + f(3, 5) +
f(5, 1) + f(5, 3) + f(5, 5) =

0 + 1 + 1 +
1 + 0 + 2 +
1 + 2 + 0 = 8*/
public class DiffBitSumPairwise {

    public int cntBits(ArrayList<Integer> A) {
        int[] count1=new int[32];
        for (int n:A) {
            for (int i=0; i<32; i++) {
                count1[i]+=n & 1;
                n=n>>1;
            }
        }
        long res=0;
        for (int i=0; i<32; i++) {
            res+=((long)count1[i]*(A.size()-count1[i]))%1000000007;
        }
        return (int)(2*res%1000000007);
    }


    public static void main(String args[])
    {
        ArrayList a = new ArrayList();
        a.add(1);
        a.add(3);
        a.add(5);

        System.out.println(new DiffBitSumPairwise().cntBits(a));
        System.out.println(new DiffBitSumPairwise().cntBits1(a));

    }
    // From Solution
    private static final long mod = 1000000007;

    public int cntBits1(ArrayList<Integer> A) {
        long ans = 0;
        long n = A.size();
        for(int i=0;i<31;++i) {
            long cnt = 0;
            for(int j=0;j<A.size();++j) {
                if((((A.get(j))>>i)&1) == 1)
                    cnt++;

            }
            ans = (ans%mod + ((cnt%mod)*((n-cnt)%mod)*2)%mod)%mod;
        }
        return (int)ans;
    }
}
