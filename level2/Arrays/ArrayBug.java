package com.dr.level2.Arrays;

import java.util.ArrayList;

/*The following code is supposed to rotate the array A by B positions.
        So, for example,

        A : [1 2 3 4 5 6]
        B : 1

        The output :

        [2 3 4 5 6 1]
        However, there is a small bug in the problem. Fix the bug and submit the problem.
*/
public class ArrayBug {

    public ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
        ArrayList<Integer> ret = new ArrayList<Integer>();

        for (int i = 0; i < A.size(); i++) {
            //ret.add(A.get(i + B)); //bug in this line, replace it with below line
            ret.add(A.get((i+B)%A.size()));
        }
        return ret;
    }

    public static void main(String[] args) {
        // A declared here
        ArrayList A = new ArrayList();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        A.add(6);

        int B = 1;

        ArrayList result = new ArrayBug().rotateArray(A, B);
        System.out.println(result);
    }
}
