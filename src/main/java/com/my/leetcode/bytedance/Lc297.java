package com.my.leetcode.bytedance;

import com.my.leetcode.common.TreeNode;

import java.util.LinkedList;

/**
 * @author: whgong
 * @description:
 * @create: 2020/6/18 17:27
 */

public class Lc297  {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        StringBuilder stringBuilder = new StringBuilder();
        LinkedList<TreeNode> quene = new LinkedList();
        quene.offer(root);
        while (!quene.isEmpty()){
            TreeNode cur = quene.poll();
            if(cur != null){
                stringBuilder.append(cur.val+",");
                quene.offer(cur.left);
                quene.offer(cur.right);
            }else {
                stringBuilder.append("#,");
            }
        }
        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    private TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        if(nodes[0].equals("#")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        LinkedList<TreeNode> quene = new LinkedList<>();
        quene.offer(root);
        for (int i = 1; i < nodes.length; i++) {
            TreeNode cur = quene.poll();
            if(cur == null){
                continue;
            }
            if(!nodes[i].equals("#")){
                cur.left = new TreeNode(Integer.parseInt(nodes[i++]));
                quene.offer(cur.left);
            }else {
                ++i;
            }
            if(!nodes[i].equals("#")){
                cur.right = new TreeNode(Integer.parseInt(nodes[i]));
                quene.offer(cur.right);
            }
        }
        return root;

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode s = new TreeNode(2);
        TreeNode t = new TreeNode(3);
        TreeNode f = new TreeNode(4);
        TreeNode sa = new TreeNode(5);
        root.left = s;
        root.right = t;
        t.left = f;
        t.right = sa;
        Lc297 l = new Lc297();
        System.out.println(l.serialize(root));
        String a = "1,2,3,#,#,4,5,#,#,#,#,";
        l.deserialize(a);

        int i=0;
        int[] as = {1,2,3,4,5};
        System.out.println(as[++i]);
        System.out.println(as[i]);
    }



}
