package com.my.leetcode.tx;

/**
 归并排序的扩展
 小和问题和逆序对问题
 小和问题
 在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组
 的小和。求一个数组 的小和。
 例子:[1,3,4,2,5] 1左边比1小的数，没有; 3左边比3小的数，1; 4左
 边比4小的数，1、3; 2左边比2小的数，1; 5左边比5小的数，1、3、4、
 2; 所以小和为1+1+3+1+1+3+4+2=16
 逆序对问题 在一个数组中，左边的数如果比右边的数大，则折两个数
 构成一个逆序对，请打印所有逆序 对。
 */

public class Code02_SmallSum {

    public static void smqllSum(int[] arr){

    }

    public static int sort(int[] arr ,int l,int r){
        if(l == r){
            return 0;
        }
        int mid = l + (r-l) >> 1;
        return merge(arr,l,mid,r)+sort(arr,l,mid)+sort(arr,mid+1,r);

    }

    public static int merge(int[] arr,int l,int mid,int r){
        int[] tmp = new int[r-l+1];
        int index = 0;
        int p1=l;
        int p2 = mid+1;
        int res = 0;
        while (p1 <= l && p2 <= r){
            //右边大于左边的数有（r-p2+1）个
            res += arr[p1]<arr[p2]? (r-p2+1) * arr[p1]:0;
            tmp[index++] = arr[p1] < arr[p2]?arr[p1]:arr[p2];
        }
        while (p1<=l){
            tmp[index++] = arr[p1++];
        }
        while (p2<=r){
            tmp[index++] = arr[p2++];
        }
        for (int i = 0; i < tmp.length; i++) {
            arr[l+i] = tmp[i];
        }
        return res;
    }
}
