package com.wy.algorithm.sort;

/**
 * ClassName LinkSort
 * Date 2018/8/30
 *
 * @author wangyi
 **/
public class LinkSort {

    public static  ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(null == l1){
            return l2;
        }
        if(null == l2){
            return l1;
        }
        ListNode temp;
        ListNode head;

        if(l1.val <= l2.val){
            head = l1;
            l1 = l1.next;
        }else{
            head = l2;
            l2 = l2.next;
        }
        temp = head;

        while(null != l1 && null != l2){
            if(l1.val <= l2.val){
                temp.next = l1;
                temp = temp.next;
                l1 = l1.next;
            }else {
                temp.next = l2;
                temp = temp.next;
                l2 = l2.next;
            }

        }
        if(null ==l1){
            temp.next =l2;
        }
        if(null == l2){
            temp.next = l1;
        }

        return head;
    }

    public static void main(String[] args) {
        // LinkSort.mergeTwoLists()

        ListNode a1 = new ListNode(1);
//        ListNode a2 = new ListNode(2);
//        ListNode a3 = new ListNode(4);
//        a1.next = a2;
//        a2.next = a3;


        ListNode b1 = new ListNode(2);
//        ListNode b2 = new ListNode(3);
//        ListNode b3 = new ListNode(4);

//        b1.next =b2;
//        b2.next =b3;

        ListNode c1 = mergeTwoLists(a1, b1);

        while (null != c1){

            System.out.println(c1.val);
            c1 = c1.next;
        }




    }

}


class ListNode {
      int val;
     ListNode next;
      ListNode(int x) { val = x; }
}

