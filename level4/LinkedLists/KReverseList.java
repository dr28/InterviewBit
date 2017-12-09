package com.dr.level4.LinkedLists;

/*Given a singly linked list and an integer K, reverses the nodes of the

        list K at a time and returns modified linked list.

        NOTE : The length of the list is divisible by K
        Example :

        Given linked list 1 -> 2 -> 3 -> 4 -> 5 -> 6 and K=2,

        You should return 2 -> 1 -> 4 -> 3 -> 6 -> 5

        Try to solve the problem using constant extra space.*/
public class KReverseList {

    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     public int val;
     *     public ListNode next;
     *     ListNode(int x) { val = x; next = null; }
     * }
     */

    public ListNode reverseList(ListNode A, int B) {

        int x = B;
        ListNode next = null;
        ListNode h = A;
        ListNode prev = null;
        while (h != null && x > 0) {
            next = h.next;
            h.next = prev;
            prev = h;
            h = next;
            x--;
        }
        if (next != null) {
            A.next = reverseList(next, B);
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(4);
        a.next.next.next.next = new ListNode(5);
        a.next.next.next.next.next = new ListNode(6);

        int b = 2;

        ListNode result = new KReverseList().reverseList(a, b);
        while (result != null) {
            System.out.println(result.val);
            result  = result.next;
        }
    }
}