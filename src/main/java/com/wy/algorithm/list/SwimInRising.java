package com.wy.algorithm.list;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * ClassName SwimInRising
 * Date 2018/11/29
 *
 * @author wangyi
 **/
public class SwimInRising {


    public int swimInWater(int[][] grid) {

        int n = grid.length;

        int res =0;
        PriorityQueue<SwimTime> pq = new PriorityQueue<SwimTime>((a, b) -> a.t - b.t);



        int[][] seen = new int[n][n];

        seen[0][0] =1;
        int[][] dir = new int[][]{{0,1}, {0,-1}, {1,0}, {-1, 0}};

        pq.offer(new SwimTime(0, 0, grid[0][0]));

        while(true){

            SwimTime temp = pq.poll();

            if(temp !=null){
                res = Math.max(res, temp.t);
            }

            if(temp.x == n-1 && temp.y == n-1){
                return res;
            }
            for(int[] step: dir){
                int i = temp.x + step[0];
                int j = temp.y + step[1];

                if(i>=0 && i<n && j>=0 && j<n  && (seen[i][j] ==0)){
                    seen[i][j] =1;
                    pq.offer(new SwimTime(i, j, grid[i][j]));
                }
            }


        }



    }

    public static void main(String[] args) {

        PriorityQueue<SwimTime> pq = new PriorityQueue<SwimTime>((a, b) -> a.t - b.t);

        pq.offer(new SwimTime(1,2,6));
        pq.offer(new SwimTime(1,2,5));
        pq.offer(new SwimTime(1,2,4));
        pq.offer(new SwimTime(1,2,3));
        pq.offer(new SwimTime(1,2,2));
        pq.offer(new SwimTime(1,2,1));


        while (pq.size()>0){
            System.out.println(pq.poll().toString());
        }

        Queue<Integer> q = new ArrayDeque<Integer>();

    }


}

class SwimTime{
    public int x;
    public int y;
    public int t;

    public SwimTime(int x, int y, int t) {
        this.x = x;
        this.y = y;
        this.t = t;
    }

    @Override
    public String toString() {
        return "SwimTime{" +
                "x=" + x +
                ", y=" + y +
                ", t=" + t +
                '}';
    }
}
