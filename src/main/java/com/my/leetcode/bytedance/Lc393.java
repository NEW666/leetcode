package com.my.leetcode.bytedance;

/**
 * UTF-8 中的一个字符可能的长度为 1 到 4 字节，遵循以下的规则：
 *
 * 对于 1 字节的字符，字节的第一位设为0，后面7位为这个符号的unicode码。
 * 对于 n 字节的字符 (n > 1)，第一个字节的前 n 位都设为1，第 n+1 位设为0，后面字节的前两位一律设为10。剩下的没有提及的二进制位，全部为这个符号的unicode码。
 * 这是 UTF-8 编码的工作方式：
 *
 *    Char. number range  |        UTF-8 octet sequence
 *       (hexadecimal)    |              (binary)
 *    --------------------+---------------------------------------------
 *    0000 0000-0000 007F | 0xxxxxxx
 *    0000 0080-0000 07FF | 110xxxxx 10xxxxxx
 *    0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
 *    0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
 * 给定一个表示数据的整数数组，返回它是否为有效的 utf-8 编码。
 *
 * 注意:
 * 输入是整数数组。只有每个整数的最低 8 个有效位用来存储数据。这意味着每个整数只表示 1 字节的数据。
 *
 * 示例 1:
 *
 * data = [197, 130, 1], 表示 8 位的序列: 11000101 10000010 00000001.
 *
 * 返回 true 。
 * 这是有效的 utf-8 编码，为一个2字节字符，跟着一个1字节字符。
 * 示例 2:
 *
 * data = [235, 140, 4], 表示 8 位的序列: 11101011 10001100 00000100.
 *
 * 返回 false 。
 * 前 3 位都是 1 ，第 4 位为 0 表示它是一个3字节字符。
 * 下一个字节是开头为 10 的延续字节，这是正确的。
 * 但第二个延续字节不以 10 开头，所以是不符合规则的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/utf-8-validation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Lc393 {

    public boolean validUtf8(int[] data) {
        int utf8Bytes = 0;
        int dataLen = data.length;
        for (int i = 0; i < dataLen ; i++) {
            String binRep = Integer.toBinaryString(data[i]);
            binRep = binRep.length() >=8 ? binRep.substring(binRep.length()-8): "00000000".substring(binRep.length() % 8) + binRep;
            //处理一个全新的utf8
            if(utf8Bytes == 0){
                int binRepLen = binRep.length();
                for (int j = 0; j < binRepLen ; j++) {
                    //第一个为0,则是1字节,直接跳出
                    if (binRep.charAt(j) == '0') {
                        break;
                    }
                    utf8Bytes++;
                }

                //上是1字节，进入下一轮
                if(utf8Bytes == 0){
                    continue;
                }

                //如果一轮统计中字节数大于4则是违法字节
                if(utf8Bytes > 4 || utf8Bytes == 1 ){
                    return false;
                }

            }else if(binRep.charAt(0) != '1' && binRep.charAt(1) == '0'){
                return false;
            }

            utf8Bytes--;

        }

        return utf8Bytes == 0;


    }


    public static void main(String[] args) {
        int[] data = {235,140,4};
        Lc393 lc393 = new Lc393();
        lc393.validUtf8(data);
    }


}
