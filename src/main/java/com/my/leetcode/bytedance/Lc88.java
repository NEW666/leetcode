package com.my.leetcode.bytedance;

/**
 * @author: whgong
 * @description:
 * @create: 2020/6/11 11:47
 */

public class Lc88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int p1 = m-1;
        int p2 = n-1;

        int p = n + m - 1;

        while ( p1 >= 0 && p2 >= 0){
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--]:nums1[p1--];
        }

        System.arraycopy(nums2,0,nums1,0,p2+1);

    }
}
