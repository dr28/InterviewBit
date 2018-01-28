package com.dr.level7.DynamicProgramming;

import java.util.ArrayList;
/*Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of
one or more dictionary words.

For example, given

s = "myinterviewtrainer",
dict = ["trainer", "my", "interview"].
Return 1 ( corresponding to true ) because "myinterviewtrainer" can be segmented as "my interview trainer".

Return 0 / 1 ( 0 for false, 1 for true ) for this problem

See Expected Output
*/
public class WordBreak {
    public int wordbreak(String A, ArrayList<String> B){
        boolean[] t = new boolean[A.length() + 1];
        t[0] = true;

        for(int i = 0; i < A.length(); i++){
            if(!t[i])
                continue;
            for(String word : B){
                int length = word.length();
                int end = i + length;
                if(end > A.length())
                    continue;
                if(t[end])
                    continue;
                if(A.substring(i, end).equals(word))
                    t[end] = true;
            }
        }

        return t[A.length()] == true ? 1 : 0;
    }

    public static void main(String[] args){
        ArrayList<String> b = new ArrayList<String>();
        b.add("cat");
        b.add("cats");
        b.add("and");
        b.add("sand");
        b.add("dog");
        String a = "catsanddog";
        System.out.println("List is : " + b);
        System.out.println("String is  : " + a);


        System.out.println(new WordBreak().wordbreak(a, b));

    }

}
