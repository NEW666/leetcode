package com.my.leetcode.dp;

import com.my.leetcode.tree.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ：wh.gong
 * @date ：Created in 2020/12/30 19:50
 * @description：
 */
public class Jzo68 {

    Map<Integer,TreeNode> parent = new HashMap<>();
    Set<Integer> contains = new HashSet<>();

    public void dfs(TreeNode root){
        if(root.left != null){
            parent.put(root.left.val,root);
            dfs(root.left);
        }
        if(root.right != null){
            parent.put(root.right.val,root);
            dfs(root.right);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        dfs(root);

        while (p != null){
            contains.add(p.val);
            p = parent.get(p.val);
        }

        while (q != null){

            if(contains.contains(q.val)){
                return q;
            }
            q = parent.get(q.val);
        }

        return null;

    }
}
