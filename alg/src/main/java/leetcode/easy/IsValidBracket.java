package leetcode.easy;

import java.io.Serializable;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author jiahao
 * @Date 2020/6/8 20:09
 */
public class IsValidBracket {

    public static boolean isValid(String str){
        if(str == null || str.length() == 0 ){
            return true;
        }
        int length = str.length();
        if(length % 2 > 0){
            // 如果长度是奇数，说明肯定存在不完全的括号，直接返回false
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char cur;
        char peek;
        for(int i = 0; i < length; i++){
            cur = str.charAt(i);
            if(isRightHalf(cur)){
                // 如果是右边的括号，从栈中弹出一个比较一下
                peek = stack.isEmpty() ? '#' : stack.pop();
                if(peek != getLeftHalf(cur)){
                    return false;
                }
            }else {
                stack.push(cur);
            }

        }
        return stack.isEmpty();

    }

    private static boolean isRightHalf(char c){
        return c == ')' || c == ']' || c == '}';
    }

    private static char getLeftHalf(char c){
        switch (c){
            case ')':
                return '(';
            case ']':
                return '[';
            case '}':
                return '{';
        }
        return '0';
    }

    public static void main(String[] args) {
        System.out.println(isValid("(()[{}])"));
    }

}
