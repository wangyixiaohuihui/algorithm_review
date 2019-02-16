package com.wy.algorithm.list;

import com.wy.algorithm.base.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName AddTwoList
 * Date 2018/9/28
 *
 * @author wangyi
 **/
public class AddTwoList {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head =null;
        ListNode curNode =null;
        int decade  =0;



        while(null !=l1 || null != l2){
            int l1Temp=0;
            int l2Temp =0;
            if(null != l1){
                l1Temp = l1.val;
            }
            if(null != l2){
                l2Temp = l2.val;
            }

            int tempSum = l1Temp + l2Temp + decade;

            decade = tempSum / 10;
            int units = tempSum %10;
            ListNode tmpNode = new ListNode(units);
            if(null == head){
                head = tmpNode;
                curNode = head;
            }else{
                curNode.next = tmpNode;
                curNode =curNode.next;
            }

            if(null != l1){
                l1 = l1.next;
            }
            if(null != l2){
                l2 = l2.next;
            }


        }

        if(decade !=0){
            ListNode tmpNode = new ListNode(decade);
            curNode.next = tmpNode;
        }

        return head;
    }


    public static void main(String[] args) {



        ListNode a = new ListNode(9);

        ListNode b = new ListNode(8);

        ListNode c = new ListNode(1);


        a.next = b;

        Set<Character> jSet = new HashSet<Character>();
        String J2 ="dsa";

        for(int i=0; i<J2.length();  i++){
            jSet.add(J2.charAt(i));
        }

        ListNode r = addTwoNumbers(a, c);

        while (null != r){
            System.out.println(r.val);
            r = r.next;
        }

    }
}
