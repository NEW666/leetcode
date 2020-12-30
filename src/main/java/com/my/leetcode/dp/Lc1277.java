package com.my.leetcode.dp;

public class Lc1277 {

    public int countSquares(int[][] matrix) {

        int row = matrix.length;

        int col = matrix[0].length;

        int[][] dp = matrix;

        int res = 0;

        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {

                if(dp[i][j] == 1){
                    if(i > 0 && j > 0){
                        dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]) + 1;
                    }

                    res += dp[i][j];

                }
            }

        }

        return res;

    }
}
