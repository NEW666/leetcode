package com.my.leetcode.bytedance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: whgong
 * @description:
 * @create: 2020/6/30 20:40
 */

public class Lc1213 {

    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int len1 = arr1.length;
        for (int i = 0; i < len1 ; i++) {
            map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
        }
        int len2 = arr2.length;
        for (int i = 0; i < len2 ; i++) {
            map.put(arr2[i], map.getOrDefault(arr2[i], 0) + 1);
        }

        int len3 = arr3.length;
        for (int i = 0; i < len3 ; i++) {
            map.put(arr3[i], map.getOrDefault(arr3[i], 0) + 1);
        }


        for (Map.Entry<Integer,Integer> e: map.entrySet()){
            if(e.getValue() == 3){
                res.add(e.getKey());
            }
        }
        return res;
    }
}
