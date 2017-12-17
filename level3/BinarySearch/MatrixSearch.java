package com.dr.level3.BinarySearch;

import java.util.ArrayList;

/*
 * Write an efficient algorithm that searches for a value in an m x n matrix.
This matrix has the following properties:
> 1. Integers in each row are sorted from left to right.
>
> 2. The first integer of each row is greater than or equal to the last integer of the previous row.
Example:
Consider the following matrix:
[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return 1 ( 1 corresponds to true )
Return 0 / 1 ( 0 for false, 1 for true ) for this problem
*/
public class MatrixSearch {
    public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {

        if(a == null || a.size() == 0 || a.get(0).size() == 0)
            return 0;

        int m = a.size();
        int n = a.get(0).size();

        int start = 0;
        int end = (n - 1);

        for(int i=0; i<m; i++) {

            if (a.get(i).get(end) == b) {
                return 1;
            } else if (a.get(i).get(end) > b) {

                while (start<=end) {
                    int mid = start + (end - start)/2;

                    if(a.get(i).get(mid) == b){
                        return 1;
                    }
                    else if(a.get(i).get(mid) < b) {
                        start = mid + 1;
                    }
                    else if(a.get(i).get(mid) > b) {
                        end = mid - 1;
                    }
                }
                return 0;
            }
        }

        return 0;
    }

    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
       /* A.add(new ArrayList<Integer>());
        A.get(0).add(1);  A.get(0).add(3);  A.get(0).add(5);  A.get(0).add(7);
        A.add(new ArrayList<Integer>());
        A.get(1).add(10);  A.get(1).add(11);  A.get(1).add(16);  A.get(1).add(20);
        A.add(new ArrayList<Integer>());
        A.get(2).add(23);  A.get(2).add(30);  A.get(2).add(34);  A.get(2).add(50);*/

        A.add(new ArrayList<Integer>());
        A.get(0).add(3);
        A.add(new ArrayList<Integer>());
        A.get(1).add(29);
        A.add(new ArrayList<Integer>());
        A.get(2).add(36);
        A.add(new ArrayList<Integer>());
        A.get(3).add(63);
        A.add(new ArrayList<Integer>());
        A.get(4).add(67);
        A.add(new ArrayList<Integer>());
        A.get(5).add(72);
        A.add(new ArrayList<Integer>());
        A.get(6).add(74);
        A.add(new ArrayList<Integer>());
        A.get(7).add(78);
        A.add(new ArrayList<Integer>());
        A.get(8).add(85);

        System.out.println(A);
        
        int B = 29;
        System.out.println(new MatrixSearch().searchMatrix(A,B));
    }

    // from solution
    public int searchMatrix1(ArrayList<ArrayList<Integer>> a, int b) {
        if(a == null || a.size() == 0 || a.get(0).size() == 0) {
            return 0;
        }
        int m = a.size();
        int n = a.get(0).size();
        int start = 0;
        int mid, x, y;
        int end = m * n - 1;
        while(start <= end) {
            mid = (start + end)/2;
            x = mid/n;
            y = mid % n;
            if(a.get(x).get(y) == b) {
                return 1;
            } else if(a.get(x).get(y) < b) {
                start=mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return 0;
    }
}
