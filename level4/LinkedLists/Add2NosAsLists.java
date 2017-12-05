package com.dr.level4.LinkedLists;
/*You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

    342 + 465 = 807
Make sure there are no trailing zeros in the output list
So, 7 -> 0 -> 8 -> 0 is not a valid response even though the value is still 807.*/
public class Add2NosAsLists {


    public ListNode addTwoNumbers(ListNode a, ListNode b) {
        int carry = 0;
        ListNode result = new ListNode(0);
        ListNode node = result;
        while (a!= null || b!= null || carry>0) {
            int value1 = 0;
            int value2 = 0;

            if(a!=null) {
                value1 = a.val;
                a = a.next;
            }
            if(b!=null) {
                value2 = b.val;
                b = b.next;
            }

            int sum = value1 + value2+carry;
            node.next = new ListNode(sum%10);
            carry = sum/10;
            node = node.next;
        }

        return result.next;
    }


    public static void main(String[] args) {
        ListNode a = new ListNode(2);
        a.next = new ListNode(4);
        a.next.next = new ListNode(3);

        ListNode b = new ListNode(5);
        b.next = new ListNode(6);
        b.next.next = new ListNode(4);
       // System.out.println(a.val); System.out.println(a.next.val); System.out.println(a.next.next.val);
       // System.out.println(b.val); System.out.println(b.next.val); System.out.println(b.next.next.val);

        System.out.println(new Add2NosAsLists().addTwoNumbers(a, b));
    }

}
/**
 * Definition for singly-linked list.
 */
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}
