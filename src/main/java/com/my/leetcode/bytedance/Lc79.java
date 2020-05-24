package com.my.leetcode.bytedance;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Lc79 {

    private String word;
    private char[][] board;
    private int[][] direction;
    private boolean[][] marked;
    private int m;
    private  int n;

    public boolean exist(char[][] board, String word) {

        this.board = board;
        this.word = word;
        this.m = board.length;
        if(m == 0){
            return false;
        }
        this.n = board[0].length;
        this.direction = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        this.marked = new boolean[m][n];

        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                if(dfs(i,j,0)) {
                    return true;
                }
            }

        }

        return false;

    }

    public boolean dfs(int i, int j , int start){

        if(start == word.length()-1){
            return board[i][j] == word.charAt(start);
        }
        if(board[i][j] == word.charAt(start)){
            marked[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int newX = i + direction[k][0];
                int newY = j + direction[k][1];
                if(inArea(newX,newY) && !marked[newX][newY]){
                    if(dfs(newX,newY,start+1)){
                        return true;
                    }
                }

            }
            marked[i][j]  = false;
        }
        return false;
    }

    public boolean inArea(int x , int y){
        return x >= 0 && x < m && y >= 0 && y < n;
    }


    public static void main(String[] args) {

//        char[][] board =
//                {
//                        {'A', 'B', 'C', 'E'},
//                        {'S', 'F', 'C', 'S'},
//                        {'A', 'D', 'E', 'E'}
//                };
//
//        String word = "ABCCED";


        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word ="ABCCED";
        Lc79 solution = new Lc79();
        boolean exist = solution.exist(board, word);
        System.out.println(exist);
    }




}
