package com.wy.algotithm.string;

import com.sun.jmx.remote.internal.ArrayQueue;
import javafx.util.Pair;
import scala.actors.LinkedQueue;

import java.util.*;


/**
 * ClassName TestList
 * Date 2018/9/19
 *
 * @author wangyi
 **/
public class TestList {


    public List<Integer> listNodeId(Node node) {
        List<Integer> ids = new ArrayList();
        if(node==null){
            //没有此判断扣一分
            return ids;
        }
        ids.add(node.id);
        for(Node child : node.children){
            ids.addAll(this.listNodeId(child));
        }
        return ids;
    }

    private void arrayMock(int[][]  visit){

        visit[0][1]=100;
    }

    public static void main(String[] args) {

        Queue<Pair> ladderQueue = new LinkedList<>();
//        Set<String> visit = new HashSet<String>();
        new Pair<String, Integer>("beginWord", 1);
//        Pair<Integer, Integer> currentPari = new Pair<Integer, Integer>(0,0);
//        Queue<Pair> searchQueue = new ArrayDeque<Pair>();
//        searchQueue.offer(new Pair(0,0));
//        searchQueue.peek();
//        searchQueue.poll();

//        int[][] visit = new int[][]{{0,0},{1,1}};

        int[][] visit = new int[20][20];


        new TestList().arrayMock(visit);

        for(int i=0; i<visit.length; i++) {
            for (int j=0; j<visit[0].length; j++){
                System.out.println(visit[i][j]);
            }
        }
    }

}


class Node {
    public Integer id;
    public List<Node> children;
}

class Item implements Comparable {
    int x;
    int y;
    int height;

    public Item(int x, int y, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
    }

    @Override
    public int compareTo(Object o) {
        Item item = (Item)o;
        return this.height - item.getHeight();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }
}