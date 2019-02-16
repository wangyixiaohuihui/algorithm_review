package com.wy.algorithm.array;

/**
 * @author wangyi
 * date: {DATE}
 **/


public class ListNodeTest {


    public ListNode addTwoNumbers2(ListNode l1, ListNode l2){


        int decade =0;
        int bits =0;

        ListNode head;
        ListNode temp;

        if(null == l1) return l2;
        if(null == l2) return l1;

        int key1 = l1.val;
        int key2 = l2.val;
        int res = key1 + key2;

        decade = res /10;
        bits = res % 10;
        head = new ListNode(bits);

        l1 = l1.next;
        l2 = l2.next;

        temp = head;

        System.out.println("val:"+ head.val);

        if(null == l1 &&  null ==l2 && decade != 0){
            ListNode node =new ListNode(decade);
            temp.next =node;
            temp = temp.next;
        }

        while (null != l1 && null != l2){
            int keyTemp1 = l1.val;
            int keyTemp2 = l2.val;

            int res2 = keyTemp1 + keyTemp2 + decade;

            decade = res2 /10;
            bits = res2 % 10;

            temp.next = new ListNode(bits);
            temp = temp.next;

            l1 = l1.next;
            l2 = l2.next;

        }

        while(null != l1){
            int tempBits = l1.val + decade;
            bits = tempBits % 10;

            decade = tempBits /10;

            temp.next = new ListNode(bits);
            temp = temp.next;
            l1 = l1.next;
        }
        while(null != l2){
            int tempBits = l2.val + decade;

            decade = tempBits /10;
            bits = tempBits % 10;

            temp.next = new ListNode(bits);
            temp = temp.next;
            l2 = l2.next;
        }

        return head;

    }



    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {





        Long res = listToint(l1)+ listToint(l2);

        System.out.println(listToint(l1)+"    "+listToint(l2));

        System.out.println(res);

        return intToList(res);

//        return new ListNode(1);

    }


    public long listToint(ListNode node){

        int weight =1;
        long sum =0;
        while(null != node){
            long value = node.val;
            sum += weight * value;
            weight = weight *10;
            node = node.next;
        }
        return sum;
    }

    public ListNode intToList(long num){

        Long value = num % 10;
        ListNode head = new ListNode(Integer.parseInt(value.toString()));

        ListNode  temp = head;

        while(0 != num /10 ){
            num = num /10;
            Long valueTemp = num % 10;
            temp.next = new ListNode(Integer.parseInt(valueTemp.toString()));
            temp = temp.next;

        }
        return head;
    }


    public static void main(String[] args) {

        ListNode a1 = new ListNode(1);
//        ListNode a2 = new ListNode(2);
//        ListNode a3 = new ListNode(5);
//        a1.next = a2;
//        a2.next =a3;


        ListNode b1 = new ListNode(9);
        ListNode b2 = new ListNode(9);
//        ListNode b3 = new ListNode(4);
        b1.next = b2;
//        b2.next =b3;


//        ListNode b1 = new ListNode(1);
//        ListNode b2 = new ListNode(9);
//        ListNode b3 = new ListNode(9);
//        ListNode b4 = new ListNode(9);
//        ListNode b5 = new ListNode(9);
//        ListNode b6 = new ListNode(9);
//        ListNode b7 = new ListNode(9);
//        ListNode b8 = new ListNode(9);
//        ListNode b9 = new ListNode(9);
//        ListNode b10 = new ListNode(9);
//
//
//        b1.next = b2;
//        b2.next =b3;
//        b3.next =b4;
//        b4.next =b5;
//        b5.next =b6;
//        b6.next =b7;
//        b7.next =b8;
//        b8.next =b9;
//        b9.next =b10;



        ListNode res = new ListNodeTest().addTwoNumbers2(a1, b1);

        while(null != res){

            System.out.print(res.val+"  ");
            res = res.next;
        }


    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}