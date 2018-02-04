package com.dr.level7.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*Given a 2D binary matrix filled with 0’s and 1’s, find the largest rectangle containing all ones and return its area.

        Bonus if you can solve it in O(n^2) or less.

        Example :

        A : [  1 1 1
        0 1 1
        1 0 0
        ]

        Output : 4

        As the max area rectangle is created by the 2x2 rectangle created by (0,1), (0,2), (1,1) and (1,2)
*/
public class MaxRectangleBinaryMatrix {
    public int maximalRectangle(ArrayList<ArrayList<Integer>> A) {

        int[][] map2 = new int[A.size()][A.get(0).size()];
        for (int[] row:map2){
            Arrays.fill(row,0);
        }
        int max_area = -1;
        for (int row = 0 ; row <A.size(); row++){
            for (int col = 0 ; col <A.get(0).size(); col++){
                if (row == 0 || map2[row-1][col] == 0 || A.get(row).get(col) == 0){
                    map2[row][col] = A.get(row).get(col);
                }else{
                    if (A.get(row).get(col)==1){
                        map2[row][col] = map2[row-1][col]+1;
                    }
                }
            }
            max_area = Math.max(max_area,maxArea(map2[row]));
        }
        //System.out.println(maxArea(map2[a.size()-1]));

        return max_area;
    }

    public int maxArea(int[] array){
        Stack<Integer> st = new Stack<Integer>();
        int maxArea = -1;
        int i = 0;
        while (i < array.length){
            if (st.isEmpty() || (array[i] >=array[st.peek()])){
                st.push(i);
                i++;
            } else{
                int element = st.pop();
                int area = -1;
                if (st.isEmpty()){
                    area = array[element] * i;
                } else{
                    area= array[element] *(i-st.peek()-1);
                }

                maxArea = Math.max(area,maxArea);

            }
        }
        while(!st.isEmpty()){
            int element = st.pop();
            int area = -1;
            if (st.isEmpty()){
                area = array[element] * i;
            } else{
                area= array[element] *(i-st.peek()-1);
            }

            maxArea = Math.max(area,maxArea);
        }
        return maxArea;
    }


    public static void main(String args[]) {

        ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();

        temp.add(1);
        temp.add(1);
        temp.add(1);

        a.add(temp);
        temp = new ArrayList<Integer>();

        temp.add(0);
        temp.add(1);
        temp.add(1);

        a.add(temp);
        temp = new ArrayList<Integer>();

        temp.add(1);
        temp.add(0);
        temp.add(0);
        a.add(temp);

        System.out.println(new MaxRectangleBinaryMatrix().maximalRectangle(a));
    }
}
