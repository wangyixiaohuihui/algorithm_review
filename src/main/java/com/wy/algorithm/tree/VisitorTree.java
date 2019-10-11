package com.wy.algorithm.tree;

import java.util.Stack;

/**
 * ClassName VisitorTree
 * Date 2019/5/8
 *
 * @author wangyi
 **/
public class VisitorTree {

    private TreeNode finalPrev;



    public TreeNode increasingBST(TreeNode root) {


        return increasingBST(root, null);

    }



    public TreeNode increasingBST(TreeNode root, TreeNode tail) {
        if (root == null){
            return tail;
        }
        System.out.println("111111->current root:"+ root +"    tail："+tail);

        TreeNode res = increasingBST(root.left, root);
        System.out.println("2222222->current root:"+ root.left  +"    root："+root +"     res:"+res);

        root.left = null;
        System.out.println("3333333333->current root:"+ root +"    tail："+tail);

        root.right = increasingBST(root.right, tail);
        System.out.println("4444444444->root.right :"+ root.right +"    tail："+tail);

        System.out.println("55555===:"+res);
        return res;




    }

    public static void main(String[] args) {

//        TreeNode a1 = new TreeNode(1);
//        TreeNode a2 = new TreeNode(2);
//        TreeNode a3= new TreeNode(3);
//        TreeNode a4= new TreeNode(4);
//        TreeNode a5= new TreeNode(5);
//        TreeNode a6= new TreeNode(6);
//        TreeNode a7= new TreeNode(7);
//        TreeNode a8= new TreeNode(8);
//        TreeNode a9= new TreeNode(9);
//        TreeNode a10= new TreeNode(10);
//
//        a5.left = a3;
//        a5.right = a6;
//
//        a3.left = a2;
//        a3.right =a4;
//
//        a2.left =a1;
//
//        a6.right =a8;
//
//        a8.left =a7;
//        a8.right = a9;
//
//
//        new VisitorTree().increasingBST(a5);

//        new VisitorTree().isValid("(]");
//        Integer.parseInt();



        System.out.println( "1234".substring(1,2));

        System.out.println(" ".split(" ").length);
    }



    public boolean isValid(String s) {

        int len = s.length();
        if(len ==0){
            return true;
        }

        Stack<Character> bracket = new Stack<Character>();

        for(int i=0; i<len; i++){
            char curChar = s.charAt(i);
            if(curChar == '(' || curChar =='[' || curChar =='{'){
                bracket.push(curChar);
            }else {
                if(bracket.size() ==0){
                    return false;
                }
                char preBracket = bracket.pop();
                if((curChar == '(' && preBracket !=')')
                        || (curChar == '[' && preBracket !=']')
                        || (curChar == '{' && preBracket !='}')
                        ){
                    return  false;
                }
            }
        }
        return (bracket.size() ==0);

    }

}
