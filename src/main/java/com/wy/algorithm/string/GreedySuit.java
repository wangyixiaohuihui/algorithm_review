package com.wy.algotithm.string;

import java.util.Stack;

/**
 * ClassName GreedySuit
 * Date 2019/9/20
 *
 * @author wangyi
 **/
public class GreedySuit {
    public String removeKdigits(String num, int k) {
        Stack<Integer> tmpStack = new Stack<Integer>();


        for(int i=0; i < num.length(); i++) {

            int current = num.charAt(i) - '0';
            while (!tmpStack.isEmpty() && current < tmpStack.peek() && k>0) {
                tmpStack.pop();
                k --;
            }
            tmpStack.push(current);

        }
        while (tmpStack.size() != 0 && k>0){
            tmpStack.pop();
            k --;
        }

        String result = "";
        while (tmpStack.size() >0){
            result = tmpStack.pop()+result;
        }

        while (result.startsWith("0")){
            result = result.substring(1,result.length());
        }

        if(result.equals("")) {
            result ="0";
        }


        return result;
    }

    public static void main(String[] args) {
        System.out.println(new GreedySuit().removeKdigits("10",1));

    }

}
