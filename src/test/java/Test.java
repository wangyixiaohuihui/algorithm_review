
import org.apache.commons.lang3.StringUtils;

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


    public static  String getHint(String secret, String guess) {

        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i<secret.length(); i++) {
            int s = Character.getNumericValue(secret.charAt(i));
            int g = Character.getNumericValue(guess.charAt(i));
            if (s == g){
                bulls++;
            }else {
                if (numbers[s] < 0){
                    cows++;
                }
                if (numbers[g] > 0){
                    cows++;
                }
                numbers[s] ++;
                numbers[g] --;
            }
        }
        return bulls + "A" + cows + "B";
    }


    public static List<String> subdomainVisits(String[] cpdomains) {

        Map<String, Integer> countDomain = new HashMap<String, Integer>();


        List<String> countDomainList = new ArrayList<String>();


        for(String cpdomain: cpdomains){

            String[] countAndDomain = cpdomain.split(StringUtils.SPACE);
            int count = Integer.parseInt(countAndDomain[0]);

            String[] domains = countAndDomain[1].split("\\.");
            String tempDomain="";
            for(int i=domains.length-1; i>0; i--){

                tempDomain = tempDomain + domains[i];
                countDomain.put(tempDomain, countDomain.getOrDefault(tempDomain,0)+ count);
            }
        }

        for(Map.Entry<String, Integer> domianAndCount: countDomain.entrySet()){

            countDomainList.add(domianAndCount.getValue()+StringUtils.SPACE +domianAndCount.getKey());

        }

        return countDomainList;
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



        //subdomainVisits(new String[]{"9001 discuss.leetcode.com"});


        System.out.println(getHint("1807", "7810"));

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
