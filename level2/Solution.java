package com.dr.level2;
/*Print concentric rectangular pattern in a 2d matrix.
        Let us show you some examples to clarify what we mean.

        Example 1: Input: A = 4.
        Output:
        4 4 4 4 4 4 4
        4 3 3 3 3 3 4
        4 3 2 2 2 3 4
        4 3 2 1 2 3 4
        4 3 2 2 2 3 4
        4 3 3 3 3 3 4
        4 4 4 4 4 4 4
        
        Example 2: Input: A = 3.
        Output:
        3 3 3 3 3
        3 2 2 2 3
        3 2 1 2 3
        3 2 2 2 3
        3 3 3 3 3
        The outermost rectangle is formed by A, then the next outermost is formed by A-1 and so on.
        You will be given A as an argument to the function you need to implement, and you need to return a 2D array.*/
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
