package com.dr.level4.LinkedLists;
/*Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.*/

/*The idea is:   first get the last element and the length of the list (1 while loop)
                 Then scan the whole list, if current node value < x, then go to the next node.
                 if current node value >=x, then move this node to the end of the list.
                 until  meet the length of the original list.
*/
public class PartitionList {

    public ListNode partition(ListNode a, int b) {

        ListNode p = new ListNode(0);
        p.next = a;
        a = p; // used to save the result head.

        ListNode last = a; // used to get the last node

        if (a == null) return null;
        if (a.next== null) return a.next;

        int n=0; //length of the list
        while (last.next!=null) {
            last=last.next;
            n++;
        } //get the length and last node

        while (n>0){ // in case  of non-stop loop, count n.

            if (p.next.val < b){ // val<b keep the node

                p=p.next;
                n--;
            } else { // val>=b move to last

                last.next = new ListNode(p.next.val); // add node to the last
                last = last.next;
                p.next = p.next.next; //delete current node
                n--;
            }
        }

        return a.next; //the 1st node is elmininated
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(4);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(2);
        a.next.next.next.next = new ListNode(5);
        a.next.next.next.next.next = new ListNode(2);

        int b = 3;

        ListNode result = new PartitionList().partition(a, b);
        while (result != null) {
            System.out.println(result.val);
            result  = result.next;
        }

    }
}
