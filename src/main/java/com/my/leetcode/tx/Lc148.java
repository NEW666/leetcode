package com.my.leetcode.tx;

public class Lc148 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode sortList(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = slow.next;

        while (slow != null && fast != null){
            slow = slow.next;
            fast =  fast.next;
        }

        ListNode tmp = slow.next;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left !=null && right != null){
            if(left.val < right.val){
                h.next = left;
                left = left.next;
            }else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left:right;

        return res.next;
    }


}
