package com.wy.algorithm.sort;

import java.util.*;

/**
 * @author by wangyi
 * @classname QuickSort3
 * @description TODO
 * @date 2020/8/4 20:36
 */
public class QuickSort3 {

    private int partition(int[] nums, int start, int end) {

        int pivot = nums[start];
        int copyStart = start;

        while (start < end) {
            while (start < end && nums[end] >= pivot) {
                end --;
            }
            while (start < end && nums[start] <= pivot) {
                start ++;
            }
            if (start < end) {
                int tmp = nums[start];
                nums[start] =nums[end];
                nums[start] = tmp;

            }
        }
        int tmp = nums[start];
        nums[start] = nums[copyStart];
        nums[copyStart] = tmp;
        return start;
    }

    public void quickSort(int[] nums, int start, int end) {

        if (start > end) {
            return ;
        } else  {
            int mid = partition(nums, start, end);
            quickSort(nums, start, mid -1);
            quickSort(nums, mid+1, end);
        }

    }

    public static void main(String[] args) {

        int[] nums = new int[]{5,4,4,3,7,8,9,11,25};

        new QuickSort3().quickSort(nums, 0, nums.length-1);

        System.out.println(Arrays.toString(nums));

    }

}
