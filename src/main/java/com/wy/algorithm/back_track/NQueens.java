package com.wy.algorithm.back_track;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName NQueens
 * Date 2019/9/30
 *
 * @author wangyi
 **/
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        // 8个方向
        int[][] direction = new int[][]{{1, 0}, {1, -1}, {0, -1},
                {-1, -1}, {-1,0}, {-1, 1}, {0, 1}, {1, 1}};
        List<List<String>> ans = new ArrayList<List<String>>();

        // 标记棋盘
        int[][] mark = new int[n][n];
        List<char[]> location = new ArrayList<char[]>();

        for (int i = 0; i < n; i++) {
            char[] lo = new char[n];
            for (int j = 0; j < n; j++) {
                mark[i][j] =0;
                lo[j] ='.';
            }
            location.add(lo);
        }

        geterate(0, n, location, ans, mark, direction);
        return ans;

    }


    private void geterate(int k, int n, List<char[]> location,
                          List<List<String>> ans, int[][] mark,
                          int[][] direction) {
        if (k == n) {
            List<String> tmpList = new ArrayList<String>();
            for(int i=0; i< location.size(); i++){
                tmpList.add(new String(location.get(i)));
            }
            ans.add(tmpList);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (mark[k][i] == 0) {
                int[][] tmpMark = markCopy(mark);
                char[] l0 = location.get(k);
                l0[i] ='Q';
                putDownQueen(k, i, mark, direction);
                geterate(k + 1, n, location, ans, mark, direction);
                mark = tmpMark;
                char[] l1 = location.get(k);
                l1[i] ='.';
            }
        }
    }


    private int[][] markCopy(int[][] mark){

        int row = mark.length;
        int col = mark[0].length;
        int[][] copyMark = new int[row][col];
        for(int i=0; i<row; i++){
            copyMark[i] = mark[i].clone();
        }
        return copyMark;
    }

    private void putDownQueen(int x, int y, int[][] mark, int[][] direction) {
        // 防置皇后后的更新棋盘
        mark[x][y] = 1;
        for (int i = 1; i < mark.length; i++) {
            for (int j = 0; j < direction.length; j++) {

                int dx = x + i * direction[j][0];
                int dy = y + i * direction[j][1];

                if (dx >= 0 && dx < mark.length
                        && dy >= 0 && dy < mark[0].length) {
                    mark[dx][dy] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        new NQueens().solveNQueens(4);
    }
}
