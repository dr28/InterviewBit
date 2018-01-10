package com.dr.level5.Backtracking;

import java.util.ArrayList;

/*Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*n.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
Make sure the returned list of strings are sorted.*/
public class GenerateParanthesis {
    public ArrayList<String> generateParenthesis(int A) {
        ArrayList<String> result = new ArrayList<String>();
        for(int i =1; i <= A; i++)
            Parenth("", 0, 0, i, result, A);

        return result;
    }
    private void Parenth(String output, int open, int close, int pairs, ArrayList<String> result, int a){

        if(open == pairs && close == pairs && output.length() == 2*a)
            result.add(output);

        else {
            if(open < pairs)
                Parenth(output + "(", open + 1, close, pairs, result, a);

            if(close < open)
                Parenth(output + ")", open, close + 1, pairs, result, a);

        }
    }
    public static void main(String[] args){
        int a = 3;
        ArrayList<String> result = new GenerateParanthesis().generateParenthesis(a);

        for(String s: result)
            System.out.println(s);
    }

}

