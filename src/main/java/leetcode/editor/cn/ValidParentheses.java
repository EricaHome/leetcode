//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 2085 👎 0

package leetcode.editor.cn;
public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
       if (s == null || s == "") return true;
        int length = s.length();
        char[] chars = new char[length];
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (index > 0 && chars[index-1] == '(' && s.charAt(i) == ')') {
                index--;
            } else if (index > 0 && chars[index-1] == '[' && s.charAt(i) == ']') {
                index--;
            } else if (index > 0 && chars[index-1] == '{' && s.charAt(i) == '}') {
                index--;
            } else {
                chars[index++] = s.charAt(i);
            }
        }
        return index > 0 ? false : true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}