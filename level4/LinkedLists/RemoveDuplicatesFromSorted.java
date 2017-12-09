package com.dr.level4.LinkedLists;
/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
*/
public class RemoveDuplicatesFromSorted {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     public int val;
     *     public ListNode next;
     *     ListNode(int x) { val = x; next = null; }
     * }
     */

    ListNode deleteDuplicates(ListNode a) {

        ListNode curr = a;
        ListNode prev, next;

        prev = curr;
        next = curr.next;

        while(next!=null) {

            if(prev.val == next.val) {
                ListNode tempNext = next.next;

                if(tempNext!=null) {

                    while (tempNext != null) {
                        if (prev.val == tempNext.val) {

                            tempNext = tempNext.next;

                            if(tempNext==null) {
                                prev.next = tempNext;
                                next = tempNext;
                                break;

                            }

                        } else {

                            prev.next = tempNext;
                            next = tempNext.next;
                            prev = prev.next;
                            break;
                        }
                    }
                }
                else {
                    prev.next = tempNext;
                    next = tempNext;
                }
            } else {
                prev = prev.next;
                next = next.next;

            }

        }
        return a;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(1);
        a.next.next = new ListNode(1);
        a.next.next.next = new ListNode(3);
        a.next.next.next.next = new ListNode(3);

        ListNode result = new RemoveDuplicatesFromSorted().deleteDuplicates(a);
        ListNode result1 = new RemoveDuplicatesFromSorted().deleteDuplicates1(a);

        while (result1 != null) {
            System.out.println(result1.val);
            result1  = result1.next;
        }
    }

    // Solution
    public ListNode deleteDuplicates1(ListNode a) {
        ListNode current = a;
        while (current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            }
            else {
                current = current.next;
            }
        }
        return a;
    }

}