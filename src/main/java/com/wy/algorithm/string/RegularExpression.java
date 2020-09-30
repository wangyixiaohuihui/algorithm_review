package com.wy.algorithm.string;

/**
 *
 * Mark
 * //s = "aab"
 * //p = "c*a*b"
 * //Output: true  c repeated 0 次
 *  . 任意字符
 *  * 前一个字符出现0 次或者多次
 * @author wangyi
 * @Classname RegularExpression
 * @Description TODO 正则匹配
 * @Date 2020/1/16 10:02
 */
public class RegularExpression {

    /**
     *   s 是否可以使用p 匹配上
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

        // 初始化s 和 p；
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
                // .匹配任意字符
                if (p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                // 匹配 0 或者 多个 前一个字符
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
