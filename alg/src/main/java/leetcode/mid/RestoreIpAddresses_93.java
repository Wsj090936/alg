package leetcode.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原IP地址
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 *
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 *
 * 输入：s = "1111"
 * 输出：["1.1.1.1"]
 * 示例 4：
 *
 * 输入：s = "010010"
 * 输出：["0.10.0.10","0.100.1.0"]
 * 示例 5：
 *
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 3000
 * s 仅由数字组成
 * 通过次数91,647提交次数179,774
 *
 * @Author jiahao
 * @Date 2020/12/14 20:09
 */
public class RestoreIpAddresses_93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();

        if(s.length() < 4 || s.length() > 12 ){
            return res;
        }
        doRestore(s,res,0,0,new ArrayList<>());
        return res;
    }

    private void doRestore(String s,List<String> res,int start,int len,List<String> path){
        if(path.size() == 4){
            if(len == s.length()){
                String str = path.get(0) + "." + path.get(1) + "." + path.get(2) + "." + path.get(3);
                res.add(str);
                return;
            }
        }
        for(int i = 1;i <= 3;i++){
            if(start + i > s.length()){
                continue;
            }
            String substring = s.substring(start, start + i);
            if(substring.length() > 1 && substring.charAt(0) == '0'){
                continue;
            }
            int num = Integer.valueOf(substring);
            if(num > 255){
                break;
            }
            // 剩下的就是正确的
            path.add(substring);
            doRestore(s,res,start + i,len + substring.length(),path);
            path.remove(path.size() - 1);

        }
    }
}
