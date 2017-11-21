package com.dr.level4;
/*Given a singly linked list, modify the value of first half nodes such that :

1st node’s new value = the last node’s value - first node’s current value
2nd node’s new value = the second last node’s value - 2nd node’s current value,
and so on …

NOTE :
If the length L of linked list is odd, then the first half implies at first floor(L/2) nodes. So, if L = 5, the first half refers to first 2 nodes.
If the length L of linked list is even, then the first half implies at first L/2 nodes. So, if L = 4, the first half refers to first 2 nodes.
Example :

Given linked list 1 -> 2 -> 3 -> 4 -> 5,

You should return 4 -> 2 -> 3 -> 4 -> 5
as
for first node, 5 - 1 = 4
for second node, 4 - 2 = 2
Try to solve the problem using constant extra space.*/
class ListNode {

    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }

    @Override
    public String toString() {
        return val + (next != null ? " -> " + next : "");
    }
}


public class Solution {

    public ListNode subtract(ListNode A) {
        if((A == null) || (A.next == null)) return A;

        ListNode curr = A;
        ListNode revHead;
        ListNode mid = A;
        ListNode origPrev = null;
        ListNode temp;
        ListNode prev = null;

        while((curr != null) && (curr.next != null)) {
            curr = curr.next.next;
            origPrev = mid;
            mid = mid.next;
        }

        origPrev.next = null;

        curr = mid;

        while(curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        revHead = prev;

        curr = A;
        temp = revHead;

        while(curr != null){
            curr.val = (temp.val)-(curr.val);
            curr = curr.next;
            temp = temp.next;
        }

        curr = revHead;
        prev = null;

        while(curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        origPrev.next = prev;

        return A;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        list.next.next.next.next.next = new ListNode(6);
        Solution s = new Solution();
        ListNode result = s.subtract(list);

        System.out.println("result == "+result);
    }
}
