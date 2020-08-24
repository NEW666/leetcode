package com.my.leetcode.tree;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;

/**
 * @author: whgong
 * @description:
 * @create: 2020/8/3 20:01
 */

public class Lc449 {

    public StringBuilder postorder(TreeNode node,StringBuilder sb){
        if(node == null){
            return sb;
        }
        postorder(node.left,sb);
        postorder(node.right,sb);
        sb.append(node.val);
        sb.append(" ");
        return sb;
    }


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        postorder(root,stringBuilder);
        return stringBuilder.toString();
    }


    public TreeNode helper(Integer lower,Integer upper,ArrayDeque<Integer> nums){
        if(nums.isEmpty()){
            return null;
        }
        int val = nums.getLast();
        if(val < lower || val > upper){
            return null;
        }
        nums.removeLast();
        TreeNode root = new TreeNode(val);
        root.right = helper(val,upper,nums);
        root.left = helper(lower,val,nums);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()){
            return null;
        }
        String[] val = data.split(" ");
        ArrayDeque<Integer> nums = new ArrayDeque<Integer>();
        for (int i = 0; i < val.length; i++) {
            nums.add(Integer.parseInt(val[i]));
        }
        return helper(Integer.MIN_VALUE,Integer.MAX_VALUE,nums);

    }


    public static void main(String[] args) {
        Lc449 lc449 = new Lc449();
        lc449.deserialize("0 1 4 3 6 5");
    }
}
