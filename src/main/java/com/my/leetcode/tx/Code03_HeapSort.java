package com.my.leetcode.tx;

/**
 * @author: whgong
 * @description:
 * @create: 2020/8/24 21:30
 */

public class Code03_HeapSort {


    public static void heapSort1(int[] arr){

        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr,i);
        }
        int heapSize = arr.length;
        swap(arr,0,--heapSize);
        while (heapSize>0){
            heapify(arr,0,heapSize);
            swap(arr,0,--heapSize);
        }

    }


    public static void heapify(int[] arr, int index, int heapSize){

        int left = 2*index+1;
        while (left<heapSize){
            int max = arr[left] < arr[left+1]?left:left+1;
            max = arr[index] < arr[max] ? max:left;
            if(max == index){
                break;
            }
            swap(arr,index,max);
            index = max;
            left = index*2+1;
        }
    }


    public static void heapInsert(int[] arr, int index){
        while (arr[index] > arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);
            index = (index-1)/2;
        }
    }

    // for test
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
