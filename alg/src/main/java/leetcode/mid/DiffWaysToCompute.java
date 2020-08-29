package leetcode.mid;

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

    /**
     * 分治递归，比较好理解
     * 就是将式子拆分为左右两部分
     * @param input
     * @return
     */
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

    /**
     * 动态规划的方式
     * @param input
     * @return
     */
    private static ArrayList diffWaysToComputeV2(String input){
        if(input == null || input.length() == 0){
            return new ArrayList<>();
        }
        // 首先将数字和运算符按顺序拆分出来
        List<Integer> numList = new ArrayList<>();
        List<Character> opList = new ArrayList<>();
        int num = 0;
        for (int i = 0; i < input.length();i++){
            char ch = input.charAt(i);
            if(isOperate(ch)){
                opList.add(ch);
                numList.add(num);
                num = 0;
                continue;
            }
            // 数字
            num = num * 10 + input.charAt(i) - '0';
        }
        numList.add(num);
        int numSize = numList.size();
        // 动态规划，dp[x][y] 表示从x 到 y的下标的数字计算的结果集
        ArrayList[][] dp = new ArrayList[numSize][numSize];
        // 初始化
        for(int i = 0;i < numSize;i++){
            ArrayList<Integer> res = new ArrayList<>();
            res.add(numList.get(i));
            dp[i][i] = res;
        }
        //两个数字相互计算开始
        for(int n = 2; n <= numSize;n++ ){
            // 开始的下标
            for(int i = 0; i < numSize;i++){
                // 结束下标
                int j = i + n - 1;
                if(j >= numSize){
                    break;
                }
                ArrayList<Integer> res = new ArrayList<>();
                for(int x = i; x < j;x++){
                    List<Integer> listLeft = dp[i][x];
                    List<Integer> listRight = dp[x + 1][j];
                    for (Integer left : listLeft) {
                        for (Integer right : listRight) {
                            // 第x个数字的下标就是运算符的位置
                            char op = opList.get(x);
                            res.add(calculate(left, op, right));
                        }
                    }
                    dp[i][j] = res;
                }
            }
        }
        return dp[0][numSize - 1];
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
        long start = System.currentTimeMillis();
        List<Integer> list = diffWaysToCompute("2*3-4*5-8*9+10-11");
        long end1 = System.currentTimeMillis();

        System.out.println(list.toString());
        System.out.println(end1 - start);
        ArrayList list1 = diffWaysToComputeV2("2*3-4*5-8*9+10-11");
        long end2 = System.currentTimeMillis();

        System.out.println(list1.toString());
        System.out.println(end2 - start);

    }
}
