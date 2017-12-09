package com.dr.level4.LinkedLists;
/*Given a singly linked list

    L: L0 → L1 → … → Ln-1 → Ln,
reorder it to:

    L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
You must do this in-place without altering the nodes’ values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.*/
public class ReorderLinkedList {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     public int val;
     *     public ListNode next;
     *     ListNode(int x) { val = x; next = null; }
     * }
     */

    ListNode reorderList (ListNode a) {
        //get middle of list, if even elements take the second middle
        ListNode slow = a;
        ListNode fast = slow;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode node1 = a;
        ListNode node2 = slow.next;
        slow.next = null;

        //reverse second half of the list
        node2 = reverseList(node2);

        a = new ListNode(0);
        ListNode curr = a;

        while (node1!=null || node2!=null) {

            if(node1!=null) {
                curr.next = node1;
                curr = curr.next;
                node1 = node1.next;
            }

            if(node2!=null) {
                curr.next = node2;
                curr = curr.next;
                node2 = node2.next;
            }
        }

        return a.next;

    }

    ListNode reverseList (ListNode a) {

        ListNode current = a;
        ListNode prev = null;
        ListNode next = null;

        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        a = prev;
        return a;
    }


    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(4);
        //a.next.next.next.next = new ListNode(5);

        ListNode result = new ReorderLinkedList().reorderList(a);

        while (result != null) {
            System.out.println(result.val);
            result  = result.next;
        }

    }
}
