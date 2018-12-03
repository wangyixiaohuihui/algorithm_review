package com.wy.algorithm.list;

import java.util.*;

/**
 * ClassName Redundant
 * Date 2018/11/27
 *
 * @author wangyi
 **/
public class Redundant {

    public int[] findRedundantConnection(int[][] edges) {

        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();

        int m = edges.length;

        for(int i=0; i< m; i++){

            int u = edges[i][0];
            int v = edges[i][1];

            Set<Integer> visited = new HashSet<Integer>();
            if(hasPath(u, v, graph, visited)){
                return new int[]{u,v};
            }
            List<Integer> uList = graph.get(u);
            if(null == uList){
                uList = new ArrayList<Integer>();

            }
            uList.add(v);
            graph.put(u, uList);


            List<Integer> vList = graph.get(v);
            if(null == vList){
                vList = new ArrayList<Integer>();

            }
            vList.add(u);
            graph.put(v, vList);

        }
        return null;
    }

    private boolean hasPath(int cur, int goal, Map<Integer, List<Integer>> graph, Set<Integer> visited){

        if(cur == goal){
            return true;
        }
        visited.add(cur);

        if(!graph.containsKey(cur) || !graph.containsKey(goal)){
            return false;
        }
        for(int next: graph.get(cur)){
            if(visited.contains(next)){
                continue;
            }
            if(hasPath(next, goal, graph, visited)){
                return true;
            }
        }
        return false;
    }



    public int[] findRedundantConnection2(int[][] edges) {

        int n = edges.length;

        int[] parents = new int[n+1];
        int[] sizes = new int[n+1];

        for(int i=0; i<n+1; i++){
            sizes[i] =1;
        }

        for(int[] edge: edges){

            int u = edge[0];

            int v = edge[1];

            if(parents[u]==0){
                parents[u] =u;
            }
            if(parents[v]==0){
                parents[v] =v;
            }

            int pu = find(u, parents);
            int pv = find(v, parents);

            if(pu == pv){
                return edge;
            }

            if(sizes[pv] > sizes[pu]){
                int temp = sizes[pv];
                sizes[pv] = sizes[pu];
                sizes[pu] = temp;

            }

            parents[pv] = pu;
            sizes[pu] += sizes[pv];
        }

        return null;
    }


    private int find(int node, int[] parents){

        while(parents[node] != node){

            parents[node] = parents[parents[node]];
            node = parents[node];

        }

        return node;
    }



    public static void main(String[] args) {

        int[][] a = new int[][]{{1,2}, {1,3}, {2,3}};

        new Redundant().findRedundantConnection2(a);

    }
}
