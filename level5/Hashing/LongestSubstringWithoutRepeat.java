package com.dr.level5.Hashing;
/*Given a string,
find the length of the longest substring without repeating characters.

Example:

The longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.

For "bbbbb" the longest substring is "b", with the length of 1.*/
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeat {

    public int lengthOfLongestSubstring(String a) {
        // character and its latest position appeared in string
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        int start = 0;
        for (int i = 0; i < a.length(); i++) {
            char ch = a.charAt(i);
            if (map.containsKey(ch) && map.get(ch) >= start) {
                // if this character has appearred in current window
                start = map.get(ch) + 1;
            } else {
                result = Math.max(result, i - start + 1);
            }
            map.put(ch, i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.print(new LongestSubstringWithoutRepeat().lengthOfLongestSubstring("abcabcbb"));
    }

}
