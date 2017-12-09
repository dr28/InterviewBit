package com.dr.level4.LinkedLists;
/*Given a list, rotate the list to the right by k places, where k is non-negative.

        For example:

        Given 1->2->3->4->5->NULL and k = 2,
        return 4->5->1->2->3->NULL.*/
public class RotateList {

    public ListNode rotateRight1(ListNode a, int b) {

        ListNode temp = a;
        ListNode head = a;
        ListNode newHead = a;
        ListNode prev = null;
        int totalSize = 0;
        while(temp != null) {
            temp = temp.next;
            totalSize++;
        }

        // To reduce many rotations
        if(b != 0) {
            b = b % totalSize;
        }


        if(b == 0) {
            return newHead;
        }
        // To get the distance of the node to be moved from the head position.
        // b value currently contains the distance of the node from the back position.
        b = totalSize - b;
        temp = a;
        while(temp != null && b!=0) {
            b--;
            prev = temp;
            temp = temp.next;
        }

        if(prev == null) {
            return a;
        }

        prev.next = null;
        newHead = temp;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;

        return newHead;
    }

    ListNode rotateRight(ListNode a, int b) {


        if (a==null || b==0) {return a;}

        ListNode p = a;
        int len=0;
        //get total length
        while (p!= null){
            len++;
            p=p.next;
        }
        //get rotate position
        int r;
        System.out.println("b%len "+ b%len);

        if (b%len==0){
            return a;
        }else{
            r = len-(b%len)-1;
        }
        p=a;
        while (r>0){
            p=p.next;
            r--;
        }


        //cut current list, link the back to the front
        ListNode q =p.next;
        if (q== null){return a;}
        while (q.next!= null){
            q=q.next;
        }
        q.next = a;
        q=p.next;
        p.next = null;

        return q;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(10);
        a.next = new ListNode(20);
        a.next.next = new ListNode(30);

        a.next.next.next = new ListNode(40);

        a.next.next.next.next = new ListNode(50);
        a.next.next.next.next.next = new ListNode(60);
        int [] a1 = {23, 57, 65, 90, 56,69,77,52,71,74,15,25,41,17,76,95,58,38,29,68,4,89,55,99,13,92,98,62,36,59,54,48,53,12,11,6,2,35,46,39,20,27,44,78,82,67,91,64,97,43,84,83,70,73,79,88,16,1,96,66,80,72,10,19,100,33,75,3,81,24,22,87,63,9,7,40,8,34,101,60,28};
        ListNode b = new ListNode(0);

        b.val = a1[0];
        ListNode current = b;

        for (int i = 1; i < a1.length; i++) {
            ListNode node = new ListNode(a1[i]);
            current.next = node;
            current = node;

        }
        int k = 20;
        ListNode result = new RotateList().rotateRight(a, 7);

        while (result != null) {
            System.out.print(result.val+" ");
            result  = result.next;
        }
    }
}
