package com.my.leetcode.bytedance;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 200. 岛屿数量
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 */
public class Lc200 {

  /*  int nc = 0 ;
    int nr = 0 ;

    public int numIslands(char[][] grid) {

        if(grid.length == 0 || grid == null){
            return 0;
        }

        nr = grid.length;
        nc = grid[0].length;
        int numOfIsland = 0;
        for (int i = 0; i < nr ; i++) {
            for (int j = 0; j < nc; j++) {
                if(grid[i][j] == '1'){
                    numOfIsland++;
                    dfs(grid,i,j);
                }

            }

        }
        return numOfIsland;

    }


    public void dfs(char[][] gird,int r,int c){
        if( r >= nr || c >= nc || r < 0 || c < 0 || gird[r][c] == '0' ){
            return;
        }
        gird[r][c] = '0';
        dfs(gird,r+1,c);
        dfs(gird,r-1,c);
        dfs(gird,r,c+1);
        dfs(gird,r,c-1);
    }*/


    /**
     * 广度优先搜索
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid == null){
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int numOfIsland = 0;

        for (int i = 0; i < nr ; i++) {
            for (int j = 0; j < nc ; j++) {
                if(grid[i][j] == '1'){
                     numOfIsland++;
                     grid[i][j] = '0';
                    Queue<Integer> brand = new LinkedList<>();
                    brand.add(i * nc + j);
                    while (!brand.isEmpty()){
                        int id = brand.remove();
                        int row = id / nc;
                        int col = id % nc;
                        if (row - 1 >= 0 && grid[row-1][col] == '1') {
                            brand.add((row-1) * nc + col);
                            grid[row-1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row+1][col] == '1') {
                            brand.add((row+1) * nc + col);
                            grid[row+1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col-1] == '1') {
                            brand.add(row * nc + col-1);
                            grid[row][col-1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col+1] == '1') {
                            brand.add(row * nc + col+1);
                            grid[row][col+1] = '0';
                        }

                    }
                }


            }

        }

        return numOfIsland;

    }






}
