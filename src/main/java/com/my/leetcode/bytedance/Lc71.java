package com.my.leetcode.bytedance;

import java.util.Stack;

public class Lc71 {

    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();

        String[] strs = path.split("/");

        for (String str : strs){

            if("..".equals(str)){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else if(!"".equals(str) && !".".equals(str)){
                stack.push(str);
            }

        }

        if(stack.isEmpty()){
            return "/";
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            sb.append("/"+stack.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Lc71 lc71 = new Lc71();
        lc71.simplifyPath("/home//a");
    }
}
