package com.dr.level3.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given a N cross M matrix in which each row is sorted, find the overall median of the matrix. Assume N*M is odd.

For example,

Matrix=
[1, 3, 5]
[2, 6, 9]
[3, 6, 9]

A = [1, 2, 3, 3, 5, 6, 6, 9, 9]

Median is 5. So, we return 5.
Note: No extra memory is allowed.
 */
public class MatrixMedian {
    public int findMedian(ArrayList<ArrayList<Integer>> A) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int row = A.size();
        int col = A.get(0).size();

        for(int i=0; i<row ; i++)
        {

            // Finding the minimum element
            if(A.get(i).get(0) < min)
                min = A.get(i).get(0);

            // Finding the maximum element
            if(A.get(i).get(col-1) > max)
                max = A.get(i).get(col-1);
        }

        int desired = (row * col + 1) / 2;

        while(min < max)
        {
            int mid = min + (max - min) / 2;
            int place = 0;
            int count = 0;

            // Find count of elements smaller than mid
            for(int i = 0; i < row; ++i)
            {

                count = Arrays.binarySearch(A.get(i).toArray(), mid);

                // If element is not found in the array the
                // binarySearch() method returns
                // (-(insertion_point) - 1). So once we know
                // the insertion point we can find elements
                // Smaller than the searched element by the
                // following calculation
                if(count < 0)
                    count = Math.abs(count) - 1;

                    // If element is found in the array it returns
                    // the index(any index in case of duplicate). So we go to last
                    // index of element which will give  the number of
                    // elements smaller than the number including
                    // the searched element.
                else
                {
                    while(count < A.get(i).size() && A.get(i).get(count) == mid)
                        count += 1;
                }

                place = place + count;
            }

            if (place < desired)
                min = mid + 1;
            else
                max = mid;
        }
        return min;
    }

    public static void main(String[] args){

        ArrayList A = new ArrayList();
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(1);
        temp.add(3);
        temp.add(5);
        A.add(temp);
        temp = new ArrayList<Integer>();
        temp.add(2);
        temp.add(6);
        temp.add(9);
        A.add(temp);
        temp = new ArrayList<Integer>();
        temp.add(3);
        temp.add(6);
        temp.add(9);
        A.add(temp);

        System.out.println(new MatrixMedian().findMedian(A));

    }

    // Solution
    public int findMedian1(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        if(n == 0) return -1;
        int m = A.get(0).size();
        int lo = 0;
        int hi = Integer.MAX_VALUE;
        int x = 1;
        while(lo <= hi) {
            int mid = (lo+hi)/2;
            if(isLessThanHalf(A, mid)) {
                lo = mid+1;
            } else {
                x = mid;
                hi = mid-1;
            }
        }
        return x;
    }
    boolean isLessThanHalf(ArrayList<ArrayList<Integer>> a, int num) {
        int N = a.size();
        int M = a.get(0).size();
        int count = 0;

        for(int i = 0; i < N; i++) {
            count += getCount(a.get(i), num);
            //   System.out.println(count);
        }
        // System.out.println();
        return count < (N*M)/2 + 1;
    }
    int getCount(ArrayList<Integer> a, int n) {
        int lo = 0;
        int hi = a.size()-1;
        while(lo <= hi) {
            int mid = (lo+hi)/2;
            if(a.get(mid) > n) hi = mid-1;
            else lo = mid+1;
        }
        return lo;
    }
}
