package com.my.leetcode.bytedance;

import com.my.leetcode.link.ListNode;

public class Lc143 {

    public void reorderList(ListNode head) {
        if(head == null){
            return;
        }

        ListNode midListNode = findMidListNode(head);

        ListNode rightListNode = midListNode.next;

        ListNode leftListNode = head;
        midListNode.next = null;

        rightListNode = reverseListNode(rightListNode);

        merge(leftListNode,rightListNode);

    }


    public ListNode findMidListNode(ListNode head){

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseListNode(ListNode head){

        if(head == null || head.next == null){
            return head;
        }
        ListNode last = reverseListNode(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public void merge(ListNode left,ListNode right){
        ListNode leftTemp;
        ListNode rightTemp;

        while (left.next != null && right != null){

            leftTemp = left.next;
            rightTemp = right.next;

            left.next = right;
            right.next = leftTemp;

            left = leftTemp;
            right = rightTemp;
        }
    }





}
