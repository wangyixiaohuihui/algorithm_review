package com.wy.algothrim.greed;

import java.util.*;

/**
 * @author wangyi
 * date: {DATE}
 **/


public class ReconstructQueue {

    public int[][] reconstructQueue(int[][] people) {

        Integer[] A = new Integer[10];
        Arrays.sort(A);
        Arrays.sort(people, (a, b) -> (b[0] == a[0] ? a[1] - b[1] : b[0] - a[0]));
        List<int[]> res = new ArrayList<>();
        for (int[] p : people) {
            res.add(p[1], p);
        }
        return res.toArray(new int[0][0]);

    }

    

    public static void main(String[] args) {
//        Map<String, String> map = new HashMap<>();
//        System.out.println(map.put("1", "1"));
//        System.out.println(map.put("1", "3"));
//        System.out.println(map.putIfAbsent("1", "2"));
//        System.out.println(map.putIfAbsent("3", "2"));
//        System.out.println(map.get("3"));
//        System.out.println(map.get("1"));
//        System.out.println(map.put("1", "3"));
//        System.out.println(map.get("1"));

        System.out.println((int)('A'));


        // Collections.sort();

        PriorityQueue<Integer> q =
                new PriorityQueue<Integer>(Collections.reverseOrder());

    }
}
