package com.dr.level6.Trees;

import java.util.ArrayList;

/*Given a binary tree and a sum, find all root-to-leaf paths where each path’s sum equals the given sum.

For example:
Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return

[
   [5,4,11,2],
   [5,8,4,5]
]*/
public class RootToLeafPathWithSum {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return result;

        ArrayList<Integer> l = new ArrayList<Integer>();
        l.add((Integer)root.val);
        dfs(root, sum-(Integer)root.val, result, l);
        return result;
    }

    public void dfs(TreeNode t, int sum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> l){
        if(t.left==null && t.right==null && sum==0){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.addAll(l);
            result.add(temp);
        }

        //search path of left node
        if(t.left != null){
            l.add((Integer)t.left.val);
            dfs(t.left, sum-(Integer)t.left.val, result, l);
            l.remove(l.size()-1);
        }

        //search path of right node
        if(t.right!=null){
            l.add((Integer)t.right.val);
            dfs(t.right, sum-(Integer)t.right.val, result, l);
            l.remove(l.size()-1);
        }
    }
    
    public static void main(String args[])
    {
        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(4);
        tree.left.left = new TreeNode(11);
        tree.left.left.right = new TreeNode(2);
        tree.left.left.left = new TreeNode(7);

        tree.right = new TreeNode(8);
        tree.right.left = new TreeNode(13);
        tree.right.right = new TreeNode(4);

        tree.right.right.left = new TreeNode(5);
        tree.right.right.right = new TreeNode(1);

        System.out.println(new RootToLeafPathWithSum().pathSum(tree, 22));
    }
}
