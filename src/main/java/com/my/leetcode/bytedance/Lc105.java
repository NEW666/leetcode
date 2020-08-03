package com.my.leetcode.bytedance;

import com.my.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */

public class Lc105 {

    Map<Integer,Integer> indexMap = new HashMap<>();

    public TreeNode mybuildTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight){
        if(preLeft > preRight){
            return null;
        }
        int preorderRoot = preLeft;
        int inorderRoot = indexMap.get(preorder[preorderRoot]);
        int inorderLeftSize = inorderRoot - inLeft;
        TreeNode root = new TreeNode(preorder[preorderRoot]);
        root.left = mybuildTree(preorder,inorder,preLeft+1,preLeft+inorderLeftSize,inLeft,inorderRoot-1);
        root.right = mybuildTree(preorder,inorder,preLeft+inorderLeftSize+1,preRight,inorderRoot+1,inRight);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int n = preorder.length;

        for (int i = 0; i < n ; i++) {
            indexMap.put(inorder[i],i);
        }
        return mybuildTree(preorder,inorder,0,n-1,0,n-1);
    }



}
