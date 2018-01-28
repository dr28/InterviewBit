package com.dr.level7.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Example :

Input : [1 2 1 2]
Output : 2

Explanation :
  Day 1 : Buy
  Day 2 : Sell
  Day 3 : Buy
  Day 4 : Sell
  */

public class BestTime2BuyNSellStocks3 {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY

    public int maxProfit(final List<Integer> A) {
        if(A == null || A.size() == 0)
            return 0;

        int profit = 0;

        int[] left = new int[A.size()];
        int[] right = new int[A.size()];

        left[0] = 0;
        int min = A.get(0);
        for(int i = 1; i < A.size(); i++){
            min = Math.min(min, A.get(i));
            left[i] = Math.max(left[i-1], A.get(i) - min);
        }

        for(int i = 0; i < A.size(); i++) {
            System.out.print(left[i] + " | ");
        }

        System.out.println("");

        right[A.size()-1] = 0;
        int max = A.get(A.size()-1);
        for(int i = A.size() - 2; i >= 0; i--){
            max = Math.max(max, A.get(i));
            right[i] = Math.max(right[i+1], max- A.get(i));
        }
        for(int i = 0; i < A.size(); i++) {
            System.out.print(right[i] + " | ");
        }
        System.out.println("");

        for(int i =0; i < A.size(); i++)
            profit = Math.max(profit, left[i] + right[i]);
        return profit;
    }
    public static void main(String[] args){
        List<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(4);
        a.add(5);
        a.add(7);
        a.add(6);
        a.add(3);
        a.add(2);
        a.add(9);

        System.out.println(new BestTime2BuyNSellStocks3().maxProfit(a));
        System.out.println(maxProfit2(a));

    }
    static int maxProfit2(List<Integer> A)
    {
        int n = A.size();
        // Create profit array and initialize it as 0
        int profit[] = new int[n];
        //for (int i=0; i<n; i++)
        //    profit[i] = 0;

        /* Get the maximum profit with only one transaction
           allowed. After this loop, profit[i] contains maximum
           profit from price[i..n-1] using at most one trans. */
        int max_price = A.get(n-1);
        for (int i=n-2;i>=0;i--)
        {
            // max_price has maximum of price[i..n-1]
            if (A.get(i) > max_price)
                max_price = A.get(i);

            // we can get profit[i] by taking maximum of:
            // a) previous maximum, i.e., profit[i+1]
            // b) profit by buying at price[i] and selling at
            //    max_price
            profit[i] = Math.max(profit[i+1], max_price-A.get(i));
        }
        for(int i = 0; i < A.size(); i++) {
            System.out.print(profit[i] + " | ");
        }
        System.out.println("");

        /* Get the maximum profit with two transactions allowed
           After this loop, profit[n-1] contains the result */
        int min_price = A.get(0);
        for (int i=1; i<n; i++)
        {
            // min_price is minimum price in price[0..i]
            if (A.get(i) < min_price)
                min_price = A.get(i);

            // Maximum profit is maximum of:
            // a) previous maximum, i.e., profit[i-1]
            // b) (Buy, Sell) at (min_price, price[i]) and add
            //    profit of other trans. stored in profit[i]
            profit[i] = Math.max(profit[i-1], profit[i] +
                    (A.get(i)-min_price) );
        }
        System.out.println(A);

        for(int i = 0; i < A.size(); i++) {
            System.out.print(profit[i] + " | ");
        }
        System.out.println("");
        int result = profit[n-1];
        return result;
    }

    // From Solution
    public int maxProfit1(final List<Integer> a) {
        if (a.size() == 0) return 0;

        int fB = Integer.MIN_VALUE; int fS = 0;
        int sB = Integer.MIN_VALUE; int sS = 0;

        for (Integer curPrice : a) {
            fB = Math.max(fB, -curPrice);
            fS = Math.max(fS, curPrice+fB);
            sB = Math.max(sB, fS-curPrice);
            sS = Math.max(sS, curPrice+sB);
        }

        return sS;
    }
}
