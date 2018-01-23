package com.dr.level8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*Given a binary tree, return the level order traversal of its nodes’ values. (ie, from left to right, level by level).

Example :
Given binary tree

    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]
Also think about a version of the question where you are asked to do a level order traversal of the tree when depth of
the tree is much greater than number of nodes on a level.*/

public class LevelOrder {

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        if(A == null)
            return result;

        int currentLevelNum = 1;
        int nextLevelNum = 0;
        queue.offer(A);
        ArrayList<Integer> levelList = new ArrayList<Integer>();
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            currentLevelNum--;
            levelList.add(node.val);

            if(node.left != null){
                queue.offer(node.left);
                nextLevelNum++;
            }

            if(node.right != null){
                queue.offer(node.right);
                nextLevelNum++;
            }

            if(currentLevelNum == 0){
                currentLevelNum = nextLevelNum;
                nextLevelNum = 0;
                result.add(new ArrayList<Integer>(levelList));
                levelList.clear();
            }

        }

        return result;
    }

    public static void main(String args[])
    {

        /* Constructed binary tree is
                   3
                 /   \
                9     20
              /         \
            15           7
        */
        /*       3
                / \
               9  20
                 /  \
                15   7
        */
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);

        System.out.println(new LevelOrder().levelOrder(tree));

    }
}
/**
 * Definition for binary tree */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; left=null; right=null;}
}
