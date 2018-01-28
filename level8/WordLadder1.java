package com.dr.level8;

import java.util.*;
/*
Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to
end, such that:

You must change exactly one character in every transformation
Each intermediate word must exist in the dictionary
Example :

Given:

start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note that we account for the length of the transformation path instead of the number of transformation itself.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
*/
class WordNode{
    String word;
    int numSteps;
    WordNode pre;
    public WordNode(String word, int numSteps, WordNode pre){
        this.word = word;
        this.numSteps = numSteps;
        this.pre = pre;
    }
    public WordNode(String word, int numSteps){
        this.word = word;
        this.numSteps = numSteps;
    }
}
public class WordLadder1 {

    public int ladderLength(String start, String end, ArrayList<String> dictV) {

        Queue<WordNode> queue = new LinkedList<WordNode>();
        queue.offer(new WordNode(start, 1));
        dictV.add(end);
        Set<String> set = new HashSet<String>(dictV);
        while(!queue.isEmpty()){
            WordNode top = queue.poll();
            String word = top.word;

            //if reached end word return number of steps till then
            if(word.equals(end))
                return top.numSteps;

            char[] arr = word.toCharArray();
            for(int i =0; i < arr.length; i++){
                for(char c = 'a'; c <= 'z'; c++){
                    char temp = arr[i];
                    if(arr[i] != c)
                        arr[i] = c;
                    //For each character change compare the new word in dictionary
                    String newWord = new String(arr);
                    if(set.contains(newWord)){
                        queue.offer(new WordNode(newWord, top.numSteps + 1));
                        set.remove(newWord);
                    }
                    arr[i] = temp;

                }
            }
        }

        return 0;
    }
    
    public static void main(String[] args){
        String start = "hit";
        String end = "cog";
        ArrayList<String> dictV = new ArrayList<String>();
        dictV.add("hot");
        dictV.add("dot");
        dictV.add("dog");
        dictV.add("lot");
        dictV.add("log");
        System.out.println(new WordLadder1().ladderLength(start, end, dictV));
    }
}
