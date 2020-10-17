package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 202. 快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 *
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 *示例：
 *
 * 输入：19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * @Author jiahao
 * @Date 2020/10/16 19:48
 */
public class IsHappy_202 {
    public boolean isHappy(int n) {
        Map<Integer,Integer> map = new HashMap<>();
        while (n != 1){
            int temp = n;
            int res = 0;
            while (temp != 0){
                res += Math.pow(temp % 10,2);
                temp = temp / 10;
            }
            Integer count = map.getOrDefault(res, 0);
            if(count > 1){
                return false;
            }
            map.put(res,count + 1);
            n = res;
        }
        return true;
    }
}
