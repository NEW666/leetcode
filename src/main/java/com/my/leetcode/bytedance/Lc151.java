package com.my.leetcode.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: whgong
 * @description:
 * @create: 2020/5/22 17:11
 */

public class Lc151 {
    public String reverseWords(String s) {
        s = s.trim();
        String[] wordsArr = s.split("\\s+");
        List<String> words = Arrays.asList(wordsArr);
        Collections.reverse(words);
        return String.join(" ",words);
    }
}
