//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// 
// 
// Related Topics 回溯算法 
// 👍 727 👎 0

package leetcode.editor.cn;

import java.util.*;

public class NQueens {
    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         * 回溯的具体做法是：使用一个数组记录每行放置的皇后的列下标，依次在每一行放置一个皇后。
         * 每次新放置的皇后都不能和已经放置的皇后之间有攻击：即新放置的皇后不能和任何一个已经放
         * 置的皇后在同一列以及同一条斜线上，并更新数组中的当前行的皇后列下标。当 NN 个皇后都放
         * 置完毕，则找到一个可能的解。当找到一个可能的解之后，将数组转换成表示棋盘状态的列表，
         * 并将该棋盘状态的列表加入返回列表。
         */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] queens = new int[n];
        Arrays.fill(queens,-1);
        Set<Integer> cols = new HashSet<>();
        Set<Integer> dg = new HashSet<>();
        Set<Integer> udg = new HashSet<>();
        backTrack(res,queens,n,0,cols,dg,udg);
        return res;
    }

    private void backTrack(List<List<String>> res,int[] queens,int n, int row,Set<Integer> cols,Set<Integer> dg,Set<Integer> udg) {
        if (row == n) {
           List<String> board = generateBoard(queens, n);
           res.add(board);
        } else {
            for (int y = 0; y < n;y++) {
                if (!cols.contains(y) && !dg.contains(row - y) && !udg.contains(row + y)) {
                    queens[row] = y;
                    cols.add(y);
                    dg.add(row - y);
                    udg.add(row + y);
                    backTrack(res,queens,n,row+1,cols,dg,udg);
                    queens[row] = -1;
                    cols.remove(y);
                    dg.remove(row - y);
                    udg.remove(row + y);
                }
            }
        }
    }

    private List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}