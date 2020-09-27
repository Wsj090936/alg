package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 * @Author jiahao
 * @Date 2020/9/27 19:50
 */
public class GetRow_119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>(rowIndex + 1);
        for(int i = 0;i < rowIndex;i++){
            list.add(1);
            for(int j = i - 1;j > 0;j--){
                list.set(j,list.get(j) + list.get(j - 1));
            }
        }
        return list;
    }
}
