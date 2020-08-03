package com.my.leetcode.bytedance;

/**
 * @author: whgong
 * @description:
 * @create: 2020/6/28 20:24
 */

public class Lc1180 {

    public int countLetters(String S) {
        int count = 1;
        int res = 0;
        int len = S.length();
        for (int i = 0; i <= len-1; i++) {
            if(S.charAt(i) == S.charAt(i+1)){
                count++;
            }else {
                res += count*(count+1)/2;
                count = 1;
            }
        }
        return res;

    }
}
