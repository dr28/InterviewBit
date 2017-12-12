package com.dr.level6.Trees;

import java.util.ArrayList;
import java.util.Stack;

/*Given a binary tree, return the inorder traversal of its nodes’ values.

Example :
Given binary tree

   1
    \
     2
    /
   3
return [1,3,2].

Using recursion is not allowed.*/

public class InorderTraversal {
    /* 1) Create an empty stack S.
       2) Initialize current node as root
       3) Push the current node to S and set current = current->left until current is NULL
       4) If current is NULL and stack is not empty then
        a) Pop the top item from stack.
        b) Print the popped item, set current = popped_item->right
        c) Go to step 3.
       5) If current is NULL and stack is empty then we are done.*/
    public ArrayList<Integer> inorderTraversal(TreeNode a) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(a == null)
            return result;

        TreeNode node = a;

        //Go all the way to the left and then pop and add the val and then go to the right
        while(!stack.isEmpty() || node != null){
            if(node != null){
                stack.push(node);
                node = node.left;
            }
            else{
                node = stack.pop();
                result.add(node.val);
                node = node.right;
            }
        }
        return result;
    }

    /* 1. Initialize current as root
       2. While current is not NULL
            If current does not have left child
            a) Print current’s data
            b) Go to the right, i.e., current = current->right
            Else
            a) Make current as right child of the rightmost node in current's left subtree
            b) Go to this left child, i.e., current = current->left
    */

    /* Function to traverse binary tree without recursion and without stack */
    /* no extra space is required for this traversal */
    ArrayList<Integer> MorrisTraversal(TreeNode a) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        TreeNode current, pre;

        if (a == null)
            return result;

        current = a;
        while (current != null) {
            if (current.left == null) {
                result.add(current.val);


                //System.out.print(current.val + " ");
                current = current.right;
            } else {
                /* Find the inorder predecessor of current */
                pre = current.left;
                while (pre.right != null && pre.right != current)
                    pre = pre.right;

                /* Make current as right child of its inorder predecessor */
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                }

                 /* Revert the changes made in if part to restore the
                    original tree i.e.,fix the right child of predecssor*/
                else {
                    pre.right = null;
                    result.add(current.val);

                    //System.out.print(current.val + " ");
                    current = current.right;
                }   /* End of if condition pre->right == NULL */

            } /* End of if condition current->left == NULL*/

        } /* End of while */
        return result;

    }
    public static void main(String args[])
    {

        /* Constructed binary tree is
                   1
                 /   \
                2      3
              /  \    /
            4     5  6
            /
           7         */
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.left.left.left = new TreeNode(7);
        tree.right = new TreeNode(3);
        tree.right.left = new TreeNode(6);

        System.out.println("Tree -- "+new InorderTraversal().inorderTraversal(tree));
        System.out.println("Morris -- "+new InorderTraversal().MorrisTraversal(tree));

    }
}
