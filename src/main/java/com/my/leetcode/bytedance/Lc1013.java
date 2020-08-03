package com.my.leetcode.bytedance;

/**
 * @author: whgong
 * @description:
 * @create: 2020/6/23 18:52
 */

public class Lc1013 {

    public static boolean canThreePartsEqualSum(int[] A) {
        int len = A.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += A[i];
        }
        if(sum%3 != 0){
            return false;
        }
        int target = sum/3;
        int i = 0;
        int j = 0;
        int sumA = 0;
        for (int k = 0; k < len; k++) {
            sumA += A[k];
            if(sumA == target){
                break;
            }
            i++;
        }
        if(sumA != target){
            return false;
        }
        j = i+1;
        for (int k = j; k < len; k++) {
            sumA += A[k];
            if(sumA == target*2 && k != len-1){
                return true;
            }
            if(j == len-1){
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {1,-1,1,-1};
        canThreePartsEqualSum(a);
    }
}
