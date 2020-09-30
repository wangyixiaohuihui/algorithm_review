package com.wy.algorithm.math;


import java.util.*;
import java.util.regex.Pattern;

/**
 * ClassName NthNum
 * Date 2019/8/6
 *
 * @author wangyi
 **/
public class NthNum {
    public int findNthDigit(int n) {

        int baseLen = 1;
        long baseCount = 9;
        int start = 1;

        while (n > baseLen * baseCount) {
            n -= baseLen * baseCount;
            baseLen +=1;
            baseCount = baseCount *10;
            start = start *10;
            System.out.println("-------:"+start);
        }
        System.out.println("-------:"+n);
//        System.out.println("-------:"+baseLen);
//        System.out.println("-------:"+start);
//        System.out.println("-------:"+baseCount);

        start += (n -1)/baseLen;
        String s = Long.toString(start);
        return Character.getNumericValue(s.charAt((n-1)%baseLen));

    }


    public int thirdMax(int[] nums) {

        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer n : nums) {
            if (n.equals(max1) || n.equals(max2) || n.equals(max3)){
                continue;
            }
            if (max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }
        return null == max3? max1 : max3;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {

        // 给元素赋值正负 表达额外的信息, 遍历元素，把与元素值相等的那个索引对应的元素赋值为负数
        // 然后再遍历一遍数组，如果某个索引对应的元素值为正数，说明这个索引值在数据中不存在。
        List<Integer> ret = new ArrayList<Integer>();
        for (int i=0; i<nums.length; i++) {
            int val =  Math.abs(nums[i]-1);
            if(nums[val] >0){
                nums[val] = -nums[val];
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int currentLen =1;
        int maxLen =1;
        int consecutiveNum = nums[0];
        if(consecutiveNum ==0){
            currentLen =0;
            maxLen =0;
        }

        for(int i=1; i< nums.length; i++) {
            if(nums[i] ==0){
                consecutiveNum = nums[i];
                if(currentLen >maxLen){
                    maxLen = currentLen;
                }
                currentLen =0;
                continue;
            }
            if(nums[i] -consecutiveNum ==0){
                currentLen ++;
            }else {
                if(currentLen > maxLen){
                    maxLen = currentLen;
                }
                currentLen =1;
                consecutiveNum = nums[i];
            }
        }
        return maxLen;
    }

    public int[][] matrixReshape(int[][] nums, int r, int c) {

        int rowLen = nums.length;
        int colLen = nums[0].length;

        if(rowLen * colLen != r * c ){
            return nums;
        }

        int newI=0;
        int newJ=0;

        int[][] result = new int[r][c];

        for(int i=0; i< rowLen; i++){

            for(int j=0; j<colLen; j++) {

                if(newJ == c){
                    newJ = 0;
                    newI += 1;
                }
                result[newI][newJ] = nums[i][j];
                newJ ++;
            }
        }
        return result;
    }


    // [[1],[2],[3],[4]]
    //2
    //2

    public int findUnsortedSubarray(int[] nums) {

        int n = nums.length;
        int beg = -1;
        int end = -2;
        int min = nums[n - 1];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            // 从头开始 记录当前访问的最大值
            max = Math.max(max, nums[i]);
            // 从尾开始 记录当前访问的最小值
            min = Math.min(min, nums[n - 1 - i]);
            if (nums[i] < max) {
                end = i;
            }
            if (nums[n - 1 - i] > min) {
                beg = n - 1 - i;
            }
            System.out.println("s:"+ end +"    :"+beg);
        }
        return end - beg + 1;

    }


    public List<List<Integer>> largeGroupPositions(String S) {


        List<List<Integer>> result= new ArrayList<List<Integer>>();

        Map<Character, int[]>  groupMap = new HashMap<Character, int[]>();

        for(int i=0; i<S.length(); i++) {
            char currentChar = S.charAt(i);

            if(!groupMap.containsKey(currentChar)){
                groupMap.put(currentChar, new int[]{1,i,i});
            }else {
                int[] currentCount = groupMap.get(currentChar);
                currentCount[0]++;
                currentCount[2]=i;
                groupMap.put(currentChar,currentCount);
            }
        }

        for(int[] value :groupMap.values()){

            if(value[0] >=3){
                List<Integer> se = new ArrayList<>();
                se.add(value[1]);
                se.add(value[2]);
                result.add(se);
            }
        }
        return result;
    }

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {

        int queryLen = queries.length;
        int n = A.length;
        int[] res = new int[queryLen];

        for(int i=0; i< queryLen; i++) {

            int index = queries[i][0];
            int addNum = queries[i][1];

            A[index] = A[index] + addNum;

            for(int j=0; j<n; j++) {
                if(A[j]%2 ==0){
                    res[i] += A[j];
                }
            }
        }
        return res;
    }

    public List<String> commonChars(String[] A) {

        List<String> commonList = new ArrayList<String>();
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();

        for(String currentA :A){

            for(int i=0; i< currentA.length(); i++) {

                Integer tmpCount = charMap.get(currentA.charAt(i));
                if(null == tmpCount){
                    charMap.put(currentA.charAt(i), 1);
                }else if(2 == tmpCount){
                    commonList.add(String.valueOf(currentA.charAt(i)));
                    charMap.remove(currentA.charAt(i));
                }else {
                    charMap.put(currentA.charAt(i), tmpCount+1);
                }
            }
        }
        return commonList;
    }

    public String[] findWords(String[] words) {

        ArrayList<String> result = new ArrayList<String>();
        Pattern matRegx = Pattern.compile("^[qwertyuiop]*$|^[asdfghjkl]*$|^[zxcvbnm]*$");


        for(int i=0; i<words.length; i++) {

            String currentStr = words[i];
            boolean matherStr = matRegx.matcher(currentStr).find();
            if(matherStr){
                result.add(currentStr);
            }
        }

        return result.toArray(new String[result.size()]);
    }

    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        Map<Character, List<Integer>> map = new HashMap();

        for (int i = 0; i < t.length(); i++) {
            List<Integer> idx = map.getOrDefault(t.charAt(i), new ArrayList());
            idx.add(i);
            map.put(t.charAt(i), idx);
        }

        int lastFound = -1;
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                return false;
            }

            List<Integer> idxList = map.get(s.charAt(i));
            int idx = binSearchHelper(idxList, lastFound);
            if (idx == -1) {
                return false;
            }
            lastFound = idx;
        }

        return true;
    }

    private int binSearchHelper(List<Integer> idxList, int lastFound) {
        int start = 0;
        int end = idxList.size() - 1;
        int result = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (idxList.get(mid) > lastFound) {
                result = idxList.get(mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        return result;
    }

    // 异或计算  相同的元素异或为0
    // 0和一个数异或之后为 那个数
    // 异或运算满足交换律
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i=0; i<nums.length; i++){
            result ^= nums[i];
            System.out.println("num:  "+result);
        }
        return  result;
    }



    public static void main(String[] args) {
        // new NthNum().thirdMax(new int[]{2,2,3,1});
//
//        List<Integer> forList = new ArrayList<Integer>();
//
//        forList.add(0, 1);
//
//        Arrays.stream(new int[]{0,0}).sum();
//
//
//
//        int[][] a = new int[][]{{1},{2},{3},{4}};
//
//        new NthNum().commonChars(new String[]{"bella","label","roller"});


//        new NthNum().isSubsequence("abc","ahbgdc");

//        new NthNum().singleNumber(new int[]{4,1,2,1,2});

//        int a =8;
//        int b=2;
//
//        a = a^b;
//        int diff = a^b;
//        System.out.println("diff:"+diff);
//        b = a^b;
//        a = a^b;
//        System.out.println(a);
//        System.out.println(b);
        int[][] intervals = new int[][]{{5,1},{1,2},{4,3},{3,1}};
        Arrays.sort(intervals, (a, b)->a[0]<=b[0]?-1:1);

//        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));

        for (int i=0; i<intervals.length; i++){
//            for(int j=0; j<intervals[0].length; j++) {

                System.out.println("===="+intervals[i][0]);
//            }
        }

        int x=5;
        x+=2;
        System.out.println(x);
    }


}