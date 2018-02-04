package com.dr.level7.DynamicProgramming;

import java.util.ArrayList;
/*Given a 2D matrix, find the number non-empty sub matrices, such that the sum of the elements inside the sub matrix is
equal to 0. (note: elements might be negative).

Example:

Input

-8 5  7
3  7 -8
5 -8  9
Output
2

Explanation
-8 5 7
3 7 -8
5 -8 9

-8 5 7
3 7 -8
5 -8 9
*/
public class SubMatricesWithSumZero {

    public int solve(ArrayList<ArrayList<Integer>> A) {
        if(A.size() == 0 || A.get(0).size() == 0)
            return 0;
        int m,n;
        m = A.size();
        n = A.get(0).size();
        int[][] sum = new int[m+1][n+1];
        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                sum[i][j] = A.get(i-1).get(j-1) + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
            }
        }
        int count = 0;
        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                for(int k=i;k<=m;k++) {
                    for(int l=j;l<=n;l++) {
                        if(sum[k][l] - sum[k][j-1] - sum[i-1][l] + sum[i-1][j-1] == 0) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;

    }

    public static void main(String args[]) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(-8);
        a.add(5);
        a.add(7);
        A.add(a);

        a = new ArrayList();
        a.add(3);
        a.add(7);
        a.add(-8);
        A.add(a);
        a = new ArrayList();

        a.add(5);
        a.add(-8);
        a.add(9);
        A.add(a);
        System.out.println(A);

        System.out.println(new SubMatricesWithSumZero().solve(A));

    }
}
