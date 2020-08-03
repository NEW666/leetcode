package com.my.leetcode.dp;

/**
 * @author: whgong
 * @description:
 * @create: 2020/7/11 12:10
 */

public class Lc416 {

    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return false;
        }

        int sum = 0;
        for (int a : nums){
            sum += a;
        }
        if(sum%2 != 0){
            return false;
        }
        int target = sum/2;
        boolean[] dp = new boolean[target+1];

        dp[0] = true;
        if(nums[0]<=target){
            dp[nums[0]] = true;
        }

        for (int i = 1; i < len; i++) {
            for (int j = target; nums[i] <= j; j--) {
                if(dp[target]){
                    return true;
                }
                dp[j] = dp[j] || dp[j-nums[i]];
            }
        }

        return dp[target];
    }
}
