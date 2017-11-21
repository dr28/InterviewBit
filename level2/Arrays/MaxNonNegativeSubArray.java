package com.dr.level2.Arrays;
import java.util.ArrayList;

/*Find out the maximum sub-array of non negative numbers from an array.
        The sub-array should be continuous. That is, a sub-array created by choosing the second and fourth element and skipping the third element is invalid.
        Maximum sub-array is defined in terms of the sum of the elements in the sub-array. Sub-array A is greater than sub-array B if sum(A) > sum(B).

        Example:
        A : [1, 2, 5, -7, 2, 3]
        The two sub-arrays are [1, 2, 5] [2, 3].
        The answer is [1, 2, 5] as its sum is larger than [2, 3]
        NOTE: If there is a tie, then compare with segment's length and return segment which has maximum length
        NOTE 2: If there is still a tie, then return the segment with minimum starting index*/

/*  Hint
    Loop i = 1 to Array.length :
    IF current element is positive :
    update current sum
    compare max sum with current sum
    update max sum
    update max ranges
    ELSE :
    current sum := 0
    update current ranges.
            EndLoop;
    return elements of max ranges*/
public class MaxNonNegativeSubArray {

    public static ArrayList<Integer> maxset(ArrayList<Integer> a) {
        ArrayList<Integer> maxRange = new ArrayList<Integer>();
        ArrayList<Integer> currentRange = new ArrayList<Integer>();
        long maxSum = Integer.MIN_VALUE;
        long currentSum = 0;
        for(int i = 0; i < a.size(); i++) {
            if(a.get(i) >= 0) {
                currentSum += a.get(i);
                currentRange.add(a.get(i));
                if((maxSum == currentSum && maxRange.size() < currentRange.size()) ||
                        maxSum < currentSum)  {
                    maxSum = currentSum;
                    maxRange = new ArrayList<>(currentRange);
                }
            }
            else {
                currentSum = 0;
                currentRange.clear();
            }
        }
        return maxRange;
    }
    public static void main(String[] args) {

        ArrayList A = new ArrayList();

        A.add(1);A.add(2);A.add(5);
        // A.add(4);
        A.add(-7);A.add(1);A.add(-7);A.add(2);A.add(1);A.add(4);
        //  A : [ -1, -1, -1, -1, -1 ]
        // A.add(-1);A.add(-1);A.add(-1);A.add(-1);A.add(-1);

        System.out.println(new MaxNonNegativeSubArray().maxset(A));
    }
}
