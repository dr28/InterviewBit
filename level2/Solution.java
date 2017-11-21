package com.dr.level2;

public class Solution {

    public int[][] prettyPrint(int A) {

        int n = 2*A-1;
        int[][] matrix = new int[n][n];
        int layers = A;

        for(int i = 0; i<layers; i++){

            if(i == layers-1){
                matrix[i][i] = A;

            }else{
                for(int j = i; j<n-1-i; j++){
                    matrix[i][j] = A;
                    matrix[j][n-1-i] = A;
                    matrix[n-1-i][n-1-j] = A;
                    matrix[n-1-j][i] = A;

                }
            }

            A--;
        }

        return matrix;
    }

    public static void main(String [ ] arg) {
        Solution sol = new Solution();

        int [][] arr = sol.prettyPrint(4);
         for (int i=0; i<arr.length; i++) {
           for (int j=0; j<arr[i].length; j++) {
                     System.out.print(arr[i][j]);

           }
            System.out.println();

         }
    }
}
