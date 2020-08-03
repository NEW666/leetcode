package com.my.leetcode.tree;

/**
 * @author: whgong
 * @description:
 * @create: 2020/7/25 11:13
 */

public class Lc110 {

    final class TreeInfo{
        public final int height;
        public final boolean isBalanced;

        public TreeInfo(int height,boolean isBalanced){
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    public TreeInfo isBalancedHelper(TreeNode root){
        if(root == null){
            return new TreeInfo(-1,true);
        }

        TreeInfo left = isBalancedHelper(root.left);
        if(!left.isBalanced){
            return new TreeInfo(-1,false);
        }

        TreeInfo right = isBalancedHelper(root.right);
        if(!right.isBalanced){
            return new TreeInfo(-1,false);
        }


        if(Math.abs(left.height-right.height)<2){
            return new TreeInfo(Math.max(right.height,left.height)+1,true);
        }

        return new TreeInfo(-1,false);
    }

    public boolean isBalanced(TreeNode root) {

        return isBalancedHelper(root).isBalanced;
    }
}
