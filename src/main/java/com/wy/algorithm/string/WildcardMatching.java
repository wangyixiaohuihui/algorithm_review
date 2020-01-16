package com.wy.algorithm.string;

/**
 * @author wangyi
 * @Classname WildcardMatching
 * @Description TODO
 * @Date 2020/1/16 10:15
 */
public class WildcardMatching {

    /**
     * * 匹配任意长度字符，?匹配1个字符
     *
     * @param str
     * @param pattern
     * @return
     */
    public boolean isMatch(String str, String pattern) {
        int s = 0, p = 0, match = 0, starIdx = -1;

        while (s < str.length()) {
            // advancing both pointers
            if (p < pattern.length() && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))) {
                s++;
                p++;
            }
            // * found, only advancing pattern pointer
            else if (p < pattern.length() && pattern.charAt(p) == '*') {
                starIdx = p;
                match = s;
                p++;
            }
            // last pattern pointer was *, advancing string pointer
            else if (starIdx != -1) {
                p = starIdx + 1;
                match++;
                s = match;
            }
            //current pattern pointer is not star, last patter pointer was not *
            //characters do not match
            else return false;
        }

        //check for remaining characters in pattern
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;

        return p == pattern.length();
    }

    private boolean isMatchDp(String str, String pattern) {
        int sLen = str.length();
        int pLen = pattern.length();
        // dp[i][j] 表示 字符串是s[i] 到 字符串 p[j]是否匹配
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;

        // 初始化字符str为空的情况，
        for (int i = 1; i <= pLen; i++) {
            if (pattern.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 1];
            }
        }

        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (pattern.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = str.charAt(i - 1) == pattern.charAt(j - 1)
                                    || (pattern.charAt(j - 1) == '?' && dp[i - 1][j - 1]);
                }
            }
        }
        return dp[sLen][pLen];
    }


    public static void main(String[] args) {
        System.out.println(new WildcardMatching().isMatch("abcdef", "ab*f"));
        System.out.println(new WildcardMatching().isMatchDp("abcdef", "ab*f"));
    }
}
