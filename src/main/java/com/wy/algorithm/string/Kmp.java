package com.wy.algorithm.string;

/**
 * ClassName Kmp
 * Date 2018/8/24
 *
 * @author wangyi
 **/
public class Kmp {


    /**
     * 计算next 数组
     *
     * @param patternString 模式串
     */
    private static int[] calcNext(String patternString) {

        int len = patternString.length();
        int[] next = new int[patternString.length()];
        next[0] = -1;
        int k = -1;
        int j = 0; // 用于记录当前计算的next的数组的下标，同事也作为模式串本身被匹配到的位置的下标
        while (j < len - 1) {
            // k 标识前缀，  j表示后缀
            // k>0 时，表示目前已经有k-1个成功匹配，子串的前后缀最长公共匹配字符数有k-1个
            if (k == -1 || patternString.charAt(j) == patternString.charAt(k)) {
                ++k;
                ++j;
                if (patternString.charAt(j) != patternString.charAt(k)) {
                    next[j] = k;
                } else {
                    // 因不能出现p[j] = p[next[j]]，
                    // 当出现时需要继续递归，k=next[k] = next[next[k]]
                    //
                    next[j] = next[k];
                }
                System.out.println("next[j]:" + j + " =" + k);
            } else {
                System.out.println("p(j)=" + patternString.charAt(j)
                        + "   p(k)=" + patternString.charAt(k) + "  k=next[k]  " + k + "==" + next[k]);
                k = next[k];
            }

        }
        return next;
    }

    /**
     * 匹配字符串
     *
     * @param gSearch 字符串
     * @param pattern 匹配串
     */
    private static void kmpSearch(String gSearch, String pattern) {

        int ans = -1;
        int i = 0;
        int j = 0;

        int[] next = calcNext(pattern);

        while (i < gSearch.length()) {

            if (j == -1 || gSearch.charAt(i) == pattern.charAt(j)) {

                ++i;
                ++j;
            } else {
                //  如果 i，j 匹配失败时；或者 j=-1，
                // 则令i不变，j=next[j]，j为所对应的next的值。
                j = next[j];
            }
            if (j == pattern.length()) {
                ans = i - pattern.length();
                break;
            }

        }
        System.out.println("find:" + ans);

    }


    public static void main(String[] args) {
        //计算模式串

        int[] next = Kmp.calcNext("ababcabaa");

        System.out.println("ababcabaa");
        for (int r : next) {
            System.out.print(r + "  ");
        }

        //kmpSearch("hgdsahsahdjksa", "sahsa");

    }


}
