
//设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的“对角线”指的是所有的对角线，不只是平分整
//个棋盘的那两条对角线。 
//
// 注意：本题相对原题做了扩展 
//
// 示例: 
//
//  输入：4
// 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
// 解释: 4 皇后问题存在如下两个不同的解法。
//[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
// 
// Related Topics 回溯算法 
// 👍 67 👎 0

package leetcode.editor.cn;

import java.util.*;

public class EightQueensLcci {
    public static void main(String[] args) {
        Solution solution = new EightQueensLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] queens = new int[n];
        Arrays.fill(queens,-1);
        Set<Integer> cols = new HashSet<>();
        Set<Integer> dg = new HashSet<>();
        Set<Integer> udg = new HashSet<>();
        backTrack(res,queens,0,cols,dg,udg,n);
        return res;
    }

    private void backTrack(List<List<String>> res,int[] queens,int row,Set<Integer> cols,Set<Integer> dg,Set<Integer> udg,int n) {
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            res.add(board);
        } else {
            for (int y = 0; y < n;y++) {
                if (!cols.contains(row) && !dg.contains(row - y) && !udg.contains(row + y)) {
                    queens[row] = y;
                    cols.add(y);
                    dg.add(row - y);
                    dg.add(row + y);
                    backTrack(res,queens,row+1,cols,dg,udg,n);
                    queens[row] = -1;
                    cols.remove(y);
                    dg.remove(row - y);
                    udg.remove(row + y);
                }
            }
        }
    }

    private List<String> generateBoard(int[] queens,int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] chars = new char[n];
            Arrays.fill(chars,'.');
            chars[queens[i]] = 'Q';
            board.add(new String(chars));
        }
        return  board;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}