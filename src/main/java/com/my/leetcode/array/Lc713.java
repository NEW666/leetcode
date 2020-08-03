package com.my.leetcode.array;

/**
 * @author: whgong
 * @description:
 * @create: 2020/7/16 20:02
 */

public class Lc713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1){
            return 0;
        }
        int ans = 0;
        int left = 0;
        int pro = 1;
        for (int right = 0; right < nums.length; right++) {

            pro *= nums[right];
            while (pro >= k){
                pro /= nums[left++];
            }
            ans += right - left + 1;
        }
        return ans;
    }
}
