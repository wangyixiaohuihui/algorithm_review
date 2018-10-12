import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * ClassName Test
 * Date 2018/8/29
 *
 * @author wangyi
 **/
public class Test {


    public static  int subArraySum(int[] nums, int k) {


        int ans =0;
        int sum =0;

        HashMap<Integer, Integer> sumMap = new HashMap<Integer, Integer>(16);
        sumMap.put(0, 1);

        for(int i=0; i<nums.length; i++){

            sum = sum + nums[i];
            int diffSum = sum -k;

            Integer count = sumMap.get(diffSum);
            if(null != count){
                ans += count;
            }
            Integer sumNum = sumMap.get(sum);
            if(null == sumNum){
                sumMap.put(sum, 1);
            }else {
                sumMap.put(sum, ++sumNum);
            }
        }
        return ans;
    }


    private static boolean isDividingNum(int num){

        int s = num;
        boolean isDividing =  true;
        while( 0 != num){

            int unit = num %10;
            if(s % unit !=0){
                isDividing = false;
                break;
            }
            num = num/10;
        }
        return isDividing;
    }




    public static void main(String[] args) {
//        int res = Test.subArraySum(new int[]{1, 2, 3}, 3);
//
//        HashSet<Integer> diffSet = new HashSet<Integer>();
//
//        HashMap<Integer, Integer> sumMap = new HashMap<Integer, Integer>(16);
//
//        HashSet<Integer> visitSet = new HashSet<Integer>();
//
//        visitSet.addAll(diffSet);
//
//        int count =3;
//        if(--count ==2){
//            System.out.println("hhhhhh");
//        }
//        System.out.println(res);



        System.out.println(isDividingNum(10));

        char[] s = new char[1];
        new String(s);

//
//        StringBuffer kBf = new StringBuffer();
//        for(int i=1; i<=4 ; i++){
//            kBf.append(i);
//        }
//
//        kBf.charAt(3);
//
//        kBf.deleteCharAt(3);
//
//        System.out.println(kBf.toString());

    }
}
