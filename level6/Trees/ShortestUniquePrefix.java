package com.dr.level6.Trees;

import java.util.*;

/*
 * Find shortest unique prefix to represent each word in the list.
 *
 Example:

 Input: [zebra, dog, duck, dove]
 Output: {z, dog, du, dov}
 where we can see that
 zebra = z
 dog = dog
 duck = du
 dove = dov
 NOTE : Assume that no word is prefix of another. In other words, the representation is always possible.
 */
class TrieNode {
    int count = 0;
    Map<Character, TrieNode> children = new HashMap<>();
}
public class ShortestUniquePrefix {

    public ArrayList<String> prefix(ArrayList<String> a) {
        TrieNode root = new TrieNode();

        for (String s : a)
            insert(root, s);


        ArrayList<String> prefixes = new ArrayList<>();
        for (String s : a)
            prefixes.add(findPrefix(root, s));

        return prefixes;
    }

    void insert(TrieNode root, String s) {
        TrieNode node = root;

        for (Character ch : s.toCharArray()) {
            node = node.children.computeIfAbsent(ch, c -> new TrieNode());
            node.count++;
        }
    }

    String findPrefix(TrieNode root, String s) {
        TrieNode node = root;
        char[] chars = s.toCharArray();
        int i = 0;

        StringBuilder prefix = new StringBuilder();
        while (true) {
            char ch = chars[i++];

            prefix.append(ch);
            node = node.children.get(ch);

            if (node.count == 1)
                return prefix.toString();
        }
    }
    public static void main(String[] args){
        ArrayList<String> a = new ArrayList<String>();
        //  a.add("bearcat");
        //  a.add("bert");
        a.add("zebra");
        a.add("dog");
        a.add("duck");
        a.add("dove");

        System.out.print(new ShortestUniquePrefix().prefix(a));
    }
}
