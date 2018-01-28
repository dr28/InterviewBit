package com.dr.level7.DynamicProgramming;

import java.util.ArrayList;

/*Largest area of rectangle with permutationsBookmark Suggest Edit
Problem Setter: amitkgupta94
Problem Tester: RAMBO_tejasv
Given a binary grid i.e. a 2D grid only consisting of 0’s and 1’s, find the area of the largest rectangle inside the
grid such that all the cells inside the chosen rectangle should have 1 in them. You are allowed to permutate the columns
matrix i.e. you can arrange each of the column in any order in the final grid. Please follow the below example for more
clarity.

Lets say we are given a binary grid of 3 * 3 size.

1 0 1

0 1 0

1 0 0

At present we can see that max rectangle satisfying the criteria mentioned in the problem is of 1 * 1 = 1 area i.e
either of the 4 cells which contain 1 in it. Now since we are allowed to permutate the columns of the given matrix, we
can take column 1 and column 3 and make them neighbours. One of the possible configuration of the grid can be:

1 1 0

0 0 1

1 0 0

Now In this grid, first column is column 1, second column is column 3 and third column is column 2 from the original
given grid. Now, we can see that if we calculate the max area rectangle, we get max area as 1 * 2 = 2 which is bigger
than the earlier case. Hence 2 will be the answer in this case.
*/
public class LargestAreaRectanglePermutations {
    int maxArea(int mat[][])
    {
        // An auxiliary array to store count of consecutive 1's
        // in every column.
        int [][] hist = new int [mat.length+1][mat[0].length+1];

        // Step 1: Fill the auxiliary array hist[][]
        for (int i=0; i<mat[0].length; i++)
        {
            // First row in hist[][] is copy of first row in mat[][]
            hist[0][i] = mat[0][i];

            // Fill remaining rows of hist[][]
            for (int j=1; j<mat.length; j++)
                hist[j][i] = (mat[j][i]==0)? 0: hist[j-1][i]+1;
        }


        // Step 2: Sort rows of hist[][] in non-increasing order
        for (int i=0; i<mat.length; i++)
        {
            int [] count = new int [mat.length+1];

            // counting occurrence
            for (int j=0; j<mat[0].length; j++)
                count[hist[i][j]]++;

            //  Traverse the count array from right side
            int col_no = 0;
            for (int j=mat.length; j>=0; j--)
            {
                if (count[j] > 0)
                {
                    for (int k=0; k<count[j]; k++)
                    {
                        hist[i][col_no] = j;
                        col_no++;
                    }
                }
            }
        }

        // Step 3: Traverse the sorted hist[][] to find maximum area
        int curr_area, max_area = 0;
        for (int i=0; i<mat.length; i++)
        {
            for (int j=0; j<mat[0].length; j++)
            {
                // Since values are in decreasing order,
                // The area ending with cell (i, j) can
                // be obtained by multiplying column number
                // with value of hist[i][j]
                curr_area = (j+1)*hist[i][j];
                if (curr_area > max_area)
                    max_area = curr_area;
            }
        }
        return max_area;
    }
    public static void main(String[] args){
        ArrayList a = new ArrayList();
        ArrayList<Integer> temp = new ArrayList<Integer>();

        temp.add(1);
        temp.add(0);
        temp.add(1);
        a.add(temp);
        temp = new ArrayList<Integer>();
        temp.add(0);
        temp.add(1);
        temp.add(0);
        a.add(temp);
        temp = new ArrayList<Integer>();
        temp.add(1);
        temp.add(0);
        temp.add(0);
        a.add(temp);


        int mat[][] = { {1, 0, 1},
            {0, 1, 0},
            {1, 0, 0}
        };
        System.out.println(new LargestAreaRectanglePermutations().solve(a));

    }

   public int solve1(ArrayList<ArrayList<Integer>> A) {
       int [][] hist = new int [A.size()][A.get(0).size()];

       // Step 1: Fill the auxiliary array hist[][]
       for (int i=0; i<A.get(0).size(); i++)
       {
           // First row in hist[][] is copy of first row in mat[][]
           hist[0][i] = A.get(0).get(i);

           // Fill remaining rows of hist[][]
           for (int j=1; j<A.size(); j++)
               hist[j][i] = (A.get(j).get(i)==0)? 0: hist[j-1][i]+1;
       }


       // Step 2: Sort rows of hist[][] in non-increasing order
       for (int i=0; i<A.size(); i++)
       {
           int [] count = new int [A.size()+1];

           // counting occurrence
           for (int j=0; j<A.get(0).size(); j++)
               count[hist[i][j]]++;

           //  Traverse the count array from right side
           int col_no = 0;
           for (int j=A.size(); j>=0; j--)
           {
               if (count[j] > 0)
               {
                   for (int k=0; k<count[j]; k++)
                   {
                       hist[i][col_no] = j;
                       col_no++;
                   }
               }
           }
       }

       // Step 3: Traverse the sorted hist[][] to find maximum area
       int curr_area, max_area = 0;
       for (int i=0; i<A.size(); i++)
       {
           for (int j=0; j<A.get(0).size(); j++)
           {
               // Since values are in decreasing order,
               // The area ending with cell (i, j) can
               // be obtained by multiplying column number
               // with value of hist[i][j]
               curr_area = (j+1)*hist[i][j];
               if (curr_area > max_area)
                   max_area = curr_area;
           }
       }
       return max_area;
    }

    //from sol

    public int solve(ArrayList<ArrayList<Integer>> A) {
        int m=A.size();
        int n=A.get(0).size();
        int hist[][]=new int [m][n];

        for(int i = 0; i < n; i++){
            hist[0][i]=A.get(0).get(i);
        }
        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                if(A.get(i).get(j) == 1)
                    hist[i][j] =  hist[i-1][j] + 1;
                else
                    hist[i][j] = 0;
            }
        }


        int res=0;
        for(int i=0;i<m;i++){
            int count[]=new int[m+1];

            for(int j=0;j<n;j++){
                count[hist[i][j]]++;
            }
            int cnt=0;
            for(int k=m;k>=0;k--){
                cnt += count[k];
                res = Math.max(res, cnt * k);
            }


        }

        return res;

    }
}
