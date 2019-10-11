package com.wy.algorithm.back_track;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName ArrayCloneSuit
 * Date 2019/9/29
 *
 * @author wangyi
 **/
public class ArrayCloneSuit {


    public static void main(String[] args) {
        int[][] a = new int[][]{{1,2},{1,4}};

        int[][] b = a.clone();

        for(int i=0; i<a.length; i++){
            a[i][0] =10;
        }

        for(int j=0; j < b.length; j++){

            System.out.println(b[j][0]);
        }
        int[] a1 = new int[]{1,2,1,};

        int[] b1 = a1.clone();

        for(int i=0; i<a1.length; i++){
            a1[0] =10;
        }

        for(int j=0; j < b1.length; j++){

            System.out.println(b1[0]);
        }
        List<String> location = new ArrayList<String>();
        location.add("12345");
        location.add("67890");

        String l0 = location.get(1);


        List<char[]> location12 = new ArrayList<char[]>();

        for (int i = 0; i < 3; i++) {
            char[] lo = new char[3];
            for (int j = 0; j < 3; j++) {
                lo[j] ='.';
            }
            location12.add(lo);

        }
    }
}
