package com.my.leetcode.bytedance;

import com.my.leetcode.common.TreeNode;

/**
 * @author: whgong
 * @description:
 * @create: 2020/7/1 19:18
 */

public class Lc814 {


    public TreeNode pruneTree(TreeNode root) {
        if(root == null){
            return null;
        }

        TreeNode left = pruneTree(root.left);
        TreeNode right = pruneTree(root.right);
        if(root.val == 0 && left == null && right == null){
            return null;
        }

        root.left = left;
        root.right = right;
        return root;

    }
}
