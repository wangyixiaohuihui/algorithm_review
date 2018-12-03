package com.wy.algorithm.graph;

import java.util.*;

/**
 * ClassName MinHeightTree
 * Date 2018/11/29
 *
 * @author wangyi
 **/
public class MinHeightTree {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {


        List<List<Integer>> map = new ArrayList<List<Integer>>();
        List<Integer> res = new ArrayList<Integer>();
        if (n==1) {
            res.add(0);
            return res;
        }
        //记录每个点的入度
        int[] degree = new int[n];
        for (int i = 0;i < n;i++ ) {
            map.add(new ArrayList<Integer>());
        }
        for (int i = 0;i< edges.length;i++) {
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
        }
        Queue<Integer> q = new ArrayDeque<Integer>();
        for (int i = 0;i < n;i++ ) {
            if(degree[i] == 0) {
                return res;
            } else if(degree[i] == 1) {
                q.offer(i);
            }
        }
        while(!q.isEmpty()) {
            res = new ArrayList<Integer>();
            int count = q.size();
            for (int i = 0;i < count ;i++ ) {
                int cur = q.poll();
                res.add(cur);
                degree[cur]--;
                for (int k = 0;k < map.get(cur).size() ;k++ ) {
                    int next = map.get(cur).get(k);
                    degree[next]--;
                    if(degree[next] == 0){
                        continue;
                    }
                    if(degree[next] == 1) {
                        q.offer(next);
                    }
                }
            }
        }
        return res;
    }

    // n = 4, edges = [[1, 0], [1, 2], [1, 3]]
    public static void main(String[] args) {
        Stack<Integer>  a = new Stack<>();

        new MinHeightTree().findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}});

    }
}
