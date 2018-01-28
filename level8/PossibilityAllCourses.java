package com.dr.level8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/*
Possibility of finishing all courses given pre-requisitesBookmark Suggest Edit
Problem Setter: mihai.gheorghe
Problem Tester: sneh_gupta
 There are a total of N courses you have to take, labeled from 1 to N. Some courses may have prerequisites, for example
 to take course 2 you have to first take course 1, which is expressed as a pair: [1,2].
Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses.
return 1/0 if it is possible/not possible.
The list of prerequisite pair are given in two integer arrays B and C where B[i] is a prerequisite for C[i].

 Example: If N = 3 and the prerequisite pairs are [1,2] and [2,3], then you can finish courses in the following order:
 1, 2 and 3. But if N = 2 and the prerequisite pairs are [1,2] and [2,1], then it is not possible for you to finish all
 the courses.
*/
public class PossibilityAllCourses {
    public int solve(int n, ArrayList<Integer> B, ArrayList<Integer> C) {
        int[] pre=new int[n];

        for(int i=0;i<C.size();i++)
            pre[C.get(i)-1]++;

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<pre.length;i++){
            if(pre[i]==0)q.add(i+1);
        }
        if(q.isEmpty())return 0;

        while(!q.isEmpty()){
            int curr=q.poll();
            for(int i=0;i<B.size();i++){
                if(B.get(i)==curr){
                    //System.out.println(C.get(i)-1+" "+pre[C.get(i)-1]);
                    pre[C.get(i)-1]--;
                    if(pre[C.get(i)-1]==0)q.add(C.get(i));
                }
            }
        }
        for(int i=0;i<pre.length;i++)
            if(pre[i]!=0)
                return 0;

        return 1;
    }


    public static void main(String[] args) {

        ArrayList a = new ArrayList();
        a.add(1);
        a.add(2);

        ArrayList b = new ArrayList();
        b.add(2);
        b.add(3);

        System.out.print(new PossibilityAllCourses().solve(3, a, b));
    }

}
