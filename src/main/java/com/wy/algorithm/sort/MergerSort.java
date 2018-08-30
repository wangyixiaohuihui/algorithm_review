package com.wy.algorithm.sort;

import java.util.Arrays;

/**
 * ClassName MergerSort
 * Date 2018/8/30
 * 归并排序
 * @author wangyi
 **/
public class MergerSort {




    private static void sort(int a[], int left, int right, int[] temp){

        if(left <right){
            int mid = (left + right) /2;

            sort(a, left, mid,temp);

            sort(a, mid+1, right, temp);

            merge(a, left, mid, right, temp);
        }

    }


    private static void merge(int[] a, int left, int mid, int right, int[] temp ){


        int i = left;
        int j = mid+1;
        int t =0;

        while ( i<= mid && j <= right){
            if(a[i] <= a[j]){
                temp[t] =a[i];
                t++;
                i++;
            }else {
                temp[t] = a[j];
                t++;
                j++;
            }
        }

        while (i <= mid){
            temp[t++] = a[i++];
        }
        while (j <= right){
            temp[t++] = a[j++];
        }

        t =0;
        while (left <= right){
          a[left++] = temp[t++];
        }
    }


    public static void main(String[] args) {

        int []arr = {9,8,7,6,5,4,3,2,1};

        //在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        int []temp = new int[arr.length];

        sort(arr,0,arr.length-1,temp);

        System.out.println(Arrays.toString(arr));
    }

}
