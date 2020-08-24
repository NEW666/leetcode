package com.my.leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: whgong
 * @description:
 * @create: 2020/8/6 20:14
 */

public class Lc3 {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> occ = new HashSet<>();
        int rk = -1;
        int len = s.length();
        int ans = 0;
        for (int i = 0; i < len ; i++) {

            if(i != 0){
                occ.remove(s.charAt(i-1));
            }

            while (rk+1 < len && !occ.contains(s.charAt(rk+1))){
                occ.add(s.charAt(rk+1));
                ++rk;
            }
            ans = Math.max(ans,rk - i + 1);
        }
        return ans;
    }


    public static void main(String[] args) {

        Lc3 lc3 = new Lc3();
        int a = lc3.lengthOfLongestSubstring("abcaabc");
        System.out.println(a);

    }


}
