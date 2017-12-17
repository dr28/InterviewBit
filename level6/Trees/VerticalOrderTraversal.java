package com.dr.level6.Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


/*Given a binary tree, print a vertical order traversal of it.

Example :
Given binary tree:

      6
    /   \
   3     7
  / \     \
 2   5     9
returns

[
    [2],
    [3],
    [6 5],
    [7],
    [9]
]

Note : If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.

See Expected Output

*/
class ListNode<E> {

    public E val;
    public ListNode next;
    ListNode(E x) { val = x; next = null; }

    @Override
    public String toString() {
        return val + (next != null ? " -> " + next : "");
    }
}

public class VerticalOrderTraversal {

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();

        if(A==null)
            return a;

        HashMap<Integer, ArrayList> map = new HashMap<Integer, ArrayList>();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<Integer> levels = new LinkedList<Integer>();

        queue.offer(A);
        levels.offer(0);

        int level = 0;
        int min = 0;
        int max = 0;


        while(!queue.isEmpty()) {

            TreeNode curNode = queue.poll();
            level = levels.poll();

            //track min and max levels
            min = Math.min(min, level);
            max = Math.max(max, level);

            if (map.containsKey(level)) {
                ArrayList temp = map.get(level);
                temp.add(curNode.val);

                map.put(level, temp);
            } else {
                ArrayList temp =new ArrayList();
                temp.add(curNode.val);

                map.put(level, temp);
            }

            if (curNode.left != null) {
                queue.offer(curNode.left);
                levels.offer(level - 1);
            }

            if (curNode.right != null) {
                queue.offer(curNode.right);
                levels.offer(level + 1);
            }

        }

        for(int i=min; i<=max; i++) {

            if(map.containsKey(i))
                a.add(map.get(i));

        }
        return a;
    }

    public static void main(String args[]) {
        TreeNode tree = new TreeNode(6);
        tree.left = new TreeNode(3);
        tree.left.left = new TreeNode(2);
        tree.left.right = new TreeNode(5);

        tree.right = new TreeNode(7);
        tree.right.right = new TreeNode(9);

        System.out.println(new VerticalOrderTraversal().verticalOrderTraversal(tree));
    }

}