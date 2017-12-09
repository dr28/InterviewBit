package com.dr.level4.LinkedLists;
/*Merge two sorted linked lists and return it as a new list.
The new list should be made by splicing together the nodes of the first two lists, and should also be sorted.

For example, given following linked lists :

  5 -> 8 -> 20
  4 -> 11 -> 15
The merged list should be :

4 -> 5 -> 8 -> 11 -> 15 -> 20
See Expected Output
*/
public class MergeSortedList {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     public int val;
     *     public ListNode next;
     *     ListNode(int x) { val = x; next = null; }
     * }
     */

    public ListNode mergeTwoLists(ListNode a, ListNode b) {

        ListNode result = new ListNode(0);
        ListNode temp = result;

        while(a!=null || b!=null) {
            if(a!=null && b!=null) {
                if (a.val < b.val) {
                    temp.next = a;
                    a = a.next;

                } else {
                    temp.next = b;
                    b = b.next;
                }
                temp = temp.next;

            }
            else if(a==null) {
                temp.next = b;
                break;

            }
            else if(b==null) {
                temp.next = a;
                break;
            }

        }

        return result.next;

    }
    public static void main(String[] args) {
        ListNode a = new ListNode(6);
        a.next = new ListNode(8);
        a.next.next = new ListNode(20);

        ListNode b = new ListNode(4);

        b.next = new ListNode(11);
        b.next.next = new ListNode(15);

        ListNode result = new MergeSortedList().mergeTwoLists(a,b);

        while (result != null) {
            System.out.println(result.val);
            result  = result.next;
        }
    }
}
