package com.my.leetcode.bytedance;

/**
 * @author: whgong
 * @description:
 * @create: 2020/6/30 19:36
 */

public class Lc1419 {

    public int minNumberOfFrogs(String croakOfFrogs) {

        int c = 0;
        int r = 0;
        int o = 0;
        int a = 0;
        int k = 0;
        char[] strArray = croakOfFrogs.toCharArray();

        int res = 0;
        boolean flag = false;
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            if(strArray[i] == 'c'){
                c++;
            }
            if(strArray[i] == 'r'){
                r++;
            }
            if(strArray[i] == 'o'){
                o++;
            }
            if(strArray[i] == 'a'){
                a++;
            }
            res = Math.max(res,c);

            if(strArray[i] == 'k'){
                k++;
                if(c>=r && r>=o && o>=a && a>=k){
                    c--;
                    r--;
                    o--;
                    a--;
                    k--;
                }
            }


            if(!(c>=r && r>=o && o>=a && a>=k)){
                flag = true;
                break;
            }


        }

        if(c>0 || r>0 || o>0 || a>0 || k>0 ){
            flag = true;
        }

        if(!flag){
            return res;
        }
        return -1;

    }

    public static void main(String[] args) {
        Lc1419 lc1914 = new Lc1419();
        lc1914.minNumberOfFrogs("croakcroak");
    }
}
