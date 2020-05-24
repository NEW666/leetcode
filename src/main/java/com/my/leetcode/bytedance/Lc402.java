package com.my.leetcode.bytedance;


import java.util.LinkedList;

/**
 * @author: whgong
 * @description:
 * @create: 2020/5/22 15:46
 */

public class Lc402 {

    public String removeKdigits(String num, int k) {
        LinkedList<Character> stack = new LinkedList<>();

        for (Character digist : num.toCharArray()){
            while (stack.size() > 0 && k > 0 && stack.peekLast() > digist){
                stack.removeLast();
                k--;
            }
            stack.addLast(digist);
        }
        
        for (int i = 0; i < k ; i++) {
            stack.removeLast();
        }

        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        for(char digit: stack) {
            if(leadingZero && digit == '0') continue;
            leadingZero = false;
            sb.append(digit);
        }

        if (sb.length() == 0) return "0";
        return sb.toString();

    }

    public static void main(String[] args) {
        Lc402 lc402 = new Lc402();
        lc402.removeKdigits("1432219",3);
    }
}
