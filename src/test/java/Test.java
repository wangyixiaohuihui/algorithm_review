import java.text.SimpleDateFormat;
import java.util.*;

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


    public static boolean isPerfectSquare(int num) {
        int start =0;
        int end = num;

        while(start <= end){

            int mid = start +(end -start)/2;
            if(mid * mid == num){
                return true;
            }else if(mid *mid < num){
                start = mid + 1;
            }else{
                end = mid -1;
            }

        }


        return false;
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


        // 无符号右移 /2

//         for(char a='a'; a<='z'; a++){
//             System.out.println((int)a);
//         }
//
//         String a ="-27897i";
//        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
//
//        Map<Integer, Integer> graph2 = new HashMap<Integer, Integer>();
//
//        System.out.println(a.substring(0, a.length()-1));
//        Map<Character,Integer> dicMap = new HashMap<Character, Integer>();

//        System.out.println(isDividingNum(10));
//
//        char[] s = new char[1];
//        new String(s);

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


//        isPerfectSquare(2147483647);

//        Calendar rightNow = Calendar.getInstance();
//        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");// 设置你想要的格式
//        String dateStr = df.format(rightNow.getTime());
//        String res = String.format("current '%s'", dateStr);
//
//        System.out.println(res);


//        List<Integer> idx = new ArrayList<>();
//        idx.add(1);
//        idx.add(3);
//        idx.add(5);
//
//        int j = Collections.binarySearch(idx, 0);
//
//        System.out.println(j);

        System.out.println(0 ^ 100);
    }


}
