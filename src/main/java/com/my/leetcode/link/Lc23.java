package com.my.leetcode.link;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: whgong
 * @description:
 * @create: 2020/7/23 20:50
 */

public class Lc23 {


    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null || lists.length == 0){
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if(o1.val < o2.val){
                    return -1;
                }else if(o1.val == o2.val) {
                    return 0;
                }else{
                    return 1;
                }
            }
        });

        for (ListNode listNode : lists){
            if(listNode != null){
                pq.add(listNode);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode p = dummy.next;
        while (!pq.isEmpty()){
            p.next = pq.poll();
            p = p.next;
            if(p.next!=null){
                pq.offer(p.next);
            }
        }
        return dummy.next;

    }
}
