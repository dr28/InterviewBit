package com.dr.level5.Backtracking;

import java.util.ArrayList;

/*Given two integers n and k, return all possible combinations of k numbers out of 1 2 3 ... n.

Make sure the combinations are sorted.

To elaborate,

Within every entry, elements should be sorted. [1, 4] is a valid entry while [4, 1] is not.
Entries should be sorted within themselves.
Example :
If n = 4 and k = 2, a solution is:

[
  [1,2],
  [1,3],
  [1,4],
  [2,3],
  [2,4],
  [3,4],
]
 Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.
Example : itertools.combinations in python.
If you do, we will disqualify your submission retroactively and give you penalty points. */
public class Combination {
    public ArrayList<ArrayList<Integer>> combine(int A, int B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> memo = new ArrayList<Integer>();
        Combine(result, memo, 1, A, B);
        return result;
    }

    /// <summary>
    /// Method overloaded for recursion
    /// </summary>
    /// <param name="result">list of list of integers</param>
    /// <param name="memo">list of integers for memorization</param>
    /// <param name="start">starting integer</param>
    /// <param name="n">range given from 1 to n</param>
    /// <param name="k">combination of k intergers</param>
    public void Combine(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> memo, int start, int n, int k) {
        if (k == 0) {
            // copy and add this memo list to result
            result.add(new ArrayList<Integer>(memo));
        } else {
            for (int i = start; i <= n; i++) {
                memo.add(i);
                Combine(result, memo, i + 1, n, k - 1);
                memo.remove(memo.size() - 1);
            }
        }
    }

    public static void main(String[] args) {

        int a = 4;
        int b = 2;

        ArrayList<ArrayList<Integer>> result = new Combination().combine(a, b);
        for (ArrayList<Integer> list : result)
            System.out.println(list);
    }
}
