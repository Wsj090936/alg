package leetcode.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. Z 字形变换
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * @Author jiahao
 * @Date 2020/9/23 21:23
 */
public class Zbianhuan_6 {
    public String convert(String s, int numRows) {
        List<StringBuilder> list = new ArrayList<>();
        // 构建初始化每一行
        for(int i = 0;i < Math.min(numRows,s.length());i++){
            list.add(new StringBuilder());
        }
        int curRow = 0;
        // 初始时向下
        boolean goDown = true;
        for(char c : s.toCharArray()){
            list.get(curRow).append(c);
            if(curRow == numRows - 1){
                goDown = !goDown;
            }
            curRow += goDown ? 1 : -1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(StringBuilder each : list){
            stringBuilder.append(each);
        }
        return stringBuilder.toString();
    }
}
