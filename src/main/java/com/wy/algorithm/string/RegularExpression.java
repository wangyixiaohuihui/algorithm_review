package com.wy.algorithm.string;

/**
 * @author wangyi
 * @Classname RegularExpression
 * @Description TODO 正则匹配
 * @Date 2020/1/16 10:02
 */
public class RegularExpression {

    /**
     *
     * @param s 字符串
     * @param p 匹配串
     * @return 是否能够匹配
     */
    public boolean isMatch(String s, String p) {
        if (null == s || null == p) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }

        for (int i = 0; i < s.length(); i++) {

            for (int j = 0; j < p.length(); j++) {

                if (s.charAt(i) == p.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                }

                if (p.charAt(j) == '*') {

                    if (s.charAt(i) != p.charAt(j - 1) && p.charAt(j - 1) != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        // a* ||  aa*(???)  ||
                        dp[i + 1][j + 1] = dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1];
                    }
                }

            }
        }

        return dp[s.length()][p.length()];
    }
}
