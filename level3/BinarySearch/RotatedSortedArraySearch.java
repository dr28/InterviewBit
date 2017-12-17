package com.dr.level3.BinarySearch;

import java.util.ArrayList;
import java.util.List;
/*
 Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7  might become 4 5 6 7 0 1 2 ).

 You are given a target value to search. If found in the array, return its index, otherwise return -1.

 You may assume no duplicate exists in the array.

 Input : [4 5 6 7 0 1 2] and target = 4
 Output : 0
*/
/*
 NOTE : Think about the case when there are duplicates. Does your current solution work? How does the time complexity change?
 Input arr[] = {3, 4, 5, 1, 2}
 Element to Search = 1
 1) Find out pivot point and divide the array in two
 sub-arrays. (pivot = 2) i.e Index of 5
 2) Now call binary search for one of the two sub-arrays.
 (a) If element is greater than 0th element then
 search in left array
 (b) Else Search in right array
 (1 will go in else as 1 < 0th element(3))
 3) If element is found in selected sub-array then return index
 Else return -1.
 http://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 */
public class RotatedSortedArraySearch {
    public int search(final List<Integer> a, int b) {
        int left = 0;
        int right = a.size() - 1;

        while(left <= right){
            int mid = left + ((right - left) /2);

            if(a.get(mid) == b)
                return mid;
            if(a.get(left) <= a.get(mid)){
                if(a.get(left) <= b && b < a.get(mid))
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            else{
                if(a.get(mid) < b && b <= a.get(right))
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        List<Integer> a= new ArrayList<Integer>();
        a.add(4);
        a.add(5);
        a.add(6);
        a.add(7);
        a.add(10);
        a.add(1);
        a.add(2);
        a.add(3);
        System.out.println(new RotatedSortedArraySearch().search(a,7));
    }
}