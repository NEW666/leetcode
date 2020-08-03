package com.my.leetcode.bytedance;

/**
 * @author: whgong
 * @description:
 * @create: 2020/6/29 19:37
 */

public class Lc416 {

    public boolean canPartition(int[] nums) {

        int target = 0;
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        if(target%2 != 0){
            return false;
        }
        target = sum/2;

        int aSum = 0;
        boolean left = false;
        for (int i = 0; i < len; i++) {
            if((aSum+nums[i]) <= target){
                aSum += nums[i];
            }else {
                left = true;
            }
            if(aSum == target && left){
                return true;
            }

        }

        return false;

    }

    public static void main(String[] args) {
        Lc416 lc416 = new Lc416();
        int[] nums = new int[]{1,5,11,5};
        lc416.canPartition(nums);
    }
}
