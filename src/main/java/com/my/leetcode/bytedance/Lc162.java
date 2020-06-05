package com.my.leetcode.bytedance;

/**
 * @author: whgong
 * @description:
 * @create: 2020/5/30 12:01
 */

public class Lc162 {

    public int findPeakElement(int[] nums) {
        return halfTwoSearch(nums,0,nums.length-1);
    }

    public int halfTwoSearch(int[] nums, int left,int right){
        if(left == right){
            return left;
        }
        int mid = (left + right)/2;
        if(nums[mid] > nums[mid+1]){
            return halfTwoSearch(nums,left,mid);
        }
         return  halfTwoSearch(nums,mid+1,right);
    }
}
