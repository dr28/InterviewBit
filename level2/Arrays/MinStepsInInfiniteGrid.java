package com.dr.level2.Arrays;
import java.util.ArrayList;

/*You are in an infinite 2D grid where you can move in any of the 8 directions :

    (x,y) to
    (x+1, y),
    (x - 1, y),
    (x, y+1),
    (x, y-1),
    (x-1, y-1),
    (x+1,y+1),
    (x-1,y+1),
    (x+1,y-1)
You are given a sequence of points and the order in which you need to cover the points. Give the minimum number of steps in which you can achieve it. You start from the first point.

Example :
Input : [(0, 0), (1, 1), (1, 2)]
Output : 2
It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).

This question is intentionally left slightly vague. Clarify the question by trying out a few cases in the “See Expected Output” section.*/

public class MinStepsInInfiniteGrid {

    public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        int x=0;
        int i,j,k;
        for(i=1;i<X.size();++i){
            j=Math.abs(X.get(i)-X.get(i-1));
            k=Math.abs(Y.get(i)-Y.get(i-1));
            x+=(j>k)?j:k;
        }
        return x;

    }
}
