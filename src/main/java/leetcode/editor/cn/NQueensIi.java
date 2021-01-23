//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：n = 4
//输出：2
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
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
// 👍 227 👎 0

package leetcode.editor.cn;

import java.util.*;

public class NQueensIi {
    public static void main(String[] args) {
        Solution solution = new NQueensIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int totalNQueens(int n) {
        Set<Integer> cols = new HashSet<>();
        Set<Integer> dg = new HashSet<>();
        Set<Integer> udg = new HashSet<>();
        return backTrack(n,0,cols,dg,udg);
    }

        private int backTrack(int n, int row,Set<Integer> cols,Set<Integer> dg,Set<Integer> udg) {
            if (row == n) {
                return 1;
            } else {
                int count = 0;
                for (int y = 0; y < n;y++) {
                    if (!cols.contains(y) && !dg.contains(row - y) && !udg.contains(row + y)) {
                        cols.add(y);
                        dg.add(row - y);
                        udg.add(row + y);
                        count += backTrack(n,row+1,cols,dg,udg);
                        cols.remove(y);
                        dg.remove(row - y);
                        udg.remove(row + y);
                    }
                }
                return count;
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}