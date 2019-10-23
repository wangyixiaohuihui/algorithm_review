package com.wy.algorithm.string;

import javafx.util.Pair;

import java.util.*;

/**
 * ClassName WordLaddeSuit
 * Date 2019/9/10
 *
 * @author wangyi
 **/
public class WordLaddeSuit {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // Since all words are of same length.
        int L = beginWord.length();

        // Dictionary to hold combination of words that can be formed,
        // from any given word. By changing one letter at a time.
        HashMap<String, ArrayList<String>> allComboDict = new HashMap<String, ArrayList<String>>();

        wordList.forEach(
                word -> {
                    for (int i = 0; i < L; i++) {
                        // Key is the generic word
                        // Value is a list of words which have the same intermediate generic word.
                        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                        ArrayList<String> transformations =
                                allComboDict.getOrDefault(newWord, new ArrayList<String>());
                        transformations.add(word);
                        allComboDict.put(newWord, transformations);
                    }
                });

        System.out.println(allComboDict.toString());


        // Queue for BFS
        Queue<Pair<String, Integer>> Q = new LinkedList<Pair<String, Integer>>();
        Q.add(new Pair(beginWord, 1));

        // Visited to make sure we don't repeat processing same word.
        HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
        visited.put(beginWord, true);

        while (!Q.isEmpty()) {
            Pair<String, Integer> node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < L; i++) {

                // Intermediate words for current word
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

                // Next states are all the words which share the same intermediate state.
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<String>())) {
                    // If at any point if we find what we are looking for
                    // i.e. the end word - we can return with the answer.
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
                    // Otherwise, add it to the BFS Queue. Also mark it visited
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        Q.add(new Pair(adjacentWord, level + 1));
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        /**
         * beginWord = "hit",
         * endWord = "cog",
         * wordList = ["hot","dot","dog","lot","log","cog"]
         */
        List<String>  wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        new WordLaddeSuit().ladderLength("hit","cog",wordList);
    }

    private void merger(Pair<Integer, Integer>[] numIndexPair, int lo, int hi, int[] count) {

        if(lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        merger(numIndexPair, lo, mid, count);
        merger(numIndexPair, mid+1, hi, count);
    }


    public int wiggleMaxLength(int[] nums) {

        if (nums.length < 2) {
            return nums.length;
        }
        int maxLen = 1;
        int state =0;


        for (int i = 1; i < nums.length; i++) {

            switch (state) {
                case 0:
                    if (nums[i] > nums[i - 1]) {
                        state = 1;
                        maxLen++;
                    } else if (nums[i] < nums[i - 1]) {
                        state = 2;
                        maxLen++;
                    }
                    break;
                case 1:
                    if (nums[i] < nums[i - 1]) {
                        state = 2;
                        maxLen++;
                    }
                    break;
                case 2:
                    if (nums[i] > nums[i - 1]) {
                        state = 1;
                        maxLen++;
                    }
                    break;
                    default:
                        break;
            }
        }
        return maxLen;
    }




}
