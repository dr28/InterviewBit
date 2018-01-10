package com.dr.level5.Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*Given a set of distinct integers, S, return all possible subsets.

 Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Also, the subsets should be sorted in ascending ( lexicographic ) order.
The list is not necessarily sorted.
Example :

If S = [1,2,3], a solution is:

[
  [],
  [1],
  [1, 2],
  [1, 2, 3],
  [1, 3],
  [2],
  [2, 3],
  [3],
]*/
public class SubSet {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        if(A == null)
            return null;
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        for(int i = 0; i < A.size(); i++){
            ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();

            for(ArrayList<Integer> list : result){
                temp.add(new ArrayList<Integer>(list));
            }

            for(ArrayList<Integer> list : temp){
                list.add(A.get(i));
            }
            ArrayList<Integer> single = new ArrayList<Integer>();
            single.add(A.get(i));
            temp.add(single);


            result.addAll(temp);
        }
        result.add(0, new ArrayList<Integer>());

        Collections.sort(result, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                int an = a.size();
                int bn = b.size();
                for (int i = 0; i < Math.min(an, bn); i++) {
                    int cmp = Integer.compare(a.get(i), b.get(i));
                    if (cmp != 0)
                        return cmp;
                }
                return Integer.compare(a.size(), b.size());
            }
        });

        return result;
    }
    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        a.add(3);
        //ArrayList<ArrayList<Integer>> result = new SubSet().subsets(a);
        ArrayList<ArrayList<Integer>> result = new SubSet().subsets1(a);

        for(ArrayList<Integer> list : result)
            System.out.println(list);
    }
    // from solution
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> subsets1(ArrayList<Integer> a) {

        Collections.sort(a);

        gen(a,new ArrayList(),0);
        return res;

    }

    void gen (ArrayList<Integer> a, ArrayList<Integer> temp,int idx){
        res.add(new ArrayList(temp));
        if(idx>a.size()){

            return;
        }

        for(int i=idx;i<a.size();i++){

            temp.add(a.get(i));
            gen(a,temp,i+1);
            temp.remove(temp.size()-1);
        }
    }
}
