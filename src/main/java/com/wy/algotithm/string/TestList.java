package com.wy.algotithm.string;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName TestList
 * Date 2018/9/19
 *
 * @author wangyi
 **/
public class TestList {


    public List<Integer> listNodeId(Node node) {
        List<Integer> ids = new ArrayList();
        if(node==null){
            //没有此判断扣一分
            return ids;
        }
        ids.add(node.id);
        for(Node child : node.children){
            ids.addAll(this.listNodeId(child));
        }
        return ids;
    }


    public static void main(String[] args) {


    }

}


class Node {
    public Integer id;
    public List<Node> children;
}