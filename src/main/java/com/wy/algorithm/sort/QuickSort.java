package com.wy.algorithm.sort;

/**
 * ClassName QuickSort
 * Date 2018/8/30
 *
 * @author wangyi
 **/
public class QuickSort {


    public static int quickSortMid(int s[], int left, int right){

        int key = s[left];

        //System.out.println("key:"+key);
        while(left < right){

            while(left < right && s[right] >= key){
                right --;
            }
            if(left < right){
                s[left] = s[right];
                left ++;
            }

            while (left <right && s[left] <= key){
                left ++;
            }

            if(left < right){
                s[right] = s[left];
                right --;
            }
        }
        if(left <= right){
            s[left] = key;
        }

       return  right;
    }


    public static void sort(int[] s, int start, int end){

        if(start > end){
            return;
        }else {

            int pos = quickSortMid(s, start, end );

            sort(s, start, pos-1);

            sort(s, pos+1, end);
        }


    }

    public static void main(String[] args) {

        int[]   s = new int[]{5,2,4,6,7,3};

        QuickSort.sort(s, 0, 5);

        for(int a: s){
            System.out.print(" "+a);
        }
    }

}
