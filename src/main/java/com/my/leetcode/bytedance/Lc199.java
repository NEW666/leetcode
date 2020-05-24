package com.my.leetcode.bytedance;

import javax.swing.tree.TreeNode;
import java.util.*;


/**
 * 199. 二叉树的右视图
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 */
public class Lc199 {

    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
    }

    public List<Integer> dfs(TreeNode root) {
        Map<Integer,Integer> rightNodeToSee = new HashMap<>();
        int maxDepth = -1;

        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> nodeDepth = new Stack<>();
        nodeStack.push(root);
        nodeDepth.push(0);

        while (!nodeDepth.isEmpty()){
            TreeNode treeNode = nodeStack.pop();
            int depth = nodeDepth.pop();

            if(treeNode != null){
                maxDepth = Math.max(depth,maxDepth);
                if(!rightNodeToSee.containsKey(depth)){
                    rightNodeToSee.put(depth,treeNode.val);
                }
                nodeStack.push(treeNode.left);
                nodeStack.push(treeNode.right);
                nodeDepth.push(depth+1);
                nodeDepth.push(depth+1);
            }
        }

        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i <= maxDepth; i++) {
            nums.add(rightNodeToSee.get(i));
        }

        return nums;
    }

    public List<Integer> bfs(TreeNode root){
        Map<Integer,Integer> rightNodeToSee = new HashMap<>();

        int maxDepth = -1;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> depthQueue = new LinkedList<>();
        nodeQueue.add(root);
        depthQueue.add(0);


        while (!nodeQueue.isEmpty()){
            TreeNode node = nodeQueue.remove();
            int depth = depthQueue.remove();

            if(node != null){
                maxDepth = Math.max(maxDepth,depth);
                rightNodeToSee.put(depth,node.val);
                nodeQueue.add(node.left);
                nodeQueue.add(node.right);
                depthQueue.add(depth+1);
                depthQueue.add(depth+1);
            }
        }


        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i <= maxDepth; i++) {
            nums.add(rightNodeToSee.get(i));
        }

        return nums;

    }

}
