package com.wy.algotithm.string;

/**
 * ClassName Kmp
 * Date 2018/8/24
 *
 * @author wangyi
 **/
public class Kmp {


    /**
     *  计算next 数组
     * @param patternString 模式串
     */
    private static int[] calcNext(String patternString){

        int len = patternString.length();

        int[] next = new int[len];
        next[0] = -1;
        int k= -1;
        int j=0;

        while( j <len -1){

            if( k == -1 || patternString.charAt(j) == patternString.charAt(k)){
                k++;
                j++;

                if(patternString.charAt(j) != patternString.charAt(k)){
                    next[j] =k;
                }else {
                    next[j] = next[k];
                }
                System.out.println("next[j]:"+j+" ="+k);
            }else {

                System.out.println("p(j)="+ patternString.charAt(j)
                        + "   p(k)="+patternString.charAt(k)+ "  k=next[k]  "+ k +"=="+next[k]);
                k = next[k];
            }

        }
        return next;
    }


    /**
     * 计算next 函数
     * @param patternString 匹配串
     * @return next数组
     */
    private static int[] calNext(String patternString){

        int patternLen = patternString.length();

        int[] prefixTable = new int[patternLen];

        prefixTable[0] =0;

        int len =0;
        int i=1;

        while(i < patternLen){

            if(patternString.charAt(len) == patternString.charAt(i)){
                len ++;
                prefixTable[i] = len;
                i++;

            }else{

                if(len >0){
                    len = prefixTable[len-1];
                }else{
                    prefixTable[i] = len;
                    i++;
                }

            }

        }

        return prefixTable;
    }


    /**
     * 匹配字符串
     * @param gSearch 字符串
     * @param pattern 匹配串
     */
    private static  void kmpSearch(String gSearch, String pattern){

        int ans =-1;
        int i = 0;
        int j =0;

        int[] next = calcNext(pattern);

        while(i < gSearch.length()){

            if(j ==-1 || gSearch.charAt(i) == pattern.charAt(j)){

                ++i;
                ++j;
            }else {
                j = next[j];
            }
            if(j == pattern.length()){
                ans = i - pattern.length();
                break;
            }
        }
        System.out.println("find:"+ ans);

    }


    public static  int searchString(String searchString, String pattern){


        if(null == searchString ||  null ==pattern){
            return -1;
        }
        if(pattern.equals("")){
            return 0;
        }


        int[] prefixTable = calNext(pattern);

        int len = pattern.length();
        int sLen =0;

        int startIndex = 0;
        int matchIndex =0;
        boolean firstMatch = true;

        while(sLen< searchString.length()){

            if(searchString.charAt(sLen) == pattern.charAt(matchIndex)){

                matchIndex ++;

                if(firstMatch){
                    startIndex = sLen;
                    firstMatch = false;
                }

                if(matchIndex == len){
                    return startIndex;
                }


            }else{
                matchIndex = prefixTable[matchIndex];
                firstMatch = true;
            }
            sLen ++;

        }
        return matchIndex;
    }






    public static void main(String[] args) {
        //计算模式串

//        int[] next = Kmp.calcNext("ababcabaa");
//
//        int[] next2 = Kmp.calNext("ababcabaa");
//
//        System.out.println("abshab");
//        for(int r: next){
//            System.out.print(r + "  ");
//        }
//
//        System.out.println("======================");
//
//        for(int r: next2){
//            System.out.print(r + "  ");
//        }
//        //kmpSearch("hgdsahsahdjksa", "sahsa");

//         System.out.println(searchString("erfababcababghababcabaads", "ababcabaa"));

        System.out.println(searchString("mississippi", "issip"));


    }


}
