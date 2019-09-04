package com.wy.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangyi
 * date: {DATE}
 **/


class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}
public class FindTreeValue{

    public List<List<Integer>> mlists=new ArrayList<List<Integer>>();
    public List<Integer> list=new ArrayList<Integer>();
    public void dfs(TreeNode root,int sum,int target){
        if(root==null){
            return ;
        }
        target+=root.val;
        list.add(root.val); //添加到记忆里
        if(target==sum&&root.left==null&&root.right==null){       //找到符合要求的路径
            mlists.add(new ArrayList(list));          //这里一定要new ArrayList 加入不同的对象 否则你加入的是同一个引用
        }
        dfs(root.left,sum,target);
        dfs(root.right,sum,target);
        list.remove(list.size()-1); // 叶节点 开始回溯 移除记忆
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root,sum,0);
        return mlists;

    }
    

}