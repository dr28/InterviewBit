package com.dr.level3.BinarySearch;

import java.util.ArrayList;
import java.util.List;

/*There are two sorted arrays A and B of size m and n respectively.

Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).

The overall run time complexity should be O(log (m+n)).

Sample Input

A : [1 4 5]
B : [2 3]

Sample Output

3
 NOTE: IF the number of elements in the merged array is even, then the median is the average of n / 2 th and n/2 + 1th element.
For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5 */

public class MedianOfArray {

    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {

        //if a length is greater than b switch, so that first arg is smaller than sec arg.
        if (a.size() > b.size()) {
            return findMedianSortedArrays(b, a);
        }

        int x = a.size();
        int y = b.size();

        int low = 0;
        int high = x;
        while (low <= high) {
            int partitionX = (low + high)/2;
            int partitionY = (x + y + 1)/2 - partitionX;

            //if partitionX is 0 - nothing is there on left side. Use -INF for maxLeftX
            //if partitionX is length of input - there is nothing on right side. Use +INF for minRightX
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : a.get(partitionX - 1);
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : a.get(partitionX);

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : b.get(partitionY - 1);
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : b.get(partitionY);

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                //Partitioned array at correct place
                // Get max of left elements and min of right elements to get the median for even length combined array size
                // or get max of left for odd length combined array size.
                if ((x + y) % 2 == 0) {
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                } else {
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) { //Too far on right side for partitionX. Go on left side.
                high = partitionX - 1;
            } else { //Far on left side for partitionX. Go on right side.
                low = partitionX + 1;
            }
        }

        //if input not sorted, will reach this throw.
        throw new IllegalArgumentException();
    }

    public static void main(String[] args){
        List<Integer> a = new ArrayList<Integer>();
        List<Integer> b = new ArrayList<Integer>();
        a.add(1);
        a.add(4);
        a.add(5);

        b.add(2);
        b.add(3);
        System.out.println(new MedianOfArray().findMedianSortedArrays(a,b));

    }
}
