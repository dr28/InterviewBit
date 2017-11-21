package com.dr.level2.Arrays;
import java.util.ArrayList;

/*Given an m x n matrix of 0s and 1s, if an element is 0, set its entire row and column to 0.

        Example - Given array A as

        1 0 1
        1 1 1
        1 1 1
        On returning, the array A should be :

        0 0 0
        1 0 1
        1 0 1
        Note that this will be evaluated on the extra memory used. Try to minimize the space and time complexity.*/
public class SetMatrixZero {

    public static void setZeroes(int[][] a) {
        boolean rows[] = new boolean[a.length];
        boolean columns[] = new boolean[a[0].length];

        for(int i = 0;i<a.length;++i){
            for(int j = 0;j<a[0].length;++j){
                if(a[i][j]==0){rows[i] = true;columns[j] = true;}
            }
        }

        for(int i=0;i<rows.length;++i){
            if(rows[i])
                for(int j=0;j<columns.length;++j)a[i][j]=0;
        }
        for(int j=0;j<columns.length;++j){
            if(columns[j])
                for(int i=0;i<rows.length;++i)a[i][j]=0;
        }
    }

    public static void printArray(int[][] a){
        System.out.println();
        for(int i= 0;i<a.length;++i) {
            for(int j = 0;j<a[0].length;++j){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void setZeroes(ArrayList<ArrayList<Integer>> a) {
        int[] rows = new int[a.size()];

        int[] columns = new int[a.get(0).size()];
        for(int i = 0; i < a.size(); i++){
            for(int j = 0; j < a.get(i).size(); j++){
                if(a.get(i).get(j) == 0){
                    rows[i] = 1;
                    columns[j] = 1;
                }
            }
        }

        for(int i = 0; i < a.size(); i++){
            for(int j = 0; j < a.get(i).size(); j++){
                if(rows[i] == 1 ||columns[j] == 1){
                    a.get(i).set(j, 0);
                }
            }
        }
    }

    public static void printArrayList(ArrayList<ArrayList<Integer>> a){
        for(int i = 0; i < a.size(); i++) {
            System.out.print("[");
            for(int j = 0; j < a.get(i).size(); j++){
                System.out.print(a.get(i).get(j));
                if(j != a.get(i).size()-1) System.out.print(" ");
            }
            System.out.print("]");
        }
    }

    public static void main(String[] args) {
        //int[][] a = {
        //        {1,0,1},
        //        {1,1,1},
        //        {1,1,1}
        //};
        //       {
        //       {1, 2, 9, 2, 4},
        //       {2, 0, 3, 2, 1},
        //       {2, 3, 4, 5, 0},
        //       {3, 4, 6, 3, 4}
        //};
        //setZeroes(a);
        //printArray(a);

        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        // A :
            //[
            //  [0, 0]
            //  [1, 0]
            //]
        ArrayList temp = new ArrayList<Integer>();
        temp.add(0);
        temp.add(0);
        A.add(temp);

        temp = new ArrayList<Integer>();
        temp.add(1);
        temp.add(0);
        A.add(temp);

        setZeroes(A);
        printArrayList(A);
    }
}
