package com.my.leetcode.bytedance;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
 */
public class Lc46 {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        //permute(a);
    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> output = new ArrayList<List<Integer>>();
        List<Integer> numsList = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            numsList.add(nums[i]);
        }
        dfs(nums.length,output,numsList,0);
        return output;
    }

    public void dfs(int n , List<List<Integer>> output , List<Integer> nums , int depth){
        if(depth == n){
            output.add(new ArrayList<Integer>(nums));
        }
        for (int i = depth; i < n; i++) {
            Collections.swap(nums,depth,i);
            dfs(n,output,nums,depth+1);
            Collections.swap(nums,depth,i);
        }
    }






}
