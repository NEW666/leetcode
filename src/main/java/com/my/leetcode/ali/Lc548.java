package com.my.leetcode.ali;


import java.util.HashSet;

/**
 * 给定一个有 n 个整数的数组，你需要找到满足以下条件的三元组 (i, j, k) ：
 *
 * 0 < i, i + 1 < j, j + 1 < k < n - 1
 * 子数组 (0, i - 1)，(i + 1, j - 1)，(j + 1, k - 1)，(k + 1, n - 1) 的和应该相等。
 * 这里我们定义子数组 (L, R) 表示原数组从索引为L的元素开始至索引为R的元素。
 *
 *  
 *
 * 示例:
 *
 * 输入: [1,2,1,2,1,2,1]
 * 输出: True
 * 解释:
 * i = 1, j = 3, k = 5.
 * sum(0, i - 1) = sum(0, 0) = 1
 * sum(i + 1, j - 1) = sum(2, 2) = 1
 * sum(j + 1, k - 1) = sum(4, 4) = 1
 * sum(k + 1, n - 1) = sum(6, 6) = 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-array-with-equal-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Lc548 {

    public boolean splitArray(int[] nums) {

        if(nums.length < 7){
            return false;
        }
        int numLen = nums.length;
        int[] sum = new int[numLen];
        sum[0] = nums[0];
        for (int i = 1; i < numLen; i++) {
            sum[i] = sum[i-1]+nums[i];
        }

        for (int j = 3; j < numLen -3; j++) {
            HashSet<Integer> set = new HashSet<Integer>();
            for (int i = 1; i < j-1; i++) {
                if(sum[i-1] == sum[j-1] - sum[i]){
                    set.add(sum[i-1]);
                }
            }

            for (int k = j+2; k < numLen-1; k++) {
                if(sum[numLen-1] - sum[k] == sum[k-1] - sum[j] && set.contains(sum[k-1] - sum[j]))
                    return true;

            }
        }
        return false;
    }
}
