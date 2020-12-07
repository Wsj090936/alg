package leetcode.mid;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 89. 格雷编码
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 *
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。
 *
 * 格雷编码序列必须以 0 开头。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,3,2]
 * 解释:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 *
 * 对于给定的 n，其格雷编码序列并不唯一。
 * 例如，[0,2,3,1] 也是一个有效的格雷编码序列。
 *
 * 00 - 0
 * 10 - 2
 * 11 - 3
 * 01 - 1
 * 示例 2:
 *
 * 输入: 0
 * 输出: [0]
 * 解释: 我们定义格雷编码序列必须以 0 开头。
 *      给定编码总位数为 n 的格雷编码序列，其长度为 2n。当 n = 0 时，长度为 20 = 1。
 *      因此，当 n = 0 时，其格雷编码序列为 [0]。
 *
 * @Author jiahao
 * @Date 2020/12/7 20:38
 */
public class GrayCode_89 {
    public static List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
//        doCode(res,0,1,n);
        doCode(res,n,(int) Math.pow(n,2),set);
        return res;
    }
    public static List<Integer> grayCodeV2(int n) {
        List<Integer> res = new ArrayList<>();

        doCode(res,0,0,0,n);
        return res;
    }

    public static void doCode(List<Integer> res,int count,int path,int n,int oridinN){
        if(n == oridinN){
            res.add(path);
            //
            return;
        }
        if(count % 2 == 0){
            doCode(res,count,path * 2,n + 1,oridinN);// 计算左子树
            doCode(res,count + 1,path * 2 + 1,n + 1,oridinN);// 计算柚子树
        }else {
            doCode(res,count + 1,path * 2 + 1,n + 1,oridinN);
            doCode(res,count,path * 2,n + 1,oridinN);
        }


    }
    public static boolean doCode(List<Integer> res,int n,int all, Set<Integer> set) {
            if(all == res.size()){
                return true;
            }
            int last = res.get(res.size() - 1);
            for(int i = 0;i < n;i++){
                int cur = last;
                cur ^= 1 << i;
                if(set.contains(cur) ){
                    continue;
                }
                res.add(cur);
                set.add(cur);
                if(doCode(res,n,all,set)){
                    return true;
                }
                res.remove(res.size() - 1);
                set.remove(cur);
            }
            return false;
        }

    public static void main(String[] args) {
        System.out.println(grayCodeV2(2));
    }
}
