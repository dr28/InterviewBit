package com.dr.level5.Hashing;
import java.util.ArrayList;
import java.util.HashSet;

/*For Given Number N find if its COLORFUL number or not

Return 0/1

COLORFUL number:

A number can be broken into different contiguous sub-subsequence parts.
Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different
Example:

N = 23
2 3 23
2 -> 2
3 -> 3
23 -> 6
this number is a COLORFUL number since product of every digit of a sub-sequence are different.

Output : 1*/
public class ColorfulNumber {
    public int colorful(int a) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        HashSet<Integer> set= new HashSet<Integer>();

        while(a > 0){
            int remainder = a % 10;
            //System.out.println("remainder : "+ remainder);
            list.add(remainder);
            a = a/10;
            //System.out.println("a : "+ a);

        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                int prod = 1;
                for (int k = i; k <= j; k++) {
                    prod *= list.get(k);
                }

                if (set.contains(prod))
                    return 0;

                set.add(prod);
            }
        }

        return 1;
    }

    public static void main(String[] args) {

        int a = 22;
        System.out.println("result == "+new ColorfulNumber().colorful(a));
    }
}
