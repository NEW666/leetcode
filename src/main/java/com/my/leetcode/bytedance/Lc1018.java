package com.my.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: whgong
 * @description:
 * @create: 2020/6/28 19:45
 */

public class Lc1018 {

    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();
        int len = A.length;
        int num  = 0;
        for (int i = 0; i < len; i++) {
            num = (num*2 +A[i])%5;
            if(num == 0){
                res.add(true);
            }else {
                res.add(false);
            }

        }

        return res;

    }
}
