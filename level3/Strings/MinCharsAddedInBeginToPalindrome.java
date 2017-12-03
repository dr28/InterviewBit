package com.dr.level3.Strings;
/*You are given a string. The only operation allowed is to insert characters in the beginning of the string. How many minimum characters are needed to be inserted to make the string a palindrome string

Example:
Input: ABC
Output: 2
Input: AACECAAAA
Output: 2*/
public class MinCharsAddedInBeginToPalindrome {

    // Returns minimum character to be added at
    // front to make string palindrome
    public int solve(String A) {
        String revStr = new StringBuffer(A).reverse().toString();

        String concat = A + "$" + revStr;

        //  Get LPS array of this concatenated string
        int[] lps = computeLPSArray(concat);

        // By subtracting last entry of lps vector from
        // string length, we will get our result
        return (A.length() - lps[lps.length - 1]);
    }

    public static void main(String[] args) {

        String input = "abeda";
        input = "banana";
        input = "babb";
        input = "apple";
        // input = "xgg";
        //input = "wkfnqduxwfnfozvsrtkjpr";

        System.out.println("result " + new MinCharsAddedInBeginToPalindrome().solve(input));
    }

    int[] computeLPSArray(String str) {
        int M = str.length();
        int[] lps = new int[M];

        int len = 0;

        // the loop calculates lps[i] for i = 1 to M-1
        int i = 1;
        while (i < M) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else // (str[i] != str[len])
            {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar
                // to search step.
                if (len != 0) {
                    len = lps[len - 1];

                    // Also, note that we do not increment
                    // i here
                } else // if (len == 0)
                {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}

   /* int Solution::solve(string A) {
        int start = 0 , end = A.length()-1;
        int temp_end = end;*/
    /*Idea is to find longest palindrome length starting from index 0 . Differece of
    this length from string length is the required value*/
    /*    while(start<=temp_end)
        {
            if(A[start]==A[temp_end])
            {
                start++;
                temp_end--;
            }
            else
            {
                start = 0;
                temp_end = --end;
            }
        }
        return A.length()-(end+1);

    }
    int Solution::solve (string A) {
        int start = 0, end = A.length() - 1, rec = A.length () - 1;
        while (start < end) {
            if (A [start] == A [end]) {
                start ++;
                end --;
            } else {
                start = 0;
                rec --;
                end = rec;
            }
        }
        return A.length () - rec - 1;
    }
}*/
