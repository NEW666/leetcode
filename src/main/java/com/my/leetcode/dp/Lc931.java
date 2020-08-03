package com.my.leetcode.dp;

/**
 * @author: whgong
 * @description:
 * @create: 2020/7/24 20:22
 */

public class Lc931 {

    public int minFallingPathSum(int[][] A) {
        int len = A.length;
        int best = 0;
        for (int i = len-2; i >= 0 ; --i) {
            for (int j = 0; j < len; j++) {
                best = A[i+1][j];
                if(j>0){
                    best = Math.min(best,A[i+1][j-1]);
                }
                if(j+1 < len){
                    best = Math.min(best,A[i+1][j+1]);
                }
                A[i][j] +=best;
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int x : A[0]){
            ans = Math.min(x,ans);
        }
        return ans;
    }
}
