package com.my.leetcode.bytedance;


import java.util.*;

/**
 * 103. 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层次遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class Lc103 {



    /**
     * bfs 广度优先搜索
     * @param root
     * @return
     */
 /*   public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return Collections.emptyList();
        }
        LinkedList<TreeNode> nodeQuene = new LinkedList<TreeNode>();
        nodeQuene.addLast(root);
        nodeQuene.addLast(null);

        List<List<Integer>> result = new ArrayList<>();

        boolean isOrderLeft = true;

        LinkedList<Integer> levelValue = new LinkedList<Integer>();

        while (nodeQuene.size() > 0){
            //pollFirst()出栈
            TreeNode currentNode = nodeQuene.pollFirst();
            if(currentNode != null){
                if(isOrderLeft){
                    levelValue.addLast(currentNode.val);
                }else {
                    levelValue.addFirst(currentNode.val);
                }


                if(currentNode.left != null){
                    nodeQuene.addLast(currentNode.left);
                }
                if(currentNode.right != null){
                    nodeQuene.addLast(currentNode.right);
                }
            }else {
                result.add(levelValue);
                levelValue = new LinkedList<>();
                if(nodeQuene.size() > 0){
                    nodeQuene.addLast(null);
                }
                isOrderLeft = !isOrderLeft;

            }


        }


        return result;

    }*/

    /**
     * dfs 深度优先搜索
     */

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if(root == null){
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();
        DFS(root,0,result);
        return result;
    }

    public void DFS(TreeNode treeNode,int level,List<List<Integer>> result){
        if(level > result.size()){
            List<Integer> levelValue = new ArrayList<>();
            levelValue.add(treeNode.val);
            result.add(levelValue);
        }else {
            if(level %2 == 0){
                result.get(level).add(treeNode.val);
            }else {
                result.get(level).add(0,treeNode.val);
            }
        }

        if(treeNode.left != null){
            DFS(treeNode.left,level+1,result);
        }
        if(treeNode.right != null){
            DFS(treeNode.right,level+1,result);
        }


    }



}
