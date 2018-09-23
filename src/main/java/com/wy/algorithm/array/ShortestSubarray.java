package com.wy.algorithm.array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ClassName ShortestSubarray
 * Date 2018/9/21
 *
 * @author wangyi
 **/
public class ShortestSubarray {

    public static  int shortestSubarray(int[] A, int K) {
        int N = A.length;
        int res = N + 1;
        int[] B = new int[N + 1];

        // B 数组存储的是累加到当前节点的和, 不包含当前的节点
        for (int i = 0; i < N; i++) {
            B[i + 1] = B[i] + A[i];
        }
        ArrayDeque<Integer> d = new ArrayDeque<Integer>();

        for (int i = 0; i < N + 1; i++) {

            while (d.size() > 0 && B[i] - B[d.getFirst()] >=  K){
                res = Math.min(res, i - d.pollFirst());
            }

            while (d.size() > 0 && B[i] <= B[d.getLast()]) {
                // 队列末尾移除
                d.pollLast();
            }
            // 队列尾部加入当前的节点索引
            d.addLast(i);
        }
        return res <= N ? res : -1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,-1,2};

        System.out.println(shortestSubarray(a, 3));

    }
}
