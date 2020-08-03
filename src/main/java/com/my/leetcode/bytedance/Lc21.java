package com.my.leetcode.bytedance;

import com.my.leetcode.link.ListNode;

/**
 * @author: whgong
 * @description:
 * @create: 2020/6/11 11:17
 */

public class Lc21 {

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        if(l1.val < l2.val){
            l1.next = mergeTwoLists1(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists1(l1,l2.next);
            return l2;
        }
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode preHead = new ListNode(0);

        ListNode dummyNode = preHead;

        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                dummyNode.next = l1;
                l1 = l1.next;
            }else {
                dummyNode.next = l2;
                l2 = l2.next;
            }
            dummyNode = dummyNode.next;
        }

        dummyNode.next = l1 == null? l2:l1;


        return preHead.next;

    }


}
