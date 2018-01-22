package com.dr.level5.Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/*Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the
candidate numbers sums to T.

Each number in C may only be used once in the combination.

 Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
Example :

Given candidate set 10,1,2,7,6,1,5 and target 8,

A solution set is:

[1, 7]
[1, 2, 5]
[2, 6]
[1, 1, 6]
 Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.
Example : itertools.combinations in python.
If you do, we will disqualify your submission retroactively and give you penalty points. */
public class Combination2 {
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        ArrayList<ArrayList<Integer>> result = new  ArrayList<ArrayList<Integer>>();
        if(a == null || a.size() == 0)
            return result;
        Collections.sort(a);

        ArrayList<Integer> currentList = new ArrayList<Integer>();
        HashSet<ArrayList<Integer>> set = new  HashSet<ArrayList<Integer>>();
        combinationSum(a, b, 0, currentList, result, set);

        return result;
    }


    public static void combinationSum(ArrayList<Integer> a, int b,int j, ArrayList<Integer> currentList,
                                      ArrayList<ArrayList<Integer>> result,  HashSet<ArrayList<Integer>> set) {
        if(b == 0) {
            ArrayList<Integer> temp = new ArrayList<Integer>(currentList);
            if(!set.contains(temp)){
                set.add(temp);
                result.add(temp);
            }
            return;
        }

        for(int i = j; i < a.size(); i++){
            if(b < a.get(i))
                return;
            currentList.add(a.get(i));
            combinationSum(a, b - a.get(i), i+1, currentList, result, set);
            currentList.remove(currentList.size() - 1);
        }
    }

    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(10);
        a.add(1);
        a.add(2);
        a.add(7);
        a.add(6);
        a.add(1);
        a.add(5);
        int b = 8;
        ArrayList<ArrayList<Integer>> result = new Combination2().combinationSum(a, b);
        for(ArrayList<Integer> list : result)
            System.out.println(list);

    }
}
