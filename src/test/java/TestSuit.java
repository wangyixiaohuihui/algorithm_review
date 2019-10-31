import java.util.Stack;

/**
 * @author wangyi
 * date: {DATE}
 **/


public class TestSuit {

    static final int begin =0;
    static final int up =1;
    static final int down =2;
    static  int state = begin;

    public int wiggleMaxLength(int[] nums) {



        if (nums.length < 2) {
            return nums.length;
        }


        int maxLen = 1;

        for (int i = 1; i < nums.length; i++) {

            switch (state) {
                case begin:
                    if (nums[i] > nums[i - 1]) {
                        state = up;
                        maxLen++;
                    } else if (nums[i] < nums[i - 1]) {
                        state = down;
                        maxLen++;
                    }
                    break;
                case up:
                    if (nums[i] < nums[i - 1]) {
                        state = down;
                        maxLen++;
                    }
                    break;
                case down:
                    if (nums[i] > nums[i - 1]) {
                        state = up;
                        maxLen++;
                    }
                    break;
            }
        }
        return maxLen;
    }
    public String removeKdigits(String num, int k) {

        String result ="";
        Stack<Integer> tmpStack = new Stack<Integer>();
        for(int i=0; i<num.length(); i++) {

            int number = num.charAt(i) -'0';
            if (tmpStack.size() !=0) {
                int t = tmpStack.peek();
                while ( t > number &&  k>0) {
                    tmpStack.pop();
                    k --;
                }
            }
            if(number !=0 || tmpStack.size() !=0) {
                tmpStack.push(number);
            }

        }
        while(tmpStack.size() !=0 && k>0) {
            tmpStack.pop();
            k--;
        }
        for(int i=0; i<tmpStack.size(); i++){
            result = tmpStack.pop() + result;
        }
        if(result ==""){
            result ="0";
        }
        return result;
    }
    public static void main(String[] args) {
//        System.out.println(
//                new TestSuit().wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8}));
//


        System.out.println(new TestSuit().removeKdigits("1432219",3));
    }

}
