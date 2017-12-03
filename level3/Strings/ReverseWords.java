package com.dr.level3.Strings;
import java.util.ArrayList;
import java.util.List;

/*Given an input string, reverse the string word by word.

        Example:

        Given s = "the sky is blue",

        return "blue is sky the".

        A sequence of non-space characters constitutes a word.
        Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
        If there are multiple spaces between words, reduce them to a single space in the reversed string.*/
public class ReverseWords {

    public String reverseWords(String a) {
        List<String> words = new ArrayList<>();
        String[] strs = a.split(" ");
        for (String str : strs) {
            if (!str.isEmpty()) {
                words.add(0, str);
            }
        }
        return String.join(" ", words);
    }

    public static void main(String[] args){
        String s = "the sky is blue";
        System.out.println(new ReverseWords().reverseWords(s));
    }

}
