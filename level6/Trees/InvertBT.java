package com.dr.level6.Trees;

import java.util.LinkedList;
import java.util.Queue;

/*Given a binary tree, invert the binary tree and return it.
Look at the example for more details.

Example :
Given binary tree

     1
   /   \
  2     3
 / \   / \
4   5 6   7
invert and return

     1
   /   \
  3     2
 / \   / \
7   6 5   4
*/
public class InvertBT {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) {
            return null;
        }
        
        TreeNode temp=root.right;
        root.right=invertTree(root.left);
        root.left=invertTree(temp);
        return root;
    }

    public static void main(String[] args){
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.right = new TreeNode(7);
        tree.right.left = new TreeNode(6);

        TreeNode result = new InvertBT().invertTree(tree);
        Queue q = new LinkedList();
        q.add(result);
        while (!q.isEmpty()) {
            TreeNode node = (TreeNode) q.poll();

            System.out.println("node " + node.val);
            if (node.left != null)
                q.add(node.left);

            if (node.right != null)
                q.add(node.right);

        }
    }
}
