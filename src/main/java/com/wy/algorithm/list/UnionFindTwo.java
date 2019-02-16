package com.wy.algorithm.list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * ClassName UnionFindTwo
 * Date 2018/11/28
 *
 * @author wangyi
 **/
public class UnionFindTwo {


    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] candidateOne = {-1, -1};
        int[] candidateTwo = {-1, -1};
        int n = edges.length;

        int[] parent = new int[n+ 1];
        for (int i = 0; i < edges.length; i++) {
            if (parent[edges[i][1]] == 0) {
                parent[edges[i][1]] = edges[i][0];
            } else {
                // 有两个子节点
                candidateTwo = new int[] {edges[i][0], edges[i][1]};
                candidateOne = new int[] {parent[edges[i][1]], edges[i][1]};
                edges[i][1] = 0;
            }
        }

        System.out.println(Arrays.toString(candidateOne));
        System.out.println(Arrays.toString(candidateTwo));
        // 当前节点的父节点 设置为自己
        for (int i = 0; i <= edges.length; i++) {
            parent[i] = i;
        }

        //
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][1] == 0) {
                continue;
            }
            // 获取每条边的父 子节点
            int child = edges[i][1];
            int father = edges[i][0];

            // 若当前边的根节点 与 子节点一致
            if (root(parent, father) == child) {

                if (candidateOne[0] == -1) {
                    return edges[i];
                }
                return candidateOne;
            }
            parent[child] = father;
        }
        return candidateTwo;

    }

    // 获取当前节点的父节点
    int root(int[] parent, int i) {
        while (i != parent[i]) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new UnionFindTwo().findRedundantDirectedConnection(new int[][]{
//                {1,2}, {2,3}, {3,4}, {4,1}, {1,5}
//        })));

        System.out.println(Arrays.toString(new UnionFindTwo().findRedundantDirectedConnection(new int[][]{
                {4,2},{1,5},{5,2},{5,3},{2,4}
        })));
    }
}



//class SwimTime implements Comparable{
//    public int x;
//    public int y;
//    public int t;
//
//    public SwimTime(int x, int y, int t){
//        this.x = x;
//        this.y = y;
//        this.t = t;
//    }
//
//
//    @Override
//    public int compareTo(Object o){
//
//        SwimTime  b = (SwimTime)o;
//        return this.t - b.t;
//    }
//
//}