package com.my.leetcode.bytedance;

/**
 * @author: whgong
 * @description:
 * @create: 2020/6/30 20:08
 */

public class Lc896 {

    public boolean isMonotonic(int[] A) {

        int len = A.length;
        int s = 0;
        for (int i = 0; i < len-2; i++) {
            int c = Integer.compare(A[i],A[i+1]);
            if(c != 0){
                //
                if(s != c && s != 0){
                    return false;
                }
            }
            s = c;
        }
        return true;

    }

}
