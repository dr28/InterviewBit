package com.dr.level8;

import java.util.*;
/*Given two words (start and end), and a dictionary, find the shortest transformation sequence from start to end, such
that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
If there are multiple such sequence of shortest length, return all of them. Refer to the example for more details.

Example :

Given:

start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
Return

  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]

Note:
All words have the same length.
All words contain only lowercase alphabetic characters.
*/
public class WordLadder2 {

    public ArrayList<ArrayList<String>> findLadders(String start, String end, ArrayList<String> dict) {

        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<String> current = new ArrayList<String>();
        Queue<WordNode> queue  = new LinkedList<WordNode>();
        queue.offer(new WordNode(start, 1, null));

        Set<String> d = new HashSet<String>(dict);
        d.add(end);
        int minStep  = 0;

        Set<String> visited = new HashSet<String>();
        Set<String> unvisited  = new HashSet<String>();
        unvisited.addAll(d);

        int preNumSteps = 0;

        while(!queue.isEmpty()){

            WordNode top = queue.poll();

            String word = top.word;
            int currNumSteps = top.numSteps;

            if(word.equals(end)){
                if(minStep == 0)
                    minStep = top.numSteps;
                if(top.numSteps == minStep && minStep != 0){
                    ArrayList<String> t = new ArrayList<String>();
                    t.add(top.word);
                    while(top.pre != null){
                        t.add(0, top.pre.word);
                        top = top.pre;
                    }
                    result.add(t);
                    continue;
                }
            }

            if(preNumSteps < currNumSteps)
                unvisited.removeAll(visited);

            preNumSteps = currNumSteps;

            char[] arr = word.toCharArray();
            for(int i = 0; i < arr.length; i++){
                for(char c = 'a'; c <= 'z'; c++){
                    char temp = arr[i];
                    if(arr[i] != c)
                        arr[i] = c;
                    String newWord = new String(arr);
                    if(unvisited.contains(newWord)){
                        queue.offer(new WordNode(newWord, top.numSteps + 1, top));
                        visited.add(newWord);
                    }
                    arr[i] = temp;
                }
            }
        }

        return result;
    }
    public static void main(String[] args){
        String start = "hit";
        String end = "cog";
        ArrayList<String> dict = new ArrayList<String>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");

        ArrayList<ArrayList<String>> result = new WordLadder2().findLadders(start, end, dict);

        for(ArrayList<String> current : result)
            System.out.println(current);
    }
}
