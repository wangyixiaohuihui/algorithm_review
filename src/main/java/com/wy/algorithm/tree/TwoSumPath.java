package com.wy.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ClassName TwoSumPath
 * Date 2019/9/30
 *
 * @author wangyi
 **/
public class TwoSumPath {

    private int pathValue = 0;


    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        Stack<Integer> path = new Stack<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        preOrder(root, sum, path, result );
        return result;
    }

    private void preOrder(TreeNode root, int sum,
                          Stack<Integer> path, List<List<Integer>> result) {
        if (null == root) {
            return;
        }
        pathValue += root.val;
        path.push(root.val);

        if (null == root.left && null == root.right && pathValue == sum) {
//            result.add(path);
            result.add(new ArrayList<Integer>(path));
        }

        preOrder(root.left, sum, path, result);
        preOrder(root.right, sum, path, result);

        pathValue -= root.val;
        path.pop();

    }

    public static void main(String[] args) {

        // [5,4,8,11,null,13,4,7,2,null,null,5,1]
        //22
        // new TwoSumPath().pathSum();

        Stack<Integer> path = new Stack<Integer>();

        path.clear();

    }


}
