import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * ClassName TestThree
 * Date 2018/8/29
 *
 * @author wangyi
 **/
public class TestThree {


    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> threeList = new ArrayList<List<Integer>>();

        for(int i=0; i<nums.length; i++){

            int target = -nums[i];

            System.out.println("target:"+target);
            HashSet<Integer> sumMap = new HashSet<Integer>(16);

            for(int j=i+1; j< nums.length; j++){

                int key = target - nums[j];

                System.out.println("key:"+key);

                if(sumMap.contains(key)){
                    List<Integer> sumList = new ArrayList<Integer>();
                    sumList.add(key);
                    sumList.add(nums[j]);
                    sumList.add(nums[i]);
                    threeList.add(sumList);
                }
                sumMap.add(nums[j]);
            }
        }
        return  threeList;
    }


    public static void main(String[] args) {
        List<List<Integer>> s = new TestThree().threeSum(new int[]{-1,0,1,2,-1,-4});

        for(List<Integer> s1: s){

            System.out.println(s1.toString());
        }
    }

}
