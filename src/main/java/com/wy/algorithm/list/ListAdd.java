package com.wy.algorithm.list;

import com.wy.algorithm.base.ListNode;

import java.util.Stack;

/**
 * ClassName ListAdd
 * Date 2018/11/30
 *
 * @author wangyi
 **/
public class ListAdd {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<Integer> stackOne = new Stack<Integer>();
        Stack<Integer> stackTwo = new Stack<Integer>();

        while(null != l1){
            stackOne.push(l1.val);
            l1 = l1.next;
        }

        while(null != l2){
            stackTwo.push(l2.val);
            l2 = l2.next;
        }
        int carry =0;
        ListNode res = null;
        while(!stackOne.isEmpty() && !stackTwo.isEmpty()){

            int aTemp = stackOne.pop();
            int bTemp = stackTwo.pop();
            int subTemp = aTemp + bTemp+ carry;
            carry = subTemp /10;
            int currentVal = subTemp %10;
            ListNode tempRes = new ListNode(currentVal);
            if(res == null){
                res = tempRes;
            }else{
                tempRes.next = res;
                res = tempRes;
            }
        }

        while(!stackOne.isEmpty()){
            int aTemp = stackOne.pop();
            int subTemp = aTemp + carry;
            carry = subTemp /10;
            int currentVal = subTemp %10;

            ListNode tempRes = new ListNode(currentVal);
            if(res == null){
                res = tempRes;
            }else{
                tempRes.next = res;
                res = tempRes;
            }
        }

        while(!stackTwo.isEmpty()){
            int aTemp = stackTwo.pop();
            int subTemp = aTemp + carry;
            carry = subTemp /10;
            int currentVal = subTemp %10;

            ListNode tempRes = new ListNode(currentVal);
            if(res == null){
                res = tempRes;
            }else{
                tempRes.next = res;
                res = tempRes;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        ListNode a = new ListNode(7);
        ListNode a1 = new ListNode(2);
        ListNode a2= new ListNode(4);
        ListNode a3 = new ListNode(3);
        a.next = a1;
        a1.next = a2;
        a2.next = a3;


        ListNode b = new ListNode(5);
        ListNode b1 = new ListNode(6);
        ListNode b2= new ListNode(4);
        b.next = b1;
        b1.next = b2;



        ListNode s = new ListAdd().addTwoNumbers(a, b);

        while(s != null){
            System.out.println(s.val);
            s = s.next;
        }

    }
}
