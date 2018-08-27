package com.wy.algotithm.string;

/**
 * ClassName PalindromeNum
 * Date 2018/8/27
 *
 * 回文数测试
 * @author wangyi
 **/
public class PalindromeNum {


    /**
     * 判断数是否为回文数
     * @param x 数
     * @return 返回是否是回文数
     */
    public boolean isPalindromeNum(int x){


        if(x <0 || (x %10 ==0  && x>0)){
            return false;
        }

        int reverseNum = 0;
        while (x > reverseNum){

            reverseNum = reverseNum * 10 + x % 10;

            x = x /10;
        }

        return x == reverseNum || x == reverseNum/10;
    }


}
