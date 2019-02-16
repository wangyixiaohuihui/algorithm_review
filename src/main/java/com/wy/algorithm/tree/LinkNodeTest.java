package com.wy.algorithm.tree;

/**
 * ClassName LinkNodeTest
 * Date 2018/9/27
 *
 * @author wangyi
 **/
public class LinkNodeTest {


    public static  ListNode rotateRight(ListNode head, int k) {
        ListNode temp = head;

        int linkCount =0;

        if(null == head){
            return null;
        }else{
            linkCount =1;
        }
        while(null != temp.next){
            temp = temp.next;
            linkCount ++;
        }
        temp.next = head;
        int step = k % linkCount;
        for(int i=0; i< linkCount-step; i++){
            temp = temp.next;
        }
        head = temp.next;

        temp.next = null;

        return head;
    }


    public static void main(String[] args) {

        ListNode a = new ListNode(1);

        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);


        a.next = b;
        b.next =c;
        c.next = d;
        d.next = e;
        e.next = null;

        ListNode r = rotateRight(a, 2);

        while (null != r.next){
            System.out.println(r.val);

            r = r.next;
        }
    }

}


class ListNode {
      int val;
     ListNode next;
     ListNode(int x) { val = x; }
}