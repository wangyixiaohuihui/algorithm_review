package com.wy.algorithm.string;

import java.util.LinkedList;

/**
 * ClassName Permutation
 * Date 2018/9/7
 *
 * @author wangyi
 **/
public class Permutation {

    public static String getPermutation(int n, int k) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i = 1 ; i <= n ; i++){
            list.add(i);
        }
        return getNextRange(list, k -1);
    }


    public static String getNextRange(LinkedList<Integer> list , int k){

        String result = "";
        if(list ==null || list.size() == 0){
            return result;
        }
        //求总的排列数 求n 阶乘
        int total = 1;
        for (int i = 1 ; i <= list.size() ; i++) {
            total = total * i;
        }


        int every = total / list.size();
        int range = k / every;
        int other = k % every;
        Integer temp = list.get(range);
        list.remove(list.get(range));
        result = temp + getNextRange(list, other);
        return result;
    }


    public static void main(String[] args) {
        String res =  Permutation.getPermutation(4, 17);
        System.out.println(res);
    }
}
