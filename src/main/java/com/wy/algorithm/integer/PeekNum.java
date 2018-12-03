package com.wy.algorithm.integer;

/**
 * ClassName PeekNum
 * Date 2018/12/2
 *
 * @author wangyi
 **/
public class PeekNum {

    public static  int findPeakElement(int[] nums) {

        int n = nums.length;

        int last = Integer.MIN_VALUE;
        int cur  = Integer.MIN_VALUE;
        int next = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){

            if(i >=1){
                last = nums[i-1];
            }

            cur = nums[i];
            if(i<n-1){
                next = nums[i+1];
            }


            if(cur > last && cur >next){
                return i;
            }

        }
        return 0;
    }

    public static void main(String[] args) {

        findPeakElement(new int[]{1,2});
    }
}
