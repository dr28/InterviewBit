package com.dr.level8;

import javafx.util.Pair;

import java.util.*;

/*
Knight movement on a chess board

Given any source point and destination point on a chess board, we need to find whether Knight can move to the destination or not.

Knight's movements on a chess board

The above figure details the movements for a knight ( 8 possibilities ). Note that a knight cannot go out of the board.

If yes, then what would be the minimum number of steps for the knight to move to the said point.
If knight can not move from the source point to the destination point, then return -1

Input:

N, M, x1, y1, x2, y2
where N and M are size of chess board
x1, y1  coordinates of source point
x2, y2  coordinates of destination point
Output:

return Minimum moves or -1
Example

Input : 8 8 1 1 8 8
Output :  6
See Expected Output


*/


public class KnightOnChessBoard {

    static int[] DX = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] DY = {-1, 1, -2, 2, -2, 2, -1, 1};

    public int knight(int n, int m, int x1, int y1, int x2, int y2) {
        x1--;
        y1--;
        x2--;
        y2--;

        int[][] cost = new int[n][m];

        int[] qx = new int[n * m];
        int[] qy = new int[n * m];
        int qn = 0;

        cost[x1][y1] = 1;
        qx[qn] = x1;
        qy[qn] = y1;
        qn++;

        for (int i = 0; i < qn; i++) {
            int x = qx[i];
            int y = qy[i];
            if (x == x2 && y == y2) {
                return cost[x][y]-1 ;
            }
            for (int j = 0; j < DX.length; j++) {
                int nx = x + DX[j];
                int ny = y + DY[j];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && cost[nx][ny] == 0) {
                    cost[nx][ny] = cost[x][y] + 1;
                    qx[qn] = nx;
                    qy[qn] = ny;
                    qn++;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        System.out.println(new KnightOnChessBoard().knight(8, 8, 1, 1, 8, 8));
    }
}
