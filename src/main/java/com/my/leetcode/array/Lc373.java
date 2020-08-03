package com.my.leetcode.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author: whgong
 * @description:
 * @create: 2020/7/23 19:44
 */

public class Lc373 {


    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        List<List<Integer>> res = new ArrayList<>();
        if(k == 0 || len1 == 0 || len2 == 0){
            return res;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> (nums1[o1[0]]+nums2[o1[1]])-(nums1[o2[0]]+nums2[o2[1]]));
        for (int i = 0; i < len1; i++) {
            queue.offer(new int[]{i,0});
        }

        while (!queue.isEmpty() && k > 0){

            int[] cur = queue.poll();

            if(cur[1]+1 < len2){
                queue.offer(new int[]{cur[0],cur[1]+1});
            }

            List<Integer> val = new ArrayList<>();
            val.add(nums1[cur[0]]);
            val.add(nums2[cur[1]]);
            res.add(val);
            k--;
        }
        return res;
    }
}
