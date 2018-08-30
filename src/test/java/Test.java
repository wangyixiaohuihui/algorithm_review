import java.util.HashMap;
import java.util.HashSet;

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


    public static void main(String[] args) {
        int res = Test.subArraySum(new int[]{1, 2, 3}, 3);

        HashSet<Integer> diffSet = new HashSet<Integer>();

        HashMap<Integer, Integer> sumMap = new HashMap<Integer, Integer>(16);



        System.out.println(res);
    }
}