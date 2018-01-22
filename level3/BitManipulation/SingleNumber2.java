package com.dr.level3.BitManipulation;

import java.util.ArrayList;
import java.util.List;

/*Given an array of integers, every element appears thrice except for one which occurs once.

Find that element which does not appear thrice.

Note: Your algorithm should have a linear runtime complexity.

Could you implement it without using extra memory?

Example :

Input : [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
Output : 4*/
public class SingleNumber2 {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int singleNumber(final List<Integer> A) {
        int a=0, b=0;
        for(int i=0;i<A.size();i++){
            int n = (a & ~A.get(i)) | (b & A.get(i));
            b = (b & ~A.get(i)) | (~a & ~b & A.get(i));
            a = n;
        }
        return a|b;
    }
    public static void main(String[] args){
        List<Integer> a = new ArrayList<Integer>();
        a.add(3);
        a.add(3);
        a.add(3);
        a.add(2);
        System.out.println(new SingleNumber2().singleNumber(a));
    }

}
