package com.my.leetcode.bytedance;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * @author: whgong
 * @description:
 * @create: 2020/7/7 19:48
 */

public class Lc815 {

    public int numBusesToDestination(int[][] routes, int S, int T) {
        if(S == T){
            return 0;
        }
        int N = routes.length;
        List<List<Integer>> gra = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            Arrays.sort(routes[i]);
            gra.add(new ArrayList<>());
        }

        Set<Integer> seen = new HashSet<>();
        Set<Integer> target = new HashSet<>();
        Queue<Point> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {

                if(ontract(routes[i],routes[j])){
                    gra.get(i).add(j);
                    gra.get(j).add(i);
                }

            }
            
        }

        for (int i = 0; i < N; i++) {

            if(Arrays.binarySearch(routes[i],S) >0){
                seen.add(i);
                queue.offer(new Point(i,0));
            }

            if(Arrays.binarySearch(routes[i],T)>0){
                target.add(i);
            }

        }

        while (!queue.isEmpty()){
            Point info = queue.poll();
            int node  = info.x,depth = info.y;
            if(target.contains(node)){
                return depth+1;
            }

            for (Integer nei : gra.get(node)){
                if(!seen.contains(nei)){
                    seen.add(nei);
                    queue.offer(new Point(nei,depth+1));
                }
            }

        }

        return -1;
    }

    public boolean ontract(int[] a,int[] b){
        int i = 0 ,j = 0;

        while (i < a.length && j < b.length){
            if(a[i] == b[j]){
                return true;
            }
            if (a[i] < b[j]) {
                i++;
            }else {
                j++;
            }
        }

        return false;


    }


}
