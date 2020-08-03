package com.my.leetcode.string;

import java.util.Stack;

/**
 * @author: whgong
 * @description:
 * @create: 2020/7/24 19:39
 */

public class Lc32 {
    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack();
        int count = 0;
        stack.push(-1);
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == '('){
                stack.push(i);
            }else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else {
                    count = Math.max(count,i-stack.peek());
                }
            }
        }
        return count;
    }

}
