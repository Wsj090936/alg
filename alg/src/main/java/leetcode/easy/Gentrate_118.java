package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 * @Author jiahao
 * @Date 2020/9/26 19:40
 */
public class Gentrate_118 {
    public static List<List<Integer>> generate(int numRows) {
        if(numRows <= 0){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.get(0).add(1);
        for(int i = 1;i < numRows;i++){
            List<Integer> list = new ArrayList<>();
            // 第一行
            list.add(1);

            for(int j = 1;j < i;j++){
                List<Integer> pre = res.get(i - 1);
                list.add(pre.get(j) + pre.get(j - 1));
            }
            // 最后一行
            list.add(1);
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        generate(5);
    }
}
