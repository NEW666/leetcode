package com.my.leetcode.bytedance;

import java.util.ArrayList;

/**
 * 19. 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
public class Lc19 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { this.val = x;}
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode first = res;
        ListNode second = res;

        for (int i = 0; i <= n+1;i++) {
            first = first.next;
        }
        while (first!=null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return res.next;
    }
}
