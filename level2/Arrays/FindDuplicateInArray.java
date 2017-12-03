package com.dr.level2.Arrays;
import java.util.ArrayList;
import java.util.List;
/*Given a read only array of n + 1 integers between 1 and n, find one number that repeats in linear time using less than O(n) space and traversing the stream sequentially O(1) times.

Sample Input:

[3 4 1 4 1]
Sample Output:

1
If there are multiple possible answers ( like in the sample case above ), output any one.

If there is no duplicate, output -1*/

public class FindDuplicateInArray {
    // DO NOT MODIFY THE LIST
    public int repeatedNumber(final List<Integer> a) {
        int[] count = new int[a.size()];
        for(int i = 0; i < a.size(); i++){
            if(count[a.get(i)] == 1)
                return a.get(i);
            else
                count[a.get(i)] = 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        //[3 4 1 4 1]
        List input = new ArrayList();
        input.add(3);
        input.add(4);
        input.add(1);
        input.add(4);
        input.add(1);

        System.out.println(new FindDuplicateInArray().repeatedNumber(input));
    }

}
