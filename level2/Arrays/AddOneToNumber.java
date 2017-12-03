package com.dr.level2.Arrays;
/*Given a non-negative number represented as an array of digits,

add 1 to the number ( increment the number represented by the digits ).

The digits are stored such that the most significant digit is at the head of the list.

Example:

If the vector has [1, 2, 3]

the returned vector should be [1, 2, 4]

as 123 + 1 = 124.

 NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer.
For example, for this problem, following are some good questions to ask :
Q : Can the input have 0’s before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
A : For the purpose of this question, YES
Q : Can the output have 0’s before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.*/

import java.util.ArrayList;

public class AddOneToNumber {

    public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
        int carry = 1;
        int num;

        int size = a.size();

        for (int i = size - 1; i >= 0; i--) {

            num = a.get(i) + carry;
            carry = 0;

            if (num == 10) {
                num = 0;
                carry = 1;
            }

            a.set(i, num);

        }

        ArrayList<Integer> res = new ArrayList<Integer>();

        if (carry == 1)
            res.add(1);

        for (int x : a) {
            if (x == 0 && res.size() == 0)
                continue;
            res.add(x);
        }

        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        /* A: [ 1, 1, 1, 3, 2, 1, 1, 2, 5, 9, 6, 5 ]
        Your function returned the following :
        1 3 2 1 1 2 5 9 6 4
       The expected returned value :
        1 1 1 3 2 1 1 2 5 9 6 6*/

        /*res.add(1);
        res.add(1);
        res.add(1);
        res.add(3);
        res.add(2);
        res.add(1);
        res.add(1);
        res.add(2);
        res.add(5);
        res.add(9);
        res.add(6);
        res.add(5);*/

        /*   A : [ 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9 ]
        Your function returned the following :
        - 9 2 2 3 3 7 2 0 3 6 8 5 4 7 7 5 8 0 8
        The expected returned value :
        1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0*/
        res.add(9);
        res.add(9);
        res.add(9);
        res.add(9);
        res.add(9);
        res.add(9);
        res.add(9);
        res.add(9);
        res.add(9);
        res.add(9);
        res.add(9);
        res.add(9);
        res.add(9);
        res.add(9);
        res.add(9);
        res.add(9);
        res.add(9);
        res.add(9);
        res.add(9);


        /* A : [ 2, 5, 6, 8, 6, 1, 2, 4, 5 ]
        Your function returned the following :
        -5 -1 1 4 3 -1 1 4 6
        The expected returned value :
        2 5 6 8 6 1 2 4 6*/

        /*res.add(2);
        res.add(5);
        res.add(6);
        res.add(8);
        res.add(6);
        res.add(1);
        res.add(2);
        res.add(4);
        res.add(5);*/

        System.out.println(new AddOneToNumber().plusOne(res));
    }
}
