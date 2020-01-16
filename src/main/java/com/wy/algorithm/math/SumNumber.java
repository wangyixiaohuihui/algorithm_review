package com.wy.algorithm.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author wangyi
 * @Classname SumNumber
 * @Description TODO
 * @Date 2020/1/15 13:24
 */
public class SumNumber {

    /**
     * 2- 数求和
     *
     * @param nums 数组
     */
    private List<List<Integer>> twoNumberSum(int[] nums, int target) {

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (null == nums) {
            return ans;
        }
        int len = nums.length;
        HashMap<Integer, Integer> numberIndexMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < len; i++) {
            int index = numberIndexMap.getOrDefault(target - nums[i], -1);
            if (index == -1) {
                numberIndexMap.put(nums[i], i);
            } else {
                numberIndexMap.remove(nums[i]);
                List<Integer> tempList = new ArrayList<Integer>();
                tempList.add(index);
                tempList.add(i);
                ans.add(tempList);
            }
        }
        return ans;
    }


    private List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (null == nums) {
            return ans;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {

            int j = i + 1;
            if(nums[i] == nums[j]) {
                continue;
            }
            int k = nums.length-1;
            int target = 0 - nums[i];

            while (j < k) {
                if(nums[j] + nums[k] > target){
                    k --;
                }else if( nums[j] + nums[k] < target){
                    j ++;
                }else {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(i);
                    tempList.add(j);
                    tempList.add(k);
                    ans.add(tempList);
                }
            }
        }
        return ans;
    }
}
