package com.dr.level3.BitManipulation;

import java.util.ArrayList;
import java.util.List;

/*Given an array of integers, every element appears twice except for one. Find that single one.

Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example :

Input : [1 2 2 3 1]
Output : 3*/
public class SingleNumber {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int singleNumber(final List<Integer> A) {
        int result = A.get(0);
        for(int i = 1; i < A.size(); i++){
            result = result ^ A.get(i);
            System.out.println(result);

        }
        return result;
    }
    public static void main(String[] args){
        List<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(3);
        a.add(2);
        a.add(2);
        a.add(1);

        System.out.println(new SingleNumber().singleNumber(a));
    }
}
