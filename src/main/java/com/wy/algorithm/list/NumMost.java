package com.wy.algorithm.list;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ClassName NumMost
 * Date 2018/11/16
 *
 * @author wangyi
 **/
public class NumMost {

    public int atMostNGivenDigitSet(String[] D, int N) {


        int result =0;

        for(int i=0; i< Integer.toString(N).length(); i++){

            int c =  countNum(D, i, Integer.toString(N));
            System.out.println(c);
            result += c;
        }

        return result;
    }

    public int countNum(String[] D, int k, String sMax){



        if(sMax.equals("0")){
            return 0;
        }

        // 排列出的长度小于
        if(sMax.length() >k){
            return (int)Math.pow(D.length, k);
        }

        int count =0;
        for(int i=0; i< D.length; i++){
            int char0 = Integer.parseInt(sMax.charAt(0)+"");
            if(Integer.parseInt(D[i]) < char0){
                count += countNum(D, k-1, sMax);
            }

            if(Integer.parseInt(D[i]) == char0){

                if(sMax.length() >1){
                    int charRem = Integer.parseInt(sMax.substring(1, 2)) ==0? 0: Integer.parseInt(sMax.substring(1));
                    count += countNum(D, k-1, Integer.toString(charRem));

                }else{
                    count ++;
                }
            }

        }

        return count;
    }


    //
    // D = ["1","3","5","7"], N = 100
    public static void main(String[] args) {

//        int r = new NumMost().atMostNGivenDigitSet(new String[]{"1","3","5","7"}, 100);
//        System.out.println(r);

        System.out.println(1234^5678);


    }


}
