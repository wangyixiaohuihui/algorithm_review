package com.wy.algorithm.tree;

import java.util.*;

/**
 * @author wangyi
 * date: {DATE}
 **/


public class TreeSuit {

    private TreeNode last2 = null;

    private void preOrder(TreeNode node, TreeNode last) {
        //last = new TreeNode(20);

        last.val = 30;

        last2 = new TreeNode(20);

    }


    public static void main(String[] args) {

        TreeNode last = new TreeNode(10);

        TreeSuit  treeSuit = new TreeSuit();
        treeSuit.preOrder(last, last);
        System.out.println(treeSuit.last2.val);

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1,1);
        List<String> path = new LinkedList<>();


    }
}
