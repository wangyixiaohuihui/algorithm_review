package com.wy.algorithm.list;

import java.util.*;

/**
 * ClassName UnionFind
 * Date 2018/11/28
 *
 * @author wangyi
 **/
public class UnionFind {

    public List<List<String>> accountsMerge(List<List<String>> acts) {

        Map<String, String> parents = new HashMap<>();

        Map<String, String> emailToUser  = new HashMap<>();
        Map<String, TreeSet<String>> components = new HashMap<>();


        for (List<String> a : acts) {
            for (int i = 1; i < a.size(); i++) {
                parents.put(a.get(i), a.get(i));
                emailToUser.put(a.get(i), a.get(0));
            }
        }

        for (List<String> a : acts) {

            if(a.size() >1){
                String p = findParent(a.get(1), parents);
                for (int i = 2; i < a.size(); i++){
                    parents.put(findParent(a.get(i), parents), p);
                }
            }
        }

        for(List<String> a : acts) {

            if(a.size() >1){
                String p = findParent(a.get(1), parents);
                if (!components.containsKey(p)){
                    components.put(p, new TreeSet<>());
                }

                for (int i = 1; i < a.size(); i++){
                    components.get(p).add(a.get(i));
                }
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (String p : components.keySet()) {
            List<String> emails = new ArrayList<String>(components.get(p));
            emails.add(0, emailToUser.get(p));
            res.add(emails);
        }
        return res;
    }


    private String findParent(String s, Map<String, String> p) {
        return p.get(s).equals(s) ? s : findParent(p.get(s), p);
    }



    //v
    // [["John", "johnsmith@mail.com", "john00@mail.com"],
    // ["John", "johnnybravo@mail.com"],
    // ["John", "johnsmith@mail.com", "john_newyork@mail.com"],
    // ["Mary", "mary@mail.com"]]

    public static void main(String[] args) {

        List<List<String>>  a = new ArrayList<>();
        List<String> a1 = new ArrayList<>();
        a1.add("Alex");
        a1.add("Alex4@m.co");
        a1.add("Alex0@m.co");
        a.add(a1);

        List<String> a2 = new ArrayList<>();
        a2.add("Ethan");
        a2.add("Ethan3@m.co");
        a2.add("Ethan3@m.co");
        a2.add("Ethan0@m.co");
        a.add(a2);

        List<String> a3 = new ArrayList<>();
        a3.add("Kevin");
        a3.add("Kevin4@m.co");
        a3.add("Kevin2@m.co");
        a3.add("Kevin2@m.co");
        a.add(a3);

        List<String> a4 = new ArrayList<>();
        a4.add("Gabe");
        a4.add("Gabe0@m.co");
        a4.add("Gabe3@m.co");
        a4.add("Gabe2@m.co");
        a.add(a4);

        List<String> a5 = new ArrayList<>();
        a5.add("Gabe");
        a5.add("Gabe3@m.co");
        a5.add("Gabe4@m.co");
        a5.add("Gabe2@m.co");
        a.add(a5);


        System.out.println(new UnionFind().accountsMerge(a));
    }
}
