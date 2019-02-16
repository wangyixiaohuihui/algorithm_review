package com.wy.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author wangyi
 * date: {DATE}
 **/


public class SubArraySum {

    public int subArraySum(int[] nums, int k) {

        int ans =0;
        int sum =0;


        HashMap<Integer, Integer> sumMap = new HashMap<Integer, Integer>(16);
        sumMap.put(0,1);

        for(int i=0; i<nums.length; i++){
            sum = sum + nums[i];
            Integer count = sumMap.get(sum);
            if(null == count){
                sumMap.put(sum, 1);
            }else{
                count++;
                sumMap.put(sum, count);
            }
        }
        System.out.println(sumMap.toString());

        for(int a:nums){
            System.out.print("  "+ a);
        }
        System.out.println();

        sum =0;

        for(int i=0; i<nums.length; i++){

            sum = sum + nums[i];

            int diffSum = sum -k;
            Integer count = sumMap.get(diffSum);
            if(null != count){
                ans += count;
            }

        }
        return ans;
    }


    public static void main(String[] args) {
        int s = new SubArraySum().subArraySum(new int[]{1,2,3}, 3);

        System.out.println(s);

        List<List<Integer>>  resList = new ArrayList<List<Integer>>();

        String a ="sdsada";

        StringBuffer a1 = new StringBuffer("dsadsa");
        a1.reverse();


    }



}
