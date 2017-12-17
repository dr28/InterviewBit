package com.dr.level3.BinarySearch;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 *
 Your algorithm’s runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 Example:

 Given [5, 7, 7, 8, 8, 10]

 and target value 8,

 return [3, 4].

 http://www.lifeincode.net/programming/leetcode-search-for-a-range-java/
 */
public class SearchRange {

    public ArrayList<Integer> searchRange(final List<Integer> a, int b) {

        int first = searchFirstLastOccurence(a, b, true);
        int last = searchFirstLastOccurence(a, b, false);
        ArrayList result = new ArrayList();
        result.add(first);
        result.add(last);

        return result;
    }

    int searchFirstLastOccurence(List<Integer> A, int B, boolean first) {
        int start = 0;
        int end = A.size()-1;
        int result = -1;

        while(start<=end) {
            int mid = start +  (end - start)/2;

            if(B == A.get(mid)){
                result = mid;
                if(first)
                    end = mid - 1;
                else
                    start = mid + 1;

            }
            else if (B < A.get(mid))
                end = mid - 1;
            else
                start = mid + 1;
        }
        return result;
    }
    
    public static void main(String[] args){
        List<Integer> A = new ArrayList<Integer>();
        A.add(5);
        A.add(7);
        A.add(7);
        A.add(8);
        A.add(8);
        A.add(10);

        int B = 1;
        System.out.print(new SearchRange().searchRange(A, B));
    }
}
