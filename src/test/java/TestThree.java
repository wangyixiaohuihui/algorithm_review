import java.util.*;

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


//        System.out.println(10 / 3 *3 ==10);
//
//        List<List<Integer>> s = new TestThree().threeSum(new int[]{-1,0,1,2,-1,-4});
//
//        for(List<Integer> s1: s){
//
//            System.out.println(s1.toString());
//        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a,b)->a.getValue() == b.getValue()? b.getKey().compareTo(a.getKey()): a.getValue() - b.getValue());
        Map<String, Integer> map = new HashMap<String, Integer>();



        map.put("a",4);
        map.put("b",5);
        map.put("c",6);
        map.put("e",7);
        map.put("f",8);
        map.put("g",9);

        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            pq.offer(entry);
        }

        System.out.println("b".compareTo("a"));

        while(!pq.isEmpty()){
            System.out.println(pq.poll().toString());
        }



    }

}
