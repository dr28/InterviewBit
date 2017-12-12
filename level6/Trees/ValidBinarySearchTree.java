package com.dr.level6.Trees;
/*Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node’s key.
The right subtree of a node contains only nodes with keys greater than the node’s key.
Both the left and right subtrees must also be binary search trees.
Example :

Input :
   1
  /  \
 2    3

Output : 0 or False


Input :
  2
 / \
1   3

Output : 1 or True
Return 0 / 1 ( 0 for false, 1 for true ) for this problem*/
/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ValidBinarySearchTree {

    public int isValidBST(TreeNode a) {

        return isBSTUtil(a, Integer.MIN_VALUE, Integer.MAX_VALUE)? 1 : 0;
    }

    boolean isBSTUtil(TreeNode node, int min, int max) {

        /* an empty tree is BST */
        if (node == null)
            return true;

        if (node.val <= min || node.val >= max) return false;

        return (isBSTUtil(node.left, min, node.val) &&
                isBSTUtil(node.right, node.val, max));
    }

    public static void main(String args[])
    {

        /*TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);*/

        /*TreeNode tree = new TreeNode(2);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(3);*/

        /*

        1
        / \
       2    3
          /
        4
         \
          5

         */
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.left.right = new TreeNode(-1);
        tree.left.left = new TreeNode(-1);

        tree.right = new TreeNode(3);
        tree.right.left = new TreeNode(4);
        tree.right.right = new TreeNode(-1);

        tree.right.left.right = new TreeNode(5);
        tree.right.left.left = new TreeNode(-1);

        tree.right.right.right = new TreeNode(-1);
        tree.right.right.left = new TreeNode(-1);

        System.out.println("Tree -- "+new ValidBinarySearchTree().isValidBST(tree));

    }
}

