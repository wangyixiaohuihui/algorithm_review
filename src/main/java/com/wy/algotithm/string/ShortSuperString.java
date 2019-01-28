package com.wy.algotithm.string;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName ShortSuperString
 * Date 2018/12/20
 *
 * @author wangyi
 **/
public class ShortSuperString {




    public static int calc(String a, String b) {
        for (int i = 1; i < a.length(); i++) {
            if (b.startsWith(a.substring(i))) {
                return b.length() - a.length() + i;
            }
        }
        return b.length();
    }


    public static int titleToNumber(String s) {

        int len = s.length();
        int weight =0;
        int num=0;
        for(int i=len-1; i>=0; i--){
            int n = s.charAt(i)-65+1;
            weight =(len-i-1);
            num += n + 26*weight;
        }
        return num;


    }
    public static  int lenLongestFibSubseq(int[] A) {

        int n = A.length;
        int[][] dp = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
               dp[i][j] =2;
            }
        }


        Map<Integer, Integer> lenMap = new HashMap<Integer, Integer>();

        for(int i=0; i<n; i++){
            lenMap.put(A[i], i);
        }
        int ans =0;

        for(int j=0; j<n; j++){

            for(int k=j+1; k<n; k++){

                int ai= A[k] -A[j];
                if(ai>= A[j]){
                    break;
                }
                int index = lenMap.getOrDefault(ai, -1);

                if(index >=0 && index <j){

                    dp[j][k] = dp[index][j] +1;
                    System.out.println("  j:"+j+"   k:"+k +"    d[j][k]"+dp[j][k] +"   i:"+index +"  j:"+j+"   d[i][j]:"+dp[index][j]);
                    ans = Math.max(ans, dp[j][k]);
                }

            }
        }

        return ans;
    }



    public static void main(String[] args) {

//        System.out.println(ShortSuperString.calc("abc","jhgfabcd"));
//        System.out.println(ShortSuperString.calc("abcdjhgf","abc"));
//
//        System.out.println("abc".substring(0));
////        "jhgfabc".startsWith();
//
//        System.out.println((int)'A');



//        System.out.println(titleToNumber("AA"));
//        Arrays.fill(dp, 3);


        //System.out.println(lenLongestFibSubseq(new int[]{1,2,3,4,5}));
        System.out.println( 1e9 +7);
    }


}
