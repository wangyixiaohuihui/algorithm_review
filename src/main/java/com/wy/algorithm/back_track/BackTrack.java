package com.wy.algorithm.back_track;

import java.util.*;

/**
 * ClassName BrackTrack
 * Date 2019/9/29
 *
 * @author wangyi
 **/
public class BackTrack {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);

        return list;
    }

    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            System.out.println("0000:"+tempList.toString()+ "   current :"+ i);
            backtrack(list, tempList, nums, i + 1);
            System.out.println("1111:"+tempList.toString()+ "   current :"+ i);
            tempList.remove(tempList.size() - 1);
            System.out.println("2222:"+tempList.toString() + "  current :"+ i);
        }
    }


    public static void main(String[] args) {

        Set<List<Integer>> setTmp = new HashSet<List<Integer>>();
        List<Integer> tmpList = new ArrayList<>();
        Set<Integer> ss = new HashSet<Integer>();
        tmpList.add(1);
        tmpList.add(2);
//        tmpList.size();
        int last = tmpList.get(tmpList.size()-1);
        tmpList.remove(tmpList.size() - 1);

        new BackTrack().subsets(new int[]{1,2,3});

        int[][] a = new int[][]{{12,2}};

        int[][] s = a.clone();
    }
}
