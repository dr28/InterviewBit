package com.dr.level7.DynamicProgramming;

import java.util.ArrayList;
/*There are N coins (Assume N is even) in a line. Two players take turns to take a coin from one of the ends of the
line until there are no more coins left. The player with the larger amount of money wins. Assume that you go first.

Write a program which computes the maximum amount of money you can win.

Example:

suppose that there are 4 coins which have value
1 2 3 4
now you are first so you pick 4
then in next term
next person picks 3 then
you pick 2 and
then next person picks 1
so total of your money is 4 + 2 = 6
next/opposite person will get 1 + 3 = 4
so maximum amount of value you can get is 6
*/
public class CoinsInALine {
    public int maxcoin(ArrayList<Integer> A) {
        int [][] table = new int[A.size()][A.size()];

        for (int k = 0; k < A.size(); k++) {

            for (int i = 0, j = k; j < A.size(); i++, j++)
            {
                // Here x is value of F(i+2, j), y is F(i+1, j-1) and
                // z is F(i, j-2) in above recursive formula
                int x = ((i+2) <= j) ? table[i+2][j] : 0;
                int y = ((i+1) <= (j-1)) ? table[i+1][j-1] : 0;
                int z = (i <= (j-2))? table[i][j-2]: 0;

                table[i][j] = max(A.get(i) + min(x, y), A.get(j) + min(y, z));
            }
        }
        return table[0][A.size()-1];

    }
    int max(int a, int b)  {    return a > b ? a : b;  }
    int min(int a, int b)  {    return a < b ? a : b;  }



    public static void main(String args[]) {
        ArrayList arr1 = new ArrayList();
        arr1.add(8);
        arr1.add(15);
        arr1.add(3);
        arr1.add(7);

        System.out.println(new CoinsInALine().maxcoin(arr1));

    }
}
