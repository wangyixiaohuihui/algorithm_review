package com.wy.algorithm.array;

/**
 * ClassName MaxProductNum
 * Date 2018/8/28
 *
 * @author wangyi
 **/
public class MaxProductNum {

    public int numSubarrayProductLessThanK(int[] nums, int k) {

        if( k <= 1){
            return 0;
        }

        // 双指针 方法， 定义为左边的指针
        int left = 0;

        // 累积的最大值
        int limitRes = 1;

        // 当前的最大的子数组个数
        int thanKNum =0;

        for(int i=0; i < nums.length; i++ ){

            limitRes = limitRes * nums[i];

            while(limitRes >= k ){

                // 当前累积值 > k，  左边的指针向后移动
                limitRes = limitRes / nums[left];
                left ++;
            }
            // 窗口内的值 为 子数组的个数
            thanKNum += (i -left +1);
        }

        return thanKNum;
    }


    public static void main(String[] args) {
        int s = new MaxProductNum().numSubarrayProductLessThanK(new int[]{2,3,4,5,6,7},  1);
        System.out.println(s );
    }
}
