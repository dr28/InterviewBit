package com.dr.level3.Strings;
import java.util.ArrayList;

/*Write a function to find the longest common prefix string amongst an array of strings.

Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.

As an example, longest common prefix of "abcdefgh" and "abcefgh" is "abc".

Given the array of strings, you need to find the longest S which is the prefix of ALL the strings in the array.

Example:

Given the array as:

[

  "abcdefgh",

  "aefghijk",

  "abcefgh"
]
The answer would be “a”.*/

public class LongestCommonPrefix {

    public String longestCommonPrefix(ArrayList<String> a) {
        if (a.size() == 0)
            return "";

        String str;
        StringBuffer prefix = new StringBuffer();
        int min = Integer.MAX_VALUE;
        int k = 1;

        for (int i = 0; i < a.size(); i++) {
            min = Math.min(min, a.get(i).length());
        }

        for (int i = 0; i < min; i++) {

            char c = a.get(0).charAt(i);

            for (int j = 1; j < a.size(); j++) {

                if (c != a.get(j).charAt(i))
                    return prefix.toString();
            }

            prefix.append(c);

        }
        return prefix.toString();
    }

    public static void main(String[] args){

        ArrayList input = new ArrayList();
        input.add("abcdefgh");
        input.add("aefghijk");
        input.add("abcefgh");

        System.out.println(new LongestCommonPrefix().longestCommonPrefix(input));
    }
}
