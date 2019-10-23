package com.wy.algorithm.string;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName GenerateBracket
 * Date 2018/8/27
 * 括号生成
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 例如，给出 n = 3，生成结果为：
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 * @author wangyi
 **/
public class GenerateBracket {

    public List<String> generateParenthesis(int n){

        List<String> combination = new ArrayList<String>();

        generateAll(new char[2*n], 0, combination);

        return combination;
    }


    public void generateAll(char[] currents, int pos, List<String> result){

        if(pos == currents.length && validate(currents) ){

            result.add(new String(currents));
        }else {
            currents[pos] = '(';
            generateAll(currents, pos+1, result);
            currents[pos] =')';
            generateAll(currents,pos +1, result);

        }


    }


    public boolean validate(char[] currents){

        int balance =0;

        for(char c:currents){
            if(c == '('){
                balance ++;
            }else{
                balance --;
            }
            if(balance <0){
                return false;
            }
        }
        return  balance ==0;
    }



    // 方法 三  闭合数

    public List<String> generateParenthesis2(int n){

        List<String> ans = new ArrayList<String>();
        if(n ==0){
            ans.add("");
        }else {
            for(int c=0; c < n; c++){
                for(String left: generateParenthesis2(c)){
                   for(String right:generateParenthesis2(n-1-c)){
                       ans.add("("+left+")"+right);
                   }
                }
            }
        }
        return ans;
    }


    // 方法三
    public List<String> generateParenthesis3(int n) {
        List<String> list = new ArrayList<String>();
        backtrack2(list,"",0,0,n);
        return list;
    }


    private void backtrack2(List<String> list, String temp,int left,int right,int n){
        if(left>n || right > left || right > n){
            return;
        }
        if(left ==n && right == n){
            System.out.println("add:"+temp);
            list.add(temp);
            return;
        }
        System.out.println("left:"+left+"  right:"+right);
        backtrack2(list,temp+"(",left+1,right,n);
        backtrack2(list,temp+")",left,right+1,n);
    }




    public static void main(String[] args) {

        //List<String> generateList = new GenerateBracket().generateParenthesis(3);
        // List<String> generateList = new GenerateBracket().generateParenthesis2(2);
        List<String> generateList = new GenerateBracket().generateParenthesis3(2);
        System.out.println(generateList.toString());
        System.out.println(Integer.MAX_VALUE);
    }

}
