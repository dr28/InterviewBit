package com.dr.level7.DynamicProgramming;

import java.util.ArrayList;
/*Given a 2 * N Grid of numbers, choose numbers such that the sum of the numbers
is maximum and no two chosen numbers are adjacent horizontally, vertically or diagonally, and return it.

Example:

Grid:
	1 2 3 4
	2 3 4 5
so we will choose
3 and 5 so sum will be 3 + 5 = 8


Note that you can choose more than 2 numbers
*/
public class MaxSumWithoutAdjElements {
    public int adjacent(ArrayList<ArrayList<Integer>> A) {
        if(A == null || A.size() == 0)
            return 0;

        int m = A.size();
        int n = A.get(0).size();
        if(n == 0)
            return 0;

        int[] dp = new int[n];
        ArrayList<Integer> first = A.get(0);
        ArrayList<Integer> second = A.get(1);

        dp[0] = Math.max(first.get(0), second.get(0));

        if(n < 2)
            return dp[0];

        dp[1] = Math.max(first.get(1), second.get(1));
        dp[1] = Math.max(dp[0], dp[1]);

        for(int i = 2; i < n; i++){
            dp[i] = Math.max(first.get(i), second.get(i));
            dp[i] += dp[i-2];
            dp[i] = Math.max(dp[i], dp[i-1]);
        }

        return dp[n-1];
    }
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(14);
        temp.add(87);
        temp.add(36);
        temp.add(23);
        a.add(new ArrayList<Integer>(temp));
        temp.clear();
        temp.add(37);
        temp.add(59);
        temp.add(21);
        temp.add(68);
        a.add(new ArrayList<Integer>(temp));
        temp.clear();

        for(ArrayList<Integer> list : a)
            System.out.println(list);

        System.out.println(new MaxSumWithoutAdjElements().adjacent(a));

    }
    public int adjacent1(ArrayList<ArrayList<Integer>> a) {
        int n = a.get(0).size();
        if(n==0) return 0;
        int arr[] = new int[n];
        arr[0]=Math.max(a.get(0).get(0),a.get(1).get(0));
        if(n==1) return arr[0];
        arr[1]=Math.max(a.get(0).get(1),a.get(1).get(1));
        arr[1]=Math.max(arr[0],arr[1]);
        if(n==2) return arr[1];
        for(int i=2;i<n;i++){
            arr[i]=Math.max(a.get(0).get(i),a.get(1).get(i));
            arr[i]=Math.max(arr[i-1],arr[i]+arr[i-2]);
        }
        return arr[n-1];

    }

}
