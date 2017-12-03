package com.dr.level2.Arrays;
import java.util.ArrayList;
import java.util.List;
/*Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].

If there is no solution possible, return -1.

Example :

A : [3 5 4 2]

Output : 2
for the pair (3, 4)
*/
public class MaxDistance {
    // DO NOT MODIFY THE LIST
    public int maximumGap(final List<Integer> a) {

        int maxDiff = -1;
        int i;
        int j;
        int[] leftMin = new int[a.size()];
        int[] rightMax = new int[a.size()];

        leftMin[0] = a.get(0);
        for(i = 1; i < a.size(); i++)
            leftMin[i] = Math.min(leftMin[i-1], a.get(i));

        rightMax[a.size()-1] = a.get(a.size()-1);

        for(j = a.size()-2; j >= 0; j--)
            rightMax[j] = Math.max(rightMax[j+1], a.get(j));

        i = 0;
        j = 0;
        //System.out.println();
        while(j < a.size() && i < a.size()){

            if(leftMin[i] <= rightMax[j]){
                maxDiff = Math.max(j - i, maxDiff);
                j++;
            }
            else {
                i++;
            }
        }


        return maxDiff;
    }

    public static void main(String[] args) {

        List A = new ArrayList();
        //[-2,1,-3,4,-1,2,1,-5,4],
        //A.add(3);A.add(5);A.add(4);A.add(2);

        //[ 100, 100, 100, 100, 100 ]
        A.add(100);A.add(100);A.add(100);A.add(100);A.add(100);

        System.out.println(new MaxDistance().maximumGap(A));

    }
}
