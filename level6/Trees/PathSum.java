package com.dr.level6.Trees;
/*Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the
given sum.

Example :

Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem*/
public class PathSum {

    public int hasPathSum(TreeNode a, int b) {
        if (a == null) return 0;

        b -= a.val;
        if (b == 0 && isLeaf(a)) {
            return 1;
        }
        int left = hasPathSum(a.left, b);
        int right = hasPathSum(a.right, b);

        return Math.max(left,right);
    }
    public boolean isLeaf(TreeNode root){
        return (root.left == null) && (root.right == null);
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

        tree.right.right.right = new TreeNode(1);

        System.out.println("Tree -- "+new PathSum().hasPathSum(tree, 22));

    }
}
