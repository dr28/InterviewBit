package com.dr.level7.DynamicProgramming;
/*Given two words A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example :
edit distance between
"Anshuman" and "Antihuman" is 2.

Operation 1: Replace s with t.
Operation 2: Insert i.*/
public class EditDistance {
    public int minDistance(String A, String B) {
        int m = A.length();
        int n = B.length();

        int dp[][] = new int[m+1][n+1];


        for (int i=0; i<=m; i++) {
            for (int j=0; j<=n; j++) {


                if (i==0)
                    dp[i][j] = j;  // Min. operations = j

                else if (j==0)
                    dp[i][j] = i; // Min. operations = i

                else if (A.charAt(i-1) == B.charAt(j-1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + min(dp[i][j - 1],  // Insert
                            dp[i - 1][j],  // Remove
                            dp[i - 1][j - 1]); // Replace

            }

        }

        return dp[m][n];
    }

    int min(int x,int y, int z) {
        if (x <= y && x <= z) return x;
        if (y <= x && y <= z) return y;
        else return z;
    }
    public static void main(String[] args)  {
        String s1 = "Anshuman";
        String s2 = "Antihuman";

        s1 = "sunday";
        s2 = "saturday";

        s1 = "ABC";
        s2 = "AD";
        System.out.println(new EditDistance().minDistance(s1, s2));

    }
}
