import com.wy.algorithm.base.ListNode;

/**
 * ClassName SumTwo
 * Date 2018/8/31
 *
 * @author wangyi
 **/
public class SumTwo {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

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


        while (null != l1 ||  null != l2 || decade !=0){

            int keyTemp1 = 0;
            int keyTemp2 = 0;

            if(null != l1){
                keyTemp1 = l1.val;
            }

            if(null != l2){
                keyTemp2 = l2.val;
            }

            int res2 = keyTemp1 + keyTemp2 + decade;

            decade = res2 /10;
            bits = res2 % 10;

            temp.next = new ListNode(bits);
            temp = temp.next;

            if(null != l1){
                l1 = l1.next;
            }

            if(null != l2){
                l2 = l2.next;
            }
        }
        return head;


    }


}
