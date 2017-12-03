package com.dr.level3.Strings;
/*Please Note:

Another question which belongs to the category of questions which are intentionally stated vaguely.
Expectation is that you will ask for correct clarification or you will state your assumptions before you start coding.

Implement strStr().

 strstr - locate a substring ( needle ) in a string ( haystack ).
Try not to use standard library string functions for this question.

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 NOTE: Good clarification questions:
What should be the return value if the needle is empty?
What if both haystack and needle are empty?
For the purpose of this problem, assume that the return value should be -1 in both cases. */
public class StrStr {

    public static int strStr(final String haystack, final String needle) {

        if(haystack == null || needle == null)
            return -1;

        if(haystack.isEmpty() || needle.isEmpty())
            return -1;

        int i, j;
        int N = needle.length();
        int H = haystack.length();

        for(i = 0, j = 0; i < H && j < N; i++) {

            if(haystack.charAt(i) == needle.charAt(j))
                j++;
            else {
                i = i - j;
                j = 0;
            }
        }
        if(j == N)
            return i - N;
        else
            return -1;
    }
    public static void main(String[] args){
        String haystack = "taaste";
        String needle = "as";
        System.out.println(strStr(haystack, needle));

    }
}
