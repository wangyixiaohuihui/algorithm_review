import javafx.util.Pair;

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


    public int firstMissingPositive(int[] nums) {

        int n = nums.length;
        for(int i = 0; i < n; ++ i)
            while(nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]){
                swap(nums, i, nums[i] - 1);
                System.out.println("i:"+i+"  "+Arrays.toString(nums));
            }

        for(int i = 0; i < n; ++ i)
            if(nums[i] != i + 1)
                return i + 1;

        return n + 1;
    }

    public void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }


    public int largestRectangleArea(int[] height) {

        if (height == null || height.length == 0) {
            return 0;
        }
        // idx of the first bar the left that is lower than current
        int[] lessFromLeft = new int[height.length];
        // idx of the first bar the right that is lower than current
        int[] lessFromRight = new int[height.length];

        lessFromRight[height.length - 1] = height.length;
        lessFromLeft[0] = -1;

        for (int i = 1; i < height.length; i++) {
            int p = i - 1;

            while (p >= 0 && height[p] >= height[i]) {
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }

        System.out.println(Arrays.toString(lessFromLeft));

        for (int i = height.length - 2; i >= 0; i--) {
            int p = i + 1;

            while (p < height.length && height[p] >= height[i]) {
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }

        System.out.println(Arrays.toString(lessFromRight));


        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            maxArea = Math.max(maxArea, height[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }

        return maxArea;
    }



    private class Point implements Comparable<Point>{
        // x 坐标轴
        private int x;
        // 高度信息 y值
        private int height;
        // 是否是左边的值
        private boolean isStart;

        public Point(int x, int height, boolean isStart) {
            this.x = x;
            this.height = height;
            this.isStart = isStart;
        }

        // 比较规则复杂，主要是考虑到了三种边界情况
        public int compareTo(Point p) {
            // 横坐标不相等，按照横坐标升序排列
            if (this.x != p.x) {
                return this.x - p.x;
            } else {
                // if (p.isStart){
                //     return p.height - this.height;
                // }else {
                //     return this.height - p.height;
                // }
//
                // 横坐标相等的情况下，若是矩形左边值， 降序排列
                if (this.isStart && p.isStart) {
                    return p.height - this.height;
                }
                // 横坐标相等的情况下，若是矩形右边值，升序排列
                if (!this.isStart && !p.isStart) {
                    return this.height - p.height;
                }
                return this.isStart?-1:1;
            }
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", height=" + height +
                    ", isStart=" + isStart +
                    '}';
        }
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {

        int len = buildings.length;
        if (len == 0 || buildings[0].length == 0) {
            return new ArrayList<List<Integer>>();
        }
        // 每栋建筑有两个关键点
        Point[] points = new Point[len * 2];
        int index = 0;

        // 初始化所有关键点的数组
        for (int[] building : buildings) {
            int start = building[0];
            int end = building[1];
            int h = building[2];
            points[index++] = new Point(start,h,true);
            points[index++] = new Point(end,h,false);
        }
        // 将这些点按照我们希望的顺序排序
        Arrays.sort(points);

        // 用Collections.reverseOrder()来建立大根堆，这样就可以找到当前最高的高度
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        //queue.offer(0);
        List<List<Integer>> res = new ArrayList<>();

        int prevMaxVal = 0;
        for (Point point : points) {
            if (point.isStart) {
                queue.offer(point.height);
                Integer curMaxVal = queue.peek();
                if(null == curMaxVal){
                    curMaxVal =0;
                }
                // 如果最大值变化了（只能变大），就说明这个点应该被记录
                if (curMaxVal > prevMaxVal) {
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(point.x);
                    tmp.add(point.height);
                    res.add(tmp);
                    prevMaxVal = curMaxVal;
                }

            } else {
                // 移除指定的值
                queue.remove(point.height);
                Integer curMaxVal = queue.peek();
                if(null == curMaxVal){
                    curMaxVal =0;
                }
                // 最大值变化了（只能变小），记录当前点  降序
                if (curMaxVal < prevMaxVal) {
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(point.x);
                    tmp.add(curMaxVal);
                    res.add(tmp);
                    prevMaxVal = curMaxVal;
                }
            }
        }
        return res;
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

//        System.out.println(0 ^ 100);

//        Pair<Integer,Integer>[]  numIndexPair = new Pair[6];
//        numIndexPair[0].getKey();


//        new Test().firstMissingPositive(new int[]{3,4,-1,1});

//        List<Integer> list = new ArrayList<Integer>();
//
//        list.add(1);
//        list.add(2);
//        list.add(3);
//
//        list.remove(2);
//        System.out.println(list.toString());




        // [[0,3],[2,0],[2,3],[5,0]]
//        new Test().getSkyline(new int[][]{{0,2,3},{2,5,3}});

        List<List<Integer>> res = new ArrayList<List<Integer>>();

    }


}
