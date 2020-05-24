package com.my.leetcode.bytedance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static javax.swing.UIManager.put;

public class Lc17 {

    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> output = new ArrayList<>();

    public void backtrack(String cb , String nextDigist){

        if(nextDigist.length() == 0){
            output.add(cb);
        }else {
            String digist = nextDigist.substring(0, 1);
            String letters = phone.get(digist);
            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i + 1);
                backtrack(cb + letter, nextDigist.substring(1));
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if(digits.length() != 0){
            backtrack("",digits);
        }
        return output;
    }
}
