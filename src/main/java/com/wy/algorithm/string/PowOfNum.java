package com.wy.algorithm.string;

/**
 * @author by wangyi
 * @classname PowOfNum
 * @description 2 的 n次幂 1000
 * @date 2021/2/19 10:57
 */
public class PowOfNum {

    /**
     * 求出 2 的num次幂
     * @param num  幂数
     * @return 结果
     */
    public static String powOf2(int num) {

        StringBuilder sb = new StringBuilder();

        int[] r = new int[1000];

        r[0] =1;

        int flag = 0;
        for (int i=0; i< num; i++) {

            for (int j =0; j<=999; j++) {
                int t = r[j] *2 + flag;
                int t1 = t % 10;
                flag = t / 10;
                r[j] = t1;
            }
        }
        for (int i=999; i >=0; i--) {
            if (r[i] !=0) {
                sb.append(r[i]);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(PowOfNum.powOf2(1000));
    }
}
