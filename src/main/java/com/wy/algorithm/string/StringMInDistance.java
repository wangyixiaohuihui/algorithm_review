package com.wy.algorithm.string;

/**
 * ClassName StringMInDistance
 * Date 2018/9/4
 *
 * @author wangyi
 **/
public class StringMInDistance {

    public static  int minDistance(String word1, String word2) {

        char[] word1CharArray = word1.toCharArray();
        char[] word2CharArray = word2.toCharArray();

        int word1Len = word1CharArray.length;
        int word2Len = word2CharArray.length;


        if(word1Len == 0){
            return word2Len;
        }
        if(word2Len == 0){
            return  word1Len;
        }

        int dp[][] = new int[word1Len][word2Len];

        //是否已经有相等
        boolean isEquals = false;

        for(int i=0; i<word1Len; i++){

            if(word1CharArray[i] == word2CharArray[0] && !isEquals){
                if(i == 0){
                    dp[i][0] = 0;
                }else {
                    dp[i][0] = dp[i-1][0];
                }
                isEquals = true;
            }else{
                if(i == 0){
                    dp[i][0] = 1;
                }else {
                    dp[i][0] = dp[i-1][0] +1;
                }
            }

        }

        isEquals = false;

        for(int j=0; j<word2Len; j++){

            if(word1CharArray[0] == word2CharArray[j] && !isEquals){
                if(j == 0){
                    dp[0][j] = 0;
                }else {
                    dp[0][j] = dp[0][j-1];
                }
                isEquals = true;
            }else{
                if(j == 0){
                    dp[0][j] = 1;
                }else {
                    dp[0][j] = dp[0][j-1] +1;
                }
            }

        }

        for(int i=1; i<word1Len; i++){

            for(int j=1; j<word2Len; j++){

                if(word1CharArray[i] == word2CharArray[j]){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    int tempMin =  Math.min(dp[i][j-1], dp[i-1][j]);
                    dp[i][j] = Math.min(tempMin, dp[i-1][j-1]) +1;
                }
            }
        }
        return dp[word1Len-1][word2Len-1];
    }



    public static int minDistanceNew(String word1, String word2) {
        //边界条件
        if(word1.length() == 0){
            return word2.length();
        }
        if(word2.length() == 0){
            return word1.length();
        }
        /*
         * 本题用动态规划的解法
         * f[i][j]表示word1的前i个单词到word2前j个单词的最短距离
         * 状态转移方程：f[i][j] =
         */

        int[][] f = new int[word1.length()][word2.length()];

        //是否已经有相等
        boolean isEquals = false;

        for(int i = 0 ; i < word2.length(); i++){

            //如果相等，则距离不增加
            if(word1.charAt(0) == word2.charAt(i) && !isEquals){

                //不能从0开始
                f[0][i] = i > 0 ? f[0][i-1]:0;
                isEquals = true;
            }else{
                f[0][i] = i > 0 ? f[0][i-1]+1:1;
            }
        }
        //是否已经有相等
        isEquals = false;
        for(int i = 1 ; i < word1.length(); i++){
            //如果相等，则距离不增加
            if(word1.charAt(i) == word2.charAt(0) && !isEquals){
                //不能从0开始
                f[i][0] =  f[i-1][0];
                isEquals = true;
            }else{
                f[i][0] = f[i-1][0]+1;
            }
        }

        for(int i = 1; i < word1.length();i++){
            for(int j = 1; j < word2.length(); j++){
                if(word1.charAt(i) == word2.charAt(j)){
                    //相等的话直接相等
                    f[i][j] = f[i-1][j-1];
                }else{
                    f[i][j] = f[i-1][j-1]+1;
                }
                //然后与从f[i-1][j]+1，f[i][j-1]+1比较，取最小值
                f[i][j] = Math.min(f[i][j],Math.min(f[i-1][j]+1,f[i][j-1]+1));
            }
        }
        return f[word1.length()-1][word2.length()-1];
    }



    public static void main(String[] args) {

        int s = StringMInDistance.minDistance("pneumonoultramicroscopicsilicovolcanoconiosis", "ultramicroscopically");

        System.out.println(s);
    }

}
