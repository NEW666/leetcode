package com.my.leetcode.string;

/**
 * @author: whgong
 * @description:
 * @create: 2020/7/16 20:33
 */

public class Lc1281 {
    public int subtractProductAndSum(int n) {

        int sum = 0, mix = 1;
        while (n > 0){
            int num = n%10;
            sum += num;
            mix *= num;
            n = n/10;
        }
        return mix - sum;

    }
}
