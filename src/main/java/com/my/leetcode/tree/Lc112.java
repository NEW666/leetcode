package com.my.leetcode.tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: whgong
 * @description:
 * @create: 2020/7/16 21:00
 */

public class Lc112 {

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<Integer> sumQuene = new LinkedList<>();
        queueNode.offer(root);
        sumQuene.offer(root.val);
        while (!queueNode.isEmpty()){
            TreeNode cur = queueNode.poll();
            int temp = sumQuene.poll();
            if(cur.left == null && cur.right == null){
                if(sum == temp){
                    return true;
                }
                continue;
            }
            if(cur.left != null){
                queueNode.offer(cur.left);
                sumQuene.offer(temp+cur.left.val);
            }
            if(cur.right != null){
                queueNode.offer(cur.right);
                sumQuene.offer(temp+cur.right.val);
            }
        }

        return false;
    }

    public boolean hasPathSum1(TreeNode root, int sum) {

        if(root == null){
            return false;
        }

        if(root.right == null && root.left == null){
            if(sum == root.val){
                return true;
            }
            return false;
        }
        return hasPathSum1(root.left,sum-root.val) || hasPathSum1(root.right,sum-root.val);
    }


}
