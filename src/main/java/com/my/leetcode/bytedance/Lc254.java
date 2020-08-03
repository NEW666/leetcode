package com.my.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * 254. 因子的组合
 * 整数可以被看作是其因子的乘积。
 *
 * 例如：
 *
 * 8 = 2 x 2 x 2;
 *   = 2 x 4.
 * 请实现一个函数，该函数接收一个整数 n 并返回该整数所有的因子组合。
 *
 * 注意：
 *
 * 你可以假定 n 为永远为正数。
 * 因子必须大于 1 并且小于 n。
 * 示例 1：
 *
 * 输入: 1
 * 输出: []
 * 示例 2：
 *
 * 输入: 37
 * 输出: []
 * 示例 3：
 *
 * 输入: 12
 * 输出:
 * [
 *   [2, 6],
 *   [2, 2, 3],
 *   [3, 4]
 * ]
 */

public class Lc254 {

    public List<List<Integer>> getFactors(int n) {

        return dfs(2,n);

    }

    public List<List<Integer>> dfs(int start,int num){

        if(num == 1){
            return new ArrayList<>();
        }

        int qNum = (int) Math.sqrt(num);
        List<List<Integer>> res = new ArrayList<>();
        for (int mulNum = start; mulNum <= qNum; mulNum++) {//必须小于等于
            if(num%mulNum == 0){
                List<Integer> samp = new ArrayList<>();
                samp.add(mulNum);
                samp.add(num/mulNum);
                res.add(samp);
                List<List<Integer>> nextList = dfs(mulNum,num/mulNum);
                for (List list:nextList){
                    list.add(mulNum);
                    res.add(list);
                }
            }
        }
        return res;
    }


}
