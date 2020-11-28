package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 *二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。
 *
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 *
 *
 *
 * 例如，上面的二进制手表读取 “3:25”。
 *
 * 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
 *
 *  
 *
 * 示例：
 *
 * 输入: n = 1
 * 返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-watch
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author jiahao
 * @Date 2020/11/28 13:11
 */
public class ReadBinaryWatch_401 {
    List<String> res = new ArrayList<>();
    public List<String> readBinaryWatch(int num) {
        int[] arr = new int[4 + 6];// 前4位代表小时 后6位代表分钟
        read(num,0,0,arr);
        return res;
    }
    public void read(int num,int start,int cur,int[] arr){
        if(num == cur){
            // 当前1的个数已经达到要求
            // 计算小时
            int hour = arr[0] + arr[1] * 2 + arr[2] * 4 + arr[3] * 8;
            // 计算分钟
            int minute = arr[4] + arr[5] * 2 + arr[6] * 4 + arr[7] * 8 + arr[8] * 16 + arr[9] * 32;
            if(hour < 12 && minute < 60){
                String hourStr = String.valueOf(hour);
                String minuteStr = minute >= 10 ? String.valueOf(minute) : "0" + minute;
                res.add(hourStr + ":" + minuteStr);
            }

            return;
        }

        for(int i = start;i <= 9;i++){
            arr[i] = 1;
            read(num,i + 1,cur + 1,arr);
            arr[i] = 0;
        }
    }

}
