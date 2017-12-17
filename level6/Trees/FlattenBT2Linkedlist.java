package com.dr.level6.Trees;

import java.util.Stack;
/*Given a binary tree, flatten it to a linked list in-place.

Example :
Given


         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
Note that the left child of all nodes should be NULL.*/
public class FlattenBT2Linkedlist {

    public TreeNode flatten(TreeNode a) {
        TreeNode result = new TreeNode(0);
        TreeNode node = result;

        if(a == null)
            return null;

        Stack<TreeNode> stack =  new Stack<TreeNode>();
        stack.push(a);

        while(!stack.isEmpty()){
            TreeNode popped = stack.pop();

            node.right = popped;
            node.left = null;
            node = node.right;

            if(popped.right != null)
                stack.push(popped.right);
            if(popped.left != null)
                stack.push(popped.left);
        }
        return result.right;
    }
    public static void main(String args[]) {

        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.left.left = new TreeNode(3);
        tree.left.right = new TreeNode(4);

        tree.right = new TreeNode(5);
        tree.right.right = new TreeNode(6);

        TreeNode result = new FlattenBT2Linkedlist().flatten(tree);

        while(result!= null) {
            System.out.println(result.val);
            System.out.println( "\\");

            result = result.right;
        }
    }

    // From Solution
    TreeNode head=new TreeNode(0);
    TreeNode cur=head;
    public TreeNode flatten1(TreeNode a) {
        //preorder traversal
        preorder(a);
        return head.right;
    }
    public void preorder(TreeNode a){
        if(a==null){
            return;
        }
        cur.right=new TreeNode(a.val);
        cur=cur.right;
        preorder(a.left);
        preorder(a.right);
    }
}