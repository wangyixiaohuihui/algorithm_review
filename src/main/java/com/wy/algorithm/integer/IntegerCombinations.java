package com.wy.algorithm.integer;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName IntegerCombinations
 * Date 2018/9/25
 *
 * @author wangyi
 **/
public class IntegerCombinations {

    public static  List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs = new ArrayList<List<Integer>>();
        combine(combs, new ArrayList<Integer>(), 1, n, k);
        return combs;
    }


    public static void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
        if(k==0) {
            System.out.println("insert:-----"+comb);
            combs.add(new ArrayList<Integer>(comb));

            return;
        }
        for(int i=start; i<=n; i++) {
            comb.add(i);
            combine(combs, comb, i+1, n, k-1);
            System.out.println("》》》》》》》》》》》》》"+comb);
            comb.remove(comb.size()-1);
            System.out.println("《《《《《《《《《《《《《"+comb);
        }
    }

    public static void main(String[] args) {
//        List<List<Integer>> s = IntegerCombinations.combine(4, 3);
//
//        System.out.println(s.toString());

        System.out.println( 1<<2);
    }
}
