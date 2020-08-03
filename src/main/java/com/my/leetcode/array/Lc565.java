package com.my.leetcode.array;

/**
 * @author: whgong
 * @description:
 * @create: 2020/7/11 16:27
 */

public class Lc565 {

    public int arrayNesting(int[] nums) {
        int len = nums.length;
        int start = 0;
        int res = 0;
        for (int i = 0; i < len; i++) {
            if(nums[i] != Integer.MAX_VALUE){
                start = nums[i];
                int count = 0;
                while (nums[start] != Integer.MAX_VALUE){
                    int temp = start;
                    start = nums[start];
                    count++;
                    nums[temp] = Integer.MAX_VALUE;
                }

                res = Math.max(res,count);
            }

        }
        return res;

    }
}
