package leetcode.mid;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。
 * 你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
 *
 * 示例 1:
 *
 * 输入: "2-1-1"
 * 输出: [0, 2]
 * 解释:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * 示例 2:
 *
 * 输入: "2*3-4*5"
 * 输出: [-34, -14, -10, -10, 10]
 * 解释:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/different-ways-to-add-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author jiahao
 * @Date 2020/8/29 15:47
 */
public class DiffWaysToCompute {

    private static Map<String,List<Integer>> map = new HashMap<>();

    public static List<Integer> diffWaysToCompute(String input) {
        if(input == null || input.length() == 0){
            return new ArrayList<>();
        }
        // 有解直接返回
        if(map.containsKey(input)){
            return map.get(input);
        }
        // 递归的结束条件 全为数字
        List<Integer> res = new ArrayList<>();
        Integer index = 0;
        int len = 0;
        int num = 0;
        while (index < input.length() && !isOperate(input.charAt(index))){
            // 计算纯数字的大小 如果都是数字，大小计算不会出错
            num = num * 10 + input.charAt(index) - '0';
            index++;
        }
        if(index == input.length()){
            res.add(num);
            map.put(input,res);
            return res;
        }
        // 递归分治
        for(int i = 0 ;i < input.length();i++){
            if(isOperate(input.charAt(i))){
                //遇到操作符 就分开
                List<Integer> listLeft = diffWaysToCompute(input.substring(0, i));// 包左不包右
                List<Integer> listRight = diffWaysToCompute(input.substring(i + 1));
                //将结果分别运算
                for (Integer left : listLeft) {
                    for (Integer right : listRight) {
                        char op = input.charAt(i);
                        res.add(calculate(left, op, right));
                    }
                }

            }
        }
        map.put(input,res);
        return res;

    }
    private static boolean isOperate(char c){
        return c == '+' || c == '-' || c == '*';
    }
    private static Integer calculate(int num1,char op,int num2){
        switch (op){
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            default:
                return -1;
        }
    }

    public static void main(String[] args) {
        List<Integer> list = diffWaysToCompute("2*3-4*5");
        System.out.println(list.toString());
    }
}
