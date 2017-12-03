package com.dr.level2.Arrays;

import java.util.ArrayList;
import java.util.List;
/*Given a matrix of m * n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example:

Given the following matrix:

[
    [ 1, 2, 3 ],
    [ 4, 5, 6 ],
    [ 7, 8, 9 ]
]
You should return

[1, 2, 3, 6, 9, 8, 7, 4, 5]*/
public class SpiralOrderMatrix1 {
    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int top = 0;
        int down = a.size()-1;
        int left = 0;
        int right = a.get(0).size()-1;
        int direction = 0; //0 - left to right, 1 - top to bottom, 2 - right ti left and 3 - bottom to top

        while(top <= down && left <= right) {

            if (direction == 0) {
                for (int i = left; i <= right; i++)
                    result.add(a.get(top).get(i));

                direction++;
                top++;

            } else if (direction == 1) {

                for (int i = top; i <= down; i++)
                    result.add(a.get(i).get(right));

                direction++;
                right--;

            } else if (direction == 2) {

                for (int i = right; i >= left; i--)
                    result.add(a.get(down).get(i));

                direction++;
                down--;

            } else if (direction == 3) {

                for (int i = down; i >= top; i--)
                    result.add(a.get(i).get(left));

                direction = 0;
                left++;

            }
        }
        return result;
    }

    public static void main(String[] args){

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
        // matrix :
        //[
        //  [1, 2, 3]
        //  [4, 5, 6]
        //  [7, 8, 9]
        //]
        ArrayList temp = new ArrayList<Integer>();
        temp.add(1);
        temp.add(2);
        temp.add(3);
        matrix.add(temp);

        temp = new ArrayList<Integer>();
        temp.add(4);
        temp.add(5);
        temp.add(6);
        matrix.add(temp);

        temp = new ArrayList<Integer>();
        temp.add(7);
        temp.add(8);
        temp.add(9);
        matrix.add(temp);

        System.out.print(new SpiralOrderMatrix1().spiralOrder(matrix));

    }
}
