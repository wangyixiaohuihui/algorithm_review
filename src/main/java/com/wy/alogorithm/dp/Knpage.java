package com.wy.alogorithm.dp;

import java.util.Arrays;

/**
 * ClassName Knpage
 * Date 2018/11/26
 *
 * @author wangyi
 **/
public class Knpage {

    // 动态规划
    public static boolean canPartition(int[] nums) {

        int sums = 0;
        for(int num: nums){
            sums += num;
        }
        if(sums % 2 ==1){
            return false;
        }

        sums = sums/2;

        int n = nums.length;
        boolean[] dp = new boolean[sums+1];
        Arrays.fill(dp, false);
        dp[0] = true;

        for(int num: nums){
            for(int i=sums; i>0; i--){

                if(i >= num){

                    System.out.println("i:"+i + "   num:"+num);

                    dp[i] = dp[i] || dp[i-num];
                    System.out.println(Arrays.toString(dp));

                }
            }
        }
        return dp[sums];
    }


    public static void main(String[] args) {

        canPartition(new int[]{1, 5, 11, 5});
    }
}
