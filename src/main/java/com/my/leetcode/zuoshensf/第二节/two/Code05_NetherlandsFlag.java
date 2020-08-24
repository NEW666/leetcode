package com.my.leetcode.zuoshensf.第二节.two;

/**
 荷兰国旗问题
 问题一

 给定一个数组arr，和一个数num，请把小于等于num的数放在数 组的左边，大于num的
 数放在数组的右边。要求额外空间复杂度O(1)，时间复杂度O(N)

 问题二(荷兰国旗问题)

 给定一个数组arr，和一个数num，请把小于num的数放在数组的 左边，等于num的数放
 在数组的中间，大于num的数放在数组的 右边。要求额外空间复杂度O(1)，时间复杂度
 O(N)
 */

public class Code05_NetherlandsFlag {

    public static int[] netherlandsFlag(int[] arr,int l, int r ,int p){
        int less = l;
        int more = r;
        while (l<r){
            if(arr[l] > p){
                swap(arr,++less,l++);
            }else if(arr[r] < p){
                swap(arr,--more,r--);
            }else{
                l++;
            }
        }
        return arr;
    }
    // for test
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
