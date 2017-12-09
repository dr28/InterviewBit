package com.dr.level4.LinkedLists;

/*Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Try solving it using constant additional space.

Example :

Input :

                  ______
                 |     |
                 \/    |
        1 -> 2 -> 3 -> 4

Return the node corresponding to node 3. */
public class ListCycle {
    public ListNode detectCycle(ListNode a) {

        ListNode slow = a;
        ListNode fast = a;
        Boolean cycleDetected = false;
        while(fast!= null && fast.next!= null && slow != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                cycleDetected = true;
                break;
            }

        }

        if(cycleDetected) {
            fast = a;
            while (fast.next != null && slow.next != null) {

                if(slow == fast) {
                    slow.next=null;
                    return slow;
                }

                slow = slow.next;
                fast = fast.next;

            }
        }

        return null;

    }

    public static void main(String[] args) {

        ListNode a = new ListNode(10);
        a.next = new ListNode(20);
        a.next.next = new ListNode(30);

        a.next.next.next = new ListNode(40);

        a.next.next.next.next = new ListNode(50);
        a.next.next.next.next.next = new ListNode(60);
        a.next.next.next.next.next.next = a.next.next.next;

        ListNode result = new ListCycle().detectCycle(a);

        while (result != null) {
            System.out.print(result.val+" ");
            result  = result.next;
        }
    }



}
