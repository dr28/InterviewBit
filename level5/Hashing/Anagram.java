package com.dr.level5.Hashing;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class Anagram {
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        HashMap<String, ArrayList<Integer>> tempMap = new HashMap<String, ArrayList<Integer>>();

        for(int i = 0; i<a.size(); i++) {
            char[] c = a.get(i).toCharArray();
            Arrays.sort(c);
            String sortedWord = new String(c);
            if(tempMap.get(sortedWord) == null) {
                ArrayList<Integer> index = new ArrayList<Integer>();
                index.add(i+1);
                tempMap.put(sortedWord, index);
            }
            else {
                tempMap.get(sortedWord).add(i+1);

            }


        }
        for(ArrayList<Integer> index : tempMap.values()){
            result.add(index);
        }

        return result;
    }
        public static void main(String args[])
    {
        List<String> a = new ArrayList<String>();
        a.add("cat");
        a.add("dog");
        a.add("god");
        a.add("atc");
        ArrayList<ArrayList<Integer>> result = new Anagram().anagrams(a);
        System.out.print(result);

    }
}
