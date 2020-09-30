package com.wy.algorithm.tree;

/**
 * ClassName TreeUtils
 * Date 2019/9/30
 *
 * @author wangyi
 **/

public class TreeUtils {


    // [3,5,1,6,2,0,8,null,null,7,4]
    //5
    //1

    public static TreeNode arrayToTree(Integer[] array){
        return createBinaryTreeByArray(array,0);
    }


    private static TreeNode createBinaryTreeByArray(Integer[] array, int index){
        TreeNode tn = null;
        if (index < array.length) {
            Integer value = array[index];
            if (value == null) {
                return null;
            }
            tn = new TreeNode(value);
            tn.left = createBinaryTreeByArray(array, 2*index+1);
            tn.right = createBinaryTreeByArray(array, 2*index+2);
            return tn;
        }
        return tn;
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{3,5,1,6,2,0,8,null,null,7,4};
        TreeNode  root = arrayToTree(array);
        System.out.println(root.val);
    }

}

