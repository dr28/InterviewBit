package com.dr.level5.Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

/*Given a collection of integers that might contain duplicates, S, return all possible subsets.

 Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
The subsets must be sorted lexicographically.
Example :
If S = [1,2,2], the solution is:

[
[],
[1],
[1,2],
[1,2,2],
[2],
[2, 2]
]*/
public class SubSetII {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if(A == null || A.size() == 0) {
            ArrayList in = new ArrayList<Integer>();
            result.add(in);
            return result;
        }


        Collections.sort(A);
        HashSet<ArrayList<Integer>> res = new HashSet<ArrayList<Integer>>();
        for(int i = 0; i < A.size(); i++){
            HashSet<ArrayList<Integer>> temp = new HashSet<ArrayList<Integer>>();

            for(ArrayList<Integer> list : res){
                if(!temp.contains(list))
                    temp.add(new ArrayList<Integer>(list));
            }

            for(ArrayList<Integer> list : temp){
                list.add(A.get(i));
            }
            ArrayList<Integer> single = new ArrayList<Integer>();
            single.add(A.get(i));
            temp.add(single);


            for(ArrayList<Integer> list : temp){
                if(!res.contains(list))
                    res.add(new ArrayList<Integer>(list));
            }

        }
        res.add(new ArrayList<Integer>());

        for(ArrayList<Integer> list : res){

            result.add(new ArrayList<Integer>(list));
        }
        Collections.sort(result, new Comparator<ArrayList<Integer>>(){
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b){
                for(int i = 0; i < Math.min(a.size(), b.size()); i++){
                    int cmp = Integer.compare(a.get(i), b.get(i));
                    if(cmp != 0)
                        return cmp;
                }
                return Integer.compare(a.size(), b.size());
            }
        });

        return result;
    }

    public static void main(String[] args){

        ArrayList<Integer> a = new ArrayList<Integer>();
       // a.add(1);
        //a.add(2);
        //a.add(2);
        ArrayList<ArrayList<Integer>> result = new SubSetII().subsetsWithDup(a);
        for(ArrayList<Integer> list : result)
            System.out.println(list);
    }
}
