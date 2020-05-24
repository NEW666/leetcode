package com.my.leetcode.bytedance;

public class Lc33 {

    private int[] nums;
    private  int target;

    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        int numsLen = nums.length;
        if(numsLen == 0){
            return -1;
        }
        if (numsLen == 1){
            return target == nums[0] ? 0:-1;
        }

        int pivot = findPivotIndex(0,numsLen-1);

        if(nums[pivot] == target){
            return pivot;
        }
        if (pivot == 0){
            return binarySearch(0,numsLen-1);
        }
        if(nums[0] > target){
            return binarySearch(pivot,numsLen-1);
        }
        return binarySearch(0,pivot);
    }

    public int binarySearch(int left,int right){
        while (left <= right){

            int pivot = (left + right)/2;
            if (nums[pivot] == target){
                return pivot;
            }else {
                if(nums[pivot] > target){
                    right = pivot-1;
                }else {
                    left = pivot+1;
                }
            }

        }
        return -1;
    }

    public int findPivotIndex(int left,int right){

        if(nums[left] < nums[right]){
            return 0;
        }

        while (left <= right){
            int pivot = (left+right)/2;
            if(nums[pivot] > nums[pivot+1]){
                return pivot + 1 ;
            }else {
                if (nums[pivot] < nums[left])
                    right = pivot - 1;
                else
                    left = pivot + 1;
            }
        }

        return 0;
    }
}
