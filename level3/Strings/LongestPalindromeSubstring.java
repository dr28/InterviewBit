package com.dr.level3.Strings;
/*Given a string S, find the longest palindromic substring in S.

Substring of string S:

S[i...j] where 0 <= i <= j < len(S)

Palindrome string:

A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S.

Incase of conflict, return the substring which occurs first ( with the least starting index ).

Example :

Input : "aaaabaaa"
Output : "aaabaaa"*/
public class LongestPalindromeSubstring {

    public String longestPalindrome(String a) {
        int n = a.length();
        if(n <= 1)
            return a;
        int start = 0;
        int maxLen = 0;
        int leftIndex;
        int rightIndex;

        for(int index = 1; index < n; index++){
            leftIndex = index-1;
            rightIndex = index+1;

            while(rightIndex < n && a.charAt(rightIndex) == a.charAt(index))
                rightIndex++;


            while(leftIndex >= 0 && a.charAt(leftIndex) == a.charAt(index))
                leftIndex--;


            while(leftIndex >= 0 && rightIndex < n && a.charAt(leftIndex) == a.charAt(rightIndex)){
                leftIndex--;
                rightIndex++;

            }

            if(rightIndex - leftIndex - 1 > maxLen){
                maxLen = rightIndex - leftIndex - 1;
                start = leftIndex + 1;

            }
        }
        if(maxLen == 1)
            return a.substring(0, 1);
        return a.substring(start, start + maxLen);
    }


    public static void main(String[] args){
        String s = "abdbbbbdba";

        System.out.println(new LongestPalindromeSubstring().longestPalindrome(s));

    }
}
