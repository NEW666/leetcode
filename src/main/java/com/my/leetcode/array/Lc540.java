package com.my.leetcode.array;

/**
 * @author ：wh.gong
 * @date ：Created in 2020/12/24 20:05
 * @description：
 */
public class Lc540 {

    public static int singleNonDuplicate(int[] nums) {
        int low = 0;
        int hight = nums.length-1;
        while (low < hight){
            int mid = low+(hight-low)/2;
            if(nums[mid-1] == nums[mid]){
                boolean even = (hight-mid)%2 == 0;
                if(even){
                    hight = mid-2;
                }else {
                    low = mid+1;
                }
            }else if(nums[mid+1] == nums[mid]){
                boolean even = (hight-mid+1)%2 == 0;
                if(even){
                    hight = mid-1;
                }else {
                    low = mid+2;
                }
            }else {
                return nums[mid];
            }

        }
        return nums[low];
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,3,3,4,4,8,8};
        singleNonDuplicate(arr);
    }
}
