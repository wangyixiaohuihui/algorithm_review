package com.wy.algorithm.string;

/**
 * ClassName LightOff
 * Date 2019/9/4
 * 熄灯问题
 * 5 * 6 的矩阵
 *
 * @author wangyi
 **/
public class LightOff {
    /**
     * 当前灯的状态
     */
    int[][] puzzle = new int[6][8];

    /**
     * 当前是否需要按灯
     */
    int[][] press = new int[6][8];

    private boolean guess() {
        int i;
        int j;

        for (i = 2; i < 6; i++) {
            for (j = 1; j < 7; j++) {
                press[i][j] =
                        (press[i - 1][j]
                                + puzzle[i - 1][j]
                                + press[i - 1][j - 1] + press[i - 2][j] + press[i - 1][j + 1]) % 2;
            }
        }
        // 查看最后一行的按开关的状态
        for (j = 1; j <= 6; j++) {
            if (press[5][j] != (puzzle[5][j] + press[5][j - 1] + press[5][j + 1] + press[4][j]) % 2) {
                return false;
            }
        }
        return true;
    }


    // 第一行开关状态更新
    private void process() {
        int c;
        // 初始化开关开关状态为全部关闭
        for (c = 1; c < 7; c++) {
            press[1][c] = 0;
        }
        while (!guess()) {
            press[1][1]++;
            c = 1;
            while (press[1][c] > 1) {
                press[1][c] = 0;
                c++;
                press[1][c]++;
            }
        }
    }


}
