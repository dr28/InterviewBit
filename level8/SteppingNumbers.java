package com.dr.level8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*Given N and M find all stepping numbers in range N to M

The stepping number:

A number is called as a stepping number if the adjacent digits have a difference of 1.
e.g 123 is stepping number, but 358 is not a stepping number

Example:

N = 10, M = 20
all stepping numbers are 10 , 12
Return the numbers in sorted order.*/
public class SteppingNumbers {
    public ArrayList<Integer> stepnum(int A, int B) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        int i = 0;
        int temp = 0;
        if (A == 0)
            result.add(A);
        for (int j = 1; j < 10; j++)
            queue.offer(j);

        temp = queue.poll();
        while (temp <= B) {

            if (A <= temp && temp <= B)
                result.add(temp);

            int lastDigit = temp % 10;
            if (lastDigit == 0)
                queue.offer(temp * 10 + 1);
            else if (lastDigit == 9)
                queue.offer(temp * 10 + 8);
            else {
                queue.offer(temp * 10 + lastDigit - 1);
                queue.offer(temp * 10 + lastDigit + 1);
            }

            temp = queue.poll();
        }
        return result;
    }
    public static void main(String[] args){
        int n = 10;
        int m = 20;

        System.out.println(new SteppingNumbers().stepnum(n, m));
    }
}
