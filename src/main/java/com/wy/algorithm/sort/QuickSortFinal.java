package com.wy.algorithm.sort;

public class QuickSortFinal {




    private void sort(int[] nums, int left, int right ) {

        if (left > right) {
            return;
        }

//        int p = partition(nums);
//
//        sort(nums, 0, p);
//        sort(nums, p, nums.length);

    }


    private int partition(int[] nums, int left, int right) {

        if (left == right) {
            return left;
        }
        int pivotIndex = left;
        int pivot = nums[left];

        while (left < right) {
            while (left < right && nums[left] <= pivot) {
                left ++;
            }
            while (left <right && nums[right] >= pivot) {
                right --;
            }

            if (left < right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }
        }

        int tmp = nums[left];
        nums[left] = nums[pivotIndex];
        nums[pivotIndex] = tmp;

        return left;
    }

    public static void main(String[] args) {

        QuickSortFinal quickSortFinal = new QuickSortFinal();

        int[] testArr = new int[]{4,3,6,5,3,12,3,9,10, 21,14};
        int s = quickSortFinal.partition(testArr, 0, testArr.length);
        System.out.println(s);

    }
}
