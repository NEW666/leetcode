package com.my.leetcode.zuoshensf.第二节.two;

/**
 * @author: whgong
 * @description:
 * @create: 2020/8/24 19:52
 */

public class Code06_QuickSort {

    public static void quickSort(int[] arr,int l,int r){
        int left = l;
        int right = r;
        int key = arr[(int) Math.random()*(right-left+1)];
        while (left < right){
            while (right > left && arr[right] >= key){
                //从右往左扫描，找到第一个比基准值小的元素
                right--;
            }

            //找到这种元素将arr[right]放入arr[left]中
            arr[left] = arr[right];

            while (left < right && arr[left] <= key){
                //从左往右扫描，找到第一个比基准值大的元素
                left++;
            }
            //找到这种元素将arr[left]放入arr[right]中
            arr[right] = arr[left];

        }
        //基准值归位
        arr[left] = key;
        //对基准值左边的元素进行递归排序
        quickSort(arr,l,left-1);
        //对基准值左边的元素进行递归排序
        quickSort(arr,right+1,r);

    }
}
