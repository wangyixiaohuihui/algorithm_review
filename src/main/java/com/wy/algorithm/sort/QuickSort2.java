package com.wy.algorithm.sort;

/**
 * ClassName QuickSort2
 * Date 2018/9/30
 *
 * @author wangyi
 **/
public class QuickSort2 {

    //  手写快速排序算法
    private static void sort(int[] nums, int start, int end){

        if(start > end){
            return ;
        }else{
            int mid = quick(nums,start,end);
            sort(nums, start, mid-1);
            sort(nums, mid+1, end);
        }
    }

    private static int quick(int[] nums, int start, int end){

        int guard = nums[start];
        while(start < end){

            if(start < end && nums[end]>= guard){
                end --;
            }
            if(start < end){
                nums[start] = nums[end];
                start ++;
            }

            if(start < end && nums[start]<= guard){
                start ++;
            }
            if(start < end){
                nums[end] = nums[start];
                end --;
            }
        }
        if(start <= end){
            nums[start] = guard;
        }

        return start;
    }

    public static void main(String[] args) {


        int[]   s = new int[]{1,4,3,2};

        QuickSort2.sort(s, 0, 3);


//        int sum =0;
//        for(int i=0; i< s.length; i+=2){
//            sum = sum + s[i];
//        }


        for(int a: s){
            System.out.print(" "+a);
        }
        System.out.println();

//        System.out.println(sum);
    }


}
