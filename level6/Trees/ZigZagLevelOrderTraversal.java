package com.dr.level6.Trees;

import java.util.ArrayList;
import java.util.Stack;

/*Given a binary tree, return the zigzag level order traversal of its nodes’ values. (ie, from left to right, then right to left for the next
level and alternate between).

 Example :
 Given binary tree

    3
   /\
  9  20
 /    \
15     7
 return

 [
 [3],
 [20, 9],
 [15, 7]
 ]*/
public class ZigZagLevelOrderTraversal { //Also called as spiral order

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode a) {
        ArrayList result = new ArrayList();

        if (a == null) {
            return result;
        }

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(a);
        ArrayList temp = new ArrayList();
        temp.add(a.val);
        result.add(temp);

        while (!s1.isEmpty() || !s2.isEmpty()) {
            temp = new ArrayList();
            while (!s1.isEmpty()) {
                a = s1.pop();

                if (a.left != null) {
                    s2.push(a.left);
                    temp.add(0,a.left.val);
                }

                if (a.right != null) {
                    s2.push(a.right);
                    temp.add(0,a.right.val);
                }
            }
            if(!temp.isEmpty())
                result.add(temp);
            temp = new ArrayList();

            while (!s2.isEmpty()) {
                a = s2.pop();

                if (a.right != null) {
                    s1.push(a.right);
                    temp.add(0,a.right.val);
                }

                if (a.left != null) {
                    s1.push(a.left);
                    temp.add(0,a.left.val);
                }
            }
            if(!temp.isEmpty())
                result.add(temp);

        }
        return result;
    }

    public static void main(String args[]) {

        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.left.left = new TreeNode(15);
        tree.right = new TreeNode(20);
        tree.right.right = new TreeNode(7);

        System.out.println(new ZigZagLevelOrderTraversal().zigzagLevelOrder(tree));
    }
}