package com.wy.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ClassName LowestCommonTree
 * Date 2019/9/30
 *
 * @author wangyi
 **/
public class LowestCommonTree {
    private  boolean findNode = false;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        List<TreeNode> pResult = new ArrayList<TreeNode>();
        List<TreeNode> qResult = new ArrayList<TreeNode>();
        Stack<TreeNode> path = new Stack<TreeNode>();

        preOrder(root, p, path, pResult);
        path.clear();
        findNode = false;
        preOrder(root, q, path, qResult);

        int pathLen =0;
        if( pResult.size() < qResult.size()){
            pathLen = pResult.size();
        }else {
            pathLen = qResult.size();
        }
        TreeNode lowestNode = null;
        for(int i=0; i<pathLen; i++){
            if(pResult.get(i).val == qResult.get(i).val) {
                lowestNode = pResult.get(i);
            }
        }
        return  lowestNode;
    }

    private void preOrder(TreeNode node, TreeNode search, Stack<TreeNode> path, List<TreeNode> result ){

        if(null == node || findNode) {
            return;
        }
        path.push(node);
        if(node.val == search.val) {
            findNode = true;
            result.addAll(new ArrayList<TreeNode>(path));
//            result = new ArrayList<TreeNode>(path);
        }
        preOrder(node.left, search, path, result);
        preOrder(node.right, search, path, result);
        path.pop();
    }


    public static void main(String[] args) {
        Integer[] array = new Integer[]{3,5,1,6,2,0,8,null,null,7,4};
        TreeNode  root = TreeUtils.arrayToTree(array);
        new LowestCommonTree().lowestCommonAncestor(root, new TreeNode(5), new TreeNode(4));
    }

}
