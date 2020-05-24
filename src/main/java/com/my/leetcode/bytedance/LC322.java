package com.my.leetcode.bytedance;


import java.util.Arrays;

/**
 * 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 */
public class LC322 {

    public static void main(String[] args) {
        LC322 lc322 = new LC322();
        int[]  coins = {1, 2};
        System.out.println(lc322.coinChange(coins,3));
    }

    public int coinChange(int[] coins, int amount) {
        if(amount < 0){
            return -1;
        }
        return coinChange(coins,amount,new int[amount]);
    }

    public int coinChange(int[] coins, int amount ,int[] count){
        if(amount == 0 ){
            return 0;
        }
        if(amount < 0){
            return -1;
        }
        if(count[amount-1] != 0){
            return count[amount-1];
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins){
            int res = coinChange(coins,amount-coin,count);
            if(res >= 0 && res < min){
                min = res + 1;
            }
        }
        count[amount-1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[amount-1];
    }

}
