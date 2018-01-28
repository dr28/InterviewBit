package com.dr.level8;

import java.util.*;
/*You are given an integer N. You have to find smallest multiple of N which consists of digits 0 and 1 only. Since this
 multiple could be large, return it in form of a string.

Note:

Returned string should not contain leading zeroes.
For example,

For N = 55, 110 is smallest multiple consisting of digits 0 and 1.
For N = 2, 10 is the answer.
*/
public class SmallestMultipleWith0And1 {
    boolean isBinaryNum(int N) {
        while (N > 0) {
            int digit = N % 10;
            if (digit != 0 && digit != 1)
                return false;
            N /= 10;
        }
        return true;
    }

    // Method return t % N, where t is stored as a string
    int mods(String t, int N) {
        int r = 0;
        for (int i = 0; i < t.length(); i++) {
            r = r * 10 + (t.charAt(i) - '0');
            r %= N;
        }
        return r;
    }

    // method returns smallest multiple which has binary digits
    String getMinimumMultipleOfBinaryDigit(int N) {
        Queue<String> q = new LinkedList<String>();
        Set<Integer> visit = new HashSet<Integer>();

        String t = "1";
        q.add(t);

        while (!q.isEmpty()) {
            t = q.poll();

            int rem = mods(t, N);

            if (rem == 0)
                return t;

            // If remainder is not in set, push t0 and t1
            else if(!visit.contains(rem)) {
                visit.add(rem);
                q.add(t + "0");
                q.add(t + "1");
            }
        }
        return "";

    }
    public static void main(String[] args) {
        System.out.println(new SmallestMultipleWith0And1().getMinimumMultipleOfBinaryDigit(55));
    }

    //from sol
    public String multiple(int A) {
        if (A == 0)
            return "0";
        if (A == 1)
            return "1";

        long x = A;

        Queue<Long> q = new ArrayDeque<>();
        q.offer(1L);
        long[] parent = new long[A + 1];
        Arrays.fill(parent, -1L);
        boolean[] added = new boolean[A + 1];

        while(parent[0] == -1 && !q.isEmpty()) {
            long v = q.poll();

            long next = (v * 10) % x;
            long next2 = (next + 1) % x;

            if (next != 1 && parent[(int)next] == -1L) {
                parent[(int)next] = v;
                q.offer(next);
            }
            if (next2 != 1 && parent[(int)next2] == -1L) {
                parent[(int)next2] = v;
                added[(int)next2] = true;
                q.offer(next2);
            }
        }

        StringBuilder sb = new StringBuilder();
        long cur = 0;
        while(cur != 1L) {
            sb.append((added[(int)cur] ? '1' : '0'));
            cur = parent[(int)cur];
        }
        sb.append('1');
        return sb.reverse().toString();
    }
}
