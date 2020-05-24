package com.my.leetcode.bytedance;

import java.util.PriorityQueue;
import java.util.Random;


/**
 * 215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 */
public class Lc251 {

    int[] nums;

    public void swap(int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public int partition(int left , int right , int pivot_index){
        int pivot = nums[pivot_index];
        swap(pivot_index,right);
        int swap_index = left;

        for (int i = left; i < right ; i++) {

            if(nums[i] < pivot){
                swap(swap_index,i);
                swap_index++;
            }

        }
        swap(swap_index,right);
        return swap_index;
    }

    public int quickSelect(int left,int right,int k_smallest){

        if(left == right){
            return nums[left];
        }

        Random random = new Random();
        int pivot_index = left + random.nextInt(right-left);
        pivot_index = partition(left,right,k_smallest);

        if(k_smallest == pivot_index){
            return nums[pivot_index];
        }else if(k_smallest < pivot_index){
            return quickSelect(left,pivot_index-1,k_smallest);
        }
        return quickSelect(pivot_index+1,right,k_smallest);
    }

    public int findKthLargest(int[] nums, int k) {

        this.nums = nums;
        int size = nums.length;
        return quickSelect(0,size-1,size-k);
    }








    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        Lc251 lc251 = new Lc251();
        lc251.findKthLargest(nums, k);
    }
}
