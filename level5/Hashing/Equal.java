package com.dr.level5.Hashing;

import java.util.*;

/*Given an array A of integers, find the index of values that satisfy A + B = C + D, where A,B,C & D are integers values in the array

Note:

1) Return the indices `A1 B1 C1 D1`, so that
  A[A1] + A[B1] = A[C1] + A[D1]
  A1 < B1, C1 < D1
  A1 < C1, B1 != D1, B1 != C1

2) If there are more than one solutions,
   then return the tuple of values which are lexicographical smallest.

Assume we have two solutions
S1 : A1 B1 C1 D1 ( these are values of indices int the array )
S2 : A2 B2 C2 D2

S1 is lexicographically smaller than S2 iff
  A1 < A2 OR
  A1 = A2 AND B1 < B2 OR
  A1 = A2 AND B1 = B2 AND C1 < C2 OR
  A1 = A2 AND B1 = B2 AND C1 = C2 AND D1 < D2
Example:

Input: [3, 4, 7, 1, 2, 9, 8]
Output: [0, 2, 3, 5] (O index)
If no solution is possible, return an empty list.*/
public class Equal {

    public ArrayList<Integer> equal1(ArrayList<Integer> a) {

        ArrayList<Integer> result = new ArrayList<>();
        int len = a.size();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= len - 4; i++) {
            // A1 is i
            for (int j = i + 1; j < len; j++) {
                // B1 > A1
                int sum = a.get(i) + a.get(j);
                // two sum problem for sublist(i + 1, end) and excludes index j
                map.clear();
                int C1 = len;
                int D1 = -1;
                for (int p = i + 1; p < len; p++) {
                    // C1 > A1, C1 != B1, C1 < D1
                    if (p != j) { // C1 != B1
                        int num = a.get(p);
                        if (map.containsKey(num)) {
                            // found!! and 0-based index
                            if (map.get(num) < C1) {
                                C1 = map.get(num);
                                D1 = p;
                            }
                        } else if (!map.containsKey(sum - num)) {
                            // maintain the smaller index p
                            map.put(sum - num, p);
                        }
                    }
                }
                if (C1 != len) {
                    result.add(i);
                    result.add(j);
                    result.add(C1);
                    result.add(D1);
                    return result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(3);
        a.add(4);
        a.add(7);
        a.add(1);
        a.add(2);
        a.add(9);
        a.add(8);

        ArrayList result = new Equal().equal(a);
        for(int i= 0; i < result.size(); i++){
                System.out.print(result.get(i) + " ");
        }

    }
    // Solution
    public ArrayList<Integer> equal(ArrayList<Integer> a) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        ArrayList<ArrayList<Integer>> solutions = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            for (int j = i + 1; j < a.size(); j++) {
                int sum = a.get(i) + a.get(j);
                if (hash.containsKey(sum)) {
                    int x = hash.get(sum) / a.size();
                    int y = hash.get(sum) % a.size();
                    if (x < i && y != j && y != i) {
                        ArrayList<Integer> indices = new ArrayList<>();
                        indices.add(x);
                        indices.add(y);
                        indices.add(i);
                        indices.add(j);
                        solutions.add(indices);
                    }
                }
                else {
                    hash.put(sum, i * a.size() + j);
                }
            }
        }
        if (solutions.size() == 0)
            return new ArrayList<>();
        Collections.sort(solutions, new Comparator<ArrayList<Integer>>(){
            public int compare(ArrayList<Integer> s1, ArrayList<Integer> s2) {
                if (s1.get(0) != s2.get(0)) {
                    return s1.get(0).compareTo(s2.get(0));
                }
                else if (s1.get(1) != s2.get(1)) {
                    return s1.get(1).compareTo(s2.get(1));
                }
                else if (s1.get(2) != s2.get(2)) {
                    return s1.get(2).compareTo(s2.get(2));
                }
                else {
                    return s1.get(3).compareTo(s2.get(3));
                }
            }
        });
        return solutions.get(0);
    }
}
