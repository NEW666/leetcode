package com.my.leetcode.bytedance;

/**
 * 124. 二叉树中的最大路径和
 * 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出: 6
 * 示例 2:
 *
 * 输入: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出: 42
 */

public class Lc124 {

    public int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        maxValue(root);
        return max;
    }

    int max = Integer.MIN_VALUE;

    public int maxValue(TreeNode root){

        if(root == null){
            return 0;
        }

        int leftMax = Math.max(maxValue(root.left),0);
        int rightMax = Math.max(maxValue(root.right),0);

        int newPathValue = root.val + leftMax + rightMax;

        max = Math.max(max,newPathValue);

        return root.val + Math.max(leftMax,rightMax);

    }

}
