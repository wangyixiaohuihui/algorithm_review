package com.wy.algorithm.graph;

import java.util.*;

/**
 * ClassName SafeGraphNode
 * Date 2018/9/5
 *
 * @author wangyi
 **/
public class SafeGraphNode {
    public static List<Integer> safeNodeList = new ArrayList<Integer>();
    public static List<Integer> visitedSafeNodeList = new ArrayList<Integer>();

    public List<Integer> eventualSafeNodes(int[][] graph) {

        int graphNode = graph.length;

        for(int j=0; j< graphNode; j++){
            HashSet<Integer> visitSet = new HashSet<Integer>();

            if(!visitedSafeNodeList.contains(j)){
                System.out.println("visitedSafeNodeList:"+ visitedSafeNodeList.toString());
                visitGraph(graph,j, visitSet);
            }
        }
        return safeNodeList;
    }

    public void visitGraph(int[][] graph, int edgeNode, HashSet<Integer> visitSet){

        // 添加已经访问的节点
        System.out.println("visitSet:"+ visitSet.toString());
        if(!visitSet.contains(edgeNode)){
            visitSet.add(edgeNode);
        }else{
            return;
        }

        int[] nodes =  graph[edgeNode];

        if(nodes.length ==0){
            safeNodeList.add(edgeNode);
            visitedSafeNodeList.addAll(visitSet);
            return;
        }
        for(int i=0; i< nodes.length; i++){

            visitGraph(graph, nodes[i],visitSet);
        }

    }


    /**
     *         // state:0 - univisited,
     *         // 1 - safe,
     *         // 2 - in cycle
     * 深度遍历图，通过节点状态获取  响应节点是否在循环图中
     * @param graph 图数据
     * @return 安装状态节点
     *
     *
     */
    private  List<Integer> eventualSafeNodesNew(int[][] graph){

        // state:0 - univisited,
        // 1 - safe,
        // 2 - in cycle
        int[] states = new int[graph.length];
        for(int i=0;i<graph.length;++i){
            checkNodeState(graph,i,states);
        }

        List<Integer> result = new LinkedList<Integer>();
        for(int i=0;i<graph.length;++i){
            if(states[i]==1){
                result.add(i);
            }
        }
        return result;
    }



    private void checkNodeState(int[][] graph,int node,int[] states){
        if(states[node] == 0){
            states[node] = 2;
            for (int next : graph[node]){
                checkNodeState(graph,next,states);
                if(states[next]==2){
                    return;
                }
            }
            states[node] = 1;

        }

    }







    private  List<Integer> eventualSafeNodesThree(int[][] graph){

        int[] outCounts = new int[graph.length];

        ArrayList<Set<Integer>> ins = new ArrayList<Set<Integer>>();

        for(int i=0; i< graph.length; ++i){

            ins.add(new HashSet<Integer>());
            // outCounts 记录每个节点出度
            outCounts[i] = graph[i].length;
        }

        for(int i=0; i<graph.length; ++i){

            for(int out : graph[i]){

                // 入度节点填充
                ins.get(out).add(i);
            }
        }



        Queue<Integer> noOuts = new LinkedList<Integer>();

        for(int i=0; i< outCounts.length;++i){
            // 出度为0
            if(outCounts[i]==0){
                noOuts.offer(i);
            }
        }

        while(!noOuts.isEmpty()){
            int noOut = noOuts.poll();
            // 遍历出度为 0 的节点，
            //  获取该节点的所有的入度节点
            for(int in : ins.get(noOut)){

                // 获取该入度节点的出度长度
                //int outCount = outCounts[in];
                outCounts[in] = outCounts[in] -1;
                if(outCounts[in] == 0){
                    noOuts.add(in);
                }
            }
        }
        List<Integer> result = new LinkedList<Integer>();
        for(int i=0;i<graph.length;++i){
            if(outCounts[i]==0){
                result.add(i);
            }
        }
        return result;

    }












    public static void main(String[] args) {

        int[][] graph = new int[][]{{1,2},{2,3},{5},{0},{5},{},{}};

        List<Integer> list = new SafeGraphNode().eventualSafeNodesThree(graph);

        System.out.println(list.toString());



    }
}
