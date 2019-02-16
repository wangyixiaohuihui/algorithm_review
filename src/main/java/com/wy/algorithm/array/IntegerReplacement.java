package com.wy.algorithm.array;

/**
 * ClassName IntegerReplacement
 * Date 2019/1/29
 *
 * @author wangyi
 **/
public class IntegerReplacement {


    public static int integerReplacement(int n) {
        int step =0;

        if(n == Integer.MAX_VALUE){
            return 32;
        }

        while(n!=1){
            if((n & 1)==0){
                n = n >>1;
            }else if (n ==3 || ((n>>1) &1)==0){
                n--;
            } else{
                n++;
            }
            step ++;
        }
        return step;
    }

    // you need treat n as an unsigned value
    public int reverseBits(int n) {

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            // CATCH: must do unsigned shift
            n >>>= 1;
            // CATCH: for last digit, don't shift!
            if (i < 31){
                result <<= 1;
            }

        }
        return result;
    }


    public static void main(String[] args) {
        // IntegerReplacement.integerReplacement(7);

        System.out.println((7>>1) &1);
    }
}
