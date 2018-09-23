import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ClassName CodeTest
 * Date 2018/9/19
 *
 * @author wangyi
 **/
public class CodeTest {

    public static void main(String[] args) {


//        System.out.println(longestHuiWen("11211123"));

        // System.out.println(find(8));

        Node  a = new Node(1);
        Node  b = new Node(2);
        Node  c = new Node(3);
        Node  d = new Node(4);
        Node  e = new Node(5);
        Node  f = new Node(6);

        List<Node> b1= new ArrayList<Node>();
        b1.add(b);
        b1.add(c);
        b1.add(d);

        a.children = b1;


        List<Node> c1= new ArrayList<Node>();
        c1.add(e);
        b.children= c1;

        List<Node> d1= new ArrayList<Node>();
        d1.add(f);
        c.children= d1;


        List s = new CodeTest().listNodeId3(a);

        System.out.println(s.toString());
    }

    public static int getMaxLength(String str){
        if(str==null||str.length()==0)
            return 0;
        for(int i=str.length();i>=0;i--){
            for(int j=0;j+i<=str.length();j++){
                if(str.substring(j,j+i).equals(new StringBuffer(str.substring(j,j+i)).reverse().toString()))
                    return i;
            }
        }
        return 0;
    }


    public static int find(int n){
        if(n <=0){
            return 1;
        }else if(n>0 && n<=3){
            return 2;
        }
        return find(n-1) + find(n-2);
    }


    public static  List<Integer> listNodeId(Node node) {
        List<Integer> list = new ArrayList<Integer>();
        if(node == null)
            return list;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
        while(!queue.isEmpty()) {
            node = queue.remove();
            System.out.println(node.id);
            list.add(node.id);
            if(null != node.children){
                for(Node child : node.children) {
                    queue.add(child);
                }
            }

        }
        return list;
    }



    public static String huiwen(String input) {

        char[] s = input.toCharArray();
        char[] ns = new char[2*s.length+1];
        for(int i = 0; i<s.length; i++) {
            ns[i] = '#';
            ns[i+1] = s[i];
        }
        ns[2*s.length] = '#';
        int max = 3;
        int begin = 0;
        int end = 2;
        for(int i = 1; i<ns.length-2; i++) {
            int l = i-1;
            int r = i+1;
            while(l>=0 && r<=ns.length-1 && ns[l] == ns[r]) {
                l --;
                r++;
            }
            r--;
            l++;
            if(r-l+1>max) {
                max = r-l+1;
                begin = l;
                end = r;
            }
        }
        String rets = "";
        for(int i = begin; i<=end; i++) {
            if(ns[i] != '#')
                rets+=(ns[i]);
        }
        return rets;
    }

    public static Queue<Node> queue = new LinkedList<Node>();
    public static List<Integer> list = new ArrayList<Integer>();
    public static  List<Integer>  listNodeId2(Node node) {
        if(node == null)
            return list;
        queue.offer(node);
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            list.add(cur.id);
            if(null != cur.children){
                for(int i = 0; i<cur.children.size(); i++ ) {
                    queue.offer(cur.children.get(i));
                }
            }

        }
        return list;
    }


    public List<Integer> listNodeId3(Node node){
        List<Integer> list = new ArrayList<Integer>();
        if(!node.equals(null)){
            System.out.println(node.id);
            list.add(node.id);
            if(node.children.size()>0){
                for(Node n:node.children){
                    List<Integer> list2 = new ArrayList<Integer>();
                    list2 = listNodeId(n);
                    for(Integer id: list2){
                        list.add(id);
                    }
                }
            }
        }
        return list;
    }


    public static String longestHuiWen(String str){
        int max = 0;
        String result=null;
        for(int i=0;i<str.length();i++){
            for(int j=i+1;j<str.length();j++){
                String temp = str.substring(i,j+1);
                int tempLen = j-1;
                if(isHuiWen(temp)){
                    if(tempLen>max){
                        result = temp;
                        max = tempLen;
                    }
                }
            }
        }
        return result;
    }

    public static boolean isHuiWen(String temp){
        for(int i = 0; i<temp.length()-1;i++){
            if(temp.charAt(i)==temp.charAt(temp.length()-1-i)){
                return true;
            }

        }
        return false;
    }


}
class Node {
    public Integer id;
    public List<Node> children;

    public Node(Integer id) {
        this.id = id;
    }
}