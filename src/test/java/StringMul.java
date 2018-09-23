/**
 * ClassName StringMul
 * Date 2018/8/31
 *
 * @author wangyi
 **/
public class StringMul {

    public static String multiply(String num1, String num2) {

        if(num1.equals("0") || num2.equals("0")) return "0";

        int len1 = num1.length();
        int len2 = num2.length();

        int[] num= new int[len1+len2];

        int decade =0;
        int bits =0;
        int i=0;
        int j=0;


        for(i= len1 -1 ; i>=0 ; i--){

            decade =0;
            for(j= len2 -1; j>=0 ; j--){

                int iInt = num1.charAt(i) -'0';
                int jInt = num2.charAt(j) -'0';

                int mulTemp = iInt * jInt + decade + num[i+j+1];
                decade =  mulTemp / 10;
                bits = mulTemp % 10;
                num[i+j+1] = bits;
            }
            // 一次遍历乘法完成， 最高位有进1时,情况
            num[i+j+1] = decade;
        }
        int flag =0;
        while(flag < len1 +len2 && num[flag] ==0){
            flag ++;
        }
        StringBuilder numBuffer = new StringBuilder();
        while(flag < len1 +len2){
            numBuffer.append(num[flag]);
            flag ++;
        }

        return  numBuffer.toString();

    }



    public String reverseStr(String s, int k) {

        for (int i = 0; i < s.length(); i += 2 * k) {

            s = reverse(s, i, Math.min(i+k, s.length()-1));
        }
        return s;
    }

    public String reverse(String s, int left, int right) {

        while (left < right) {
            char t = s.charAt(left);

        }
        return s;
    }


    public static void main(String[] args) {
        String res = StringMul.multiply("2","3");
        System.out.println(res);



    }
}
