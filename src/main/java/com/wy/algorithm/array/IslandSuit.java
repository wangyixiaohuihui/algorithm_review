package com.wy.algorithm.array;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName IslandSuit
 * Date 2019/10/8
 *
 * @author wangyi
 **/
public class IslandSuit {
    // bfs search
    public int numIslands(char[][] grid) {

//        int[][] direction = new int[][]{{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1},{0,1}};
        int[][] direction = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        int islandNum = 0;
        int rowLen = grid.length;
        int colLen = grid[0].length;

        int[][] visit = new int[rowLen][colLen];
        for(int i=0; i < rowLen; i++) {
            for( int j =0; j< colLen; j++) {

                if(grid[i][j] =='1' && visit[i][j] == 0) {
                    bfsVisit(visit, grid, i, j, rowLen, colLen, direction);
                    islandNum ++;
                }
            }
        }
        return islandNum;
    }


    private void bfsVisit(int[][] visit, char[][] grid, int x, int y,
                          int rowLen, int colLen,
                          int[][] direction) {

        Queue<Pair> searchQueue = new LinkedList<Pair>();

        Pair<Integer, Integer> currentPair = new Pair<Integer, Integer>(x, y);
        searchQueue.offer(currentPair);
        visit[x][y] = 1;

        while (!searchQueue.isEmpty()) {

            Pair<Integer, Integer> tmpPair = searchQueue.poll();
            int tmpX = tmpPair.getKey();
            int tmpY = tmpPair.getValue();


            for (int i = 0; i < direction.length; i++) {
                int newX = tmpX + direction[i][0];
                int newY = tmpY + direction[i][1];

                if (newX < 0 || newX > (rowLen - 1) || newY < 0 || newY > (colLen - 1)) {
                    continue;
                }
                if (grid[newX][newY] == '1' && visit[newX][newY] == 0) {
                    searchQueue.offer(new Pair<Integer, Integer>(newX, newY));
                    visit[newX][newY] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {

        char[][] graid = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        int y = new IslandSuit().numIslands(graid);
        System.out.println(y);
    }
}
