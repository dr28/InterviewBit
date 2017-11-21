package com.dr.level2.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*Given a list of non negative integers, arrange them such that they form the largest number.
        For example:
        Given [3, 30, 34, 5, 9], the largest formed number is 9534330.
        Note: The result may be very large, so you need to return a string instead of an integer.*/

public class LargestNumber implements Comparator<String> {
    public String largestNumber(final List<Integer> a) {
        List<String> B = new ArrayList<String>();
        for (Integer number : a) {
            String x = number.toString();
            B.add(x);
        }
        Collections.sort(B, this);
        StringBuilder result = new StringBuilder();

        for (int i = B.size() - 1; i >= 0; i--)
            result.append(B.get(i));
        
        return result.toString();
    }

    @Override
    public int compare(String a, String b) {
        String num1 = a + b;
        String num2 = b + a;
        return (num1.compareTo(num2));
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<Integer>();
        A.add(3);A.add(30);A.add(34);A.add(5);A.add(9);

        String result = new LargestNumber().largestNumber(A);
        System.out.println(result);
    }
}
