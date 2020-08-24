package com.my.leetcode.bytedance;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: whgong
 * @description:
 * @create: 2020/5/27 16:30
 */

public class Lc102 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        if (root==null){
            return res;
        }


        LinkedList<TreeNode> q1 = new LinkedList<>();
        LinkedList<TreeNode> q2 = new LinkedList();

        q1.offer(root);
        while (!q1.isEmpty()){
            List<Integer> valList = new ArrayList<>();
            while (!q1.isEmpty()){
                TreeNode item = q1.remove();
                valList.add(item.val);
                if(item.left != null){
                    q2.offer(item.left);
                }
                if(item.right != null){
                    q2.offer(item.right);
                }
            }
            res.add(valList);
            LinkedList<TreeNode> tmp = new LinkedList<>();
            tmp = q1;
            q1 = q2;
            q2 = tmp;
        }

        return res;

    }
}
