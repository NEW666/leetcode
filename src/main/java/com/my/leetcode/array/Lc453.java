package com.my.leetcode.array;

import java.util.Arrays;

/**
 * @author: whgong
 * @description:
 * @create: 2020/7/11 15:32
 */

public class Lc453 {

    public int minMoves(int[] nums) {

        int count = 0;
        Arrays.sort(nums);
        for (int i = nums.length; i > 0 ; i--) {
            count += nums[i] - nums[0];
        }
        return nums[0];

    }
}
