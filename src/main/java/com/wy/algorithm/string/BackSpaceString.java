package com.wy.algotithm.string;

/**
 * ClassName BackSpaceString
 * Date 2019/3/7
 *
 * @author wangyi
 **/
public class BackSpaceString {

    public static boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;

        while (true) {

            for (int back = 0; i >= 0 && (back > 0 || S.charAt(i) == '#'); --i){
                back += S.charAt(i) == '#' ? 1 : -1;
            }

            for (int back = 0; j >= 0 && (back > 0 || T.charAt(j) == '#'); --j){
                back += T.charAt(j) == '#' ? 1 : -1;
            }

            if (i >= 0 && j >= 0 && S.charAt(i) == T.charAt(j)) {
                i--; j--;
            } else{
                return i == -1 && j == -1;
            }
        }
    }

    public static void main(String[] args) {



        // BackSpaceString.backspaceCompare("a##cc#",  "#a#c");

       String a =  "{\"os\":\"Windows 10\",\"p_type\":\"ActiveX\",\"is_debug\":false,\"fp_ver\":\"WIN 32,0,0,101\",\"a_name\":\"Adobe Windows\"}";


        System.out.println(a.contains("\"a_name\":\"Adobe Windows\""));


    }
}
