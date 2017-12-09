package com.dr.level5.Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 < index2. Please note that
your returned answers (both index1 and index2 ) are not zero-based.
Put both these numbers in order in an array and return the array from your function ( Looking at the function signature will make things
clearer ). Note that, if no pair exists, return empty list.

If multiple solutions exist, output the one where index2 is minimum. If there are multiple solutions with the minimum index2, choose the one
with minimum index1 out of them.

Input: [2, 7, 11, 15], target=9
Output: index1 = 1, index2 = 2*/
public class TwoSum {

    public ArrayList<Integer> twoSum(final List<Integer> a, int b) {
        ArrayList result = new ArrayList();

        for(int i=0; i<a.size(); i++) {
            System.out.println(a.get(i) + " a.get(i)");

            for(int j = i+1; j <a.size(); j++) {
                System.out.println(a.get(j) + " a.get(j)");

                int sum = ((Integer) a.get(i)).intValue() + ((Integer) a.get(j)).intValue();
                System.out.println(sum + " sum");

                if (sum == b) {

                    /*if (((Integer) a.get(i)).intValue() > ((Integer) a.get(j)).intValue()) {
                        System.out.println("  if ");

                        result.add(0, j + 1);
                        result.add(1, i + 1);
                    } else {
                        System.out.println("  else ");
*/
                        result.add(0, i + 1);
                        result.add(1, j + 1);
                    //}
                    i = a.size();
                    break;

                }
            }
            System.out.println( " ------ ");


        }

        return result;


    }

    public ArrayList<Integer> twoSum1(final List<Integer> a, int b) {

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        ArrayList<Integer> ans = new ArrayList<Integer>();

        for (int i = 0; i < a.size(); i++){
            int curr = a.get(i);

            if (map.containsKey(b-curr)){
                int index = map.get(b-curr);
                ans.add(index);
                ans.add(i + 1);
                return ans;
            }else if (!map.containsKey(curr)){
                map.put(curr, i + 1);
            }
        }

        return ans;
    }

    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList<Integer>();
        /*a.add(4);
        a.add(7);
        a.add(-4);
        a.add(2);
        a.add(2);

        a.add(2);

        a.add(3);
        a.add(-5);*/

        a.add(3);
        a.add(4);

        a.add(1);

        a.add(5);

       // 4, 7, -4, 2, 2, 2, 3, -5
        ArrayList<Integer> result = new TwoSum().twoSum1(a, 9);
        for(int i : result)
            System.out.print(i + " ");
    }
}
