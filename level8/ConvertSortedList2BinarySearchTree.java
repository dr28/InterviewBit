package com.dr.level8;

import java.util.LinkedList;
import java.util.Queue;

/*Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

 A height balanced BST : a height-balanced binary tree is defined as a binary tree in which the depth of the two
 subtrees of every node never differ by more than 1.
Example :


Given A : 1 -> 2 -> 3
A height balanced BST  :

      2
    /   \
   1     3
*/
public class ConvertSortedList2BinarySearchTree {
    //( O(nlogn) ) (top to bottom)
    public TreeNode sortedListToBST(ListNode a) {
        if(a == null)
            return null;

        return toBst(a, null);
    }

    TreeNode toBst(ListNode head, ListNode tail) {
        if(head == tail)
            return null;

        ListNode slow = head, fast = head;

        while(fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }

        TreeNode root = new TreeNode(slow.val);

        root.left = toBst(head, slow);
        root.right = toBst(slow.next, tail);

        return root;
    }

    //( O(n) )
    int cnt(ListNode head) {
        int sz = 0;
        while(head != null) {
            sz++;
            head = head.next;
        }
        return sz;
    }

    ListNode list;

    TreeNode toBst(int n) {
        if(n == 0)
            return null;

        TreeNode root = new TreeNode(0);

        root.left = toBst(n/2);

        root.val = list.val;
        list = list.next;

        root.right = toBst(n - n/2 - 1);

        return root;
    }

    public TreeNode sortedListToBST1(ListNode a) {
        if(a == null)
            return null;
        list = a;
        return toBst(cnt(a));
    }

    public static void main(String args[]) {

        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);

        TreeNode result = new ConvertSortedList2BinarySearchTree().sortedListToBST(a);
        Queue q = new LinkedList();
        q.add(result);
        while (!q.isEmpty()) {
            TreeNode node = (TreeNode) q.poll();

            System.out.println(node.val);

            if (node.left != null)
                q.add(node.left);


            if (node.right != null)
                q.add(node.right);

        }

        result = new ConvertSortedList2BinarySearchTree().sortedListToBST1(a);

        q = new LinkedList();
        q.add(result);
        while (!q.isEmpty()) {
            TreeNode node = (TreeNode) q.poll();

            System.out.println(node.val);

            if (node.left != null)
                q.add(node.left);

            if (node.right != null)
                q.add(node.right);
            
        }

    }
}
/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/// Definition for singly-linked list.
 class ListNode {
     public int val;

     public ListNode next;

     ListNode(int x) { val = x; next = null; }
 }

