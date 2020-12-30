package com.my.leetcode.dp;

/**
 * @author ：wh.gong
 * @date ：Created in 2020/12/26 17:21
 * @description：
 */
public class Jzo42 {

    public int maxSum = 0;
    public int[] anums;

    public int maxSubArray(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        anums = nums;
        maxSum = nums[0];
        dp(1);
        return maxSum;
    }

    public void dp(int l){
        if(l >= anums.length){
            return;
        }
        anums[l] += Math.max(anums[l-1],0);
        maxSum = Math.max(maxSum, anums[l]);
        dp(l+1);
    }


    public static void main(String[] args) {
        Jzo42 jzo42 = new Jzo42();
        int[] a = {-2,-1};
        jzo42.maxSubArray(a);
    }


}
