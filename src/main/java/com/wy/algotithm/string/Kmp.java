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

        int[] next = new int[patternString.length()];
        next[0] = -1;
        int k= -1;
        int j=0;
        while(j <len -1){

            if( k == -1 || patternString.charAt(j) == patternString.charAt(k)){
                ++k;
                ++j;

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



    public static void main(String[] args) {
        //计算模式串

        int[] next = Kmp.calcNext("abshab");

        System.out.println("abshab");
        for(int r: next){
            System.out.print(r + "  ");
        }

        //kmpSearch("hgdsahsahdjksa", "sahsa");

    }


}
