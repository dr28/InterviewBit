package com.dr.level7.DynamicProgramming;

import java.util.*;

/*Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Example :
Given
s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.*/
public class PalindromePartitioningII {
    public int minCut(String A) {
        if (A.length() == 0) {
            return 0;
        }

        int[] cut = new int[A.length()];
        boolean isPal[][] = new boolean[A.length()][A.length()];
        for (int i = 1; i < A.length(); i++) {
            int min = i;
            for (int j = 0; j <= i; j++) {
                if (A.charAt(i) == A.charAt(j) && (i <= j + 1 || isPal[i - 1][j + 1])) {
                    isPal[i][j] = true;
                    min = Math.min(min, j == 0 ? 0 : 1 + cut[j - 1]);
                }
            }
            cut[i] = min;
        }
        return cut[A.length() - 1];
    }

    public List<List<String>> partition(String s) {
        Map<Integer, List<List<String>>> dp = new HashMap<>();
        List<List<String>> result =  partitionUtil(s, dp, 0);
        List<List<String>> r = new ArrayList<>();
        for (List<String> l : result) {
            r.add(l);
        }
        return r;
    }

    private List<List<String>> partitionUtil(String s, Map<Integer, List<List<String>>> dp, int start) {
        if (start == s.length()) {
            List<String> r = new ArrayList<>();
            return Collections.singletonList(r);
        }

        if (dp.containsKey(start)) {
            return dp.get(start);
        }

        List<List<String>> words = new ArrayList<>();
        for (int i = start; i < s.length(); i++) {
            if (!isPalindrome(s, start, i) ) {
                continue;
            }
            String newWord = s.substring(start, i + 1);
            List<List<String>> result = partitionUtil(s, dp, i + 1);
            for (List l : result) {
                List<String> l1 = new ArrayList<>();
                l1.add(newWord);
                l1.addAll(l);
                words.add(l1);
            }
        }
        dp.put(start, words);
        return words;
    }

    private  boolean isPalindrome(String str, int r, int t) {
        while(r < t) {
            if (str.charAt(r) != str.charAt(t)) {
                return false;
            }
            r++;
            t--;
        }
        return true;
    }

    public static void main(String args[]) {
        String A = "aabb";

        System.out.println(new PalindromePartitioningII().minCut(A));
        System.out.println(new PalindromePartitioningII().partition(A));

    }
}
