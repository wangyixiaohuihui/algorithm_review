package com.wy.algorithm.array;

/**
 * ClassName MaxProduct
 * Date 2018/8/28
 *
 *  乘积最大子序列
 * @author wangyi
 **/
public class MaxProduct {

    private int maxProduct(int[] nums){


        int maxRes = nums[0];
        int minRes = nums[0];
        int finalMax = nums[0];



        for(int i=1; i<nums.length; i++){

            int tempMax = Math.max(Math.max(maxRes*nums[i], minRes * nums[i]), nums[i]);

            int tempMin = Math.min(Math.min(maxRes*nums[i], minRes * nums[i]), nums[i]);

            maxRes = tempMax;

            minRes = tempMin;

            finalMax = Math.max(maxRes, finalMax);
        }
        return finalMax;
    }

    public static void main(String[] args) {
        int res = new MaxProduct().maxProduct(new int[]{-4, -3, -2});

        System.out.println(res);
    }
}
