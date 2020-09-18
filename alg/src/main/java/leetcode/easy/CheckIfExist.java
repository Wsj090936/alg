package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1346. 检查整数及其两倍数是否存在
 * 给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，满足 N 是 M 的两倍（即，N = 2 * M）。
 *
 * 更正式地，检查是否存在两个下标 i 和 j 满足：
 *
 * i != j
 * 0 <= i, j < arr.length
 * arr[i] == 2 * arr[j]
 *
 *
 * 示例 1：
 *
 * 输入：arr = [10,2,5,3]
 * 输出：true
 * 解释：N = 10 是 M = 5 的两倍，即 10 = 2 * 5 。
 * 示例 2：
 *
 * 输入：arr = [7,1,14,11]
 * 输出：true
 * 解释：N = 14 是 M = 7 的两倍，即 14 = 2 * 7 。
 * 示例 3：
 *
 * 输入：arr = [3,1,7,11]
 * 输出：false
 * 解释：在该情况下不存在 N 和 M 满足 N = 2 * M 。
 *
 * @Author jiahao
 * @Date 2020/9/17 19:32
 */
public class CheckIfExist {
    // 普通方法
    public static boolean checkIfExist(int[] arr) {
        if(arr == null || arr.length <= 1){
            return false;
        }
        Arrays.sort(arr);
        for(int i = 0;i < arr.length;i++){
            for(int j = i + 1;j < arr.length;j++){

                if(Math.abs(arr[j]) > Math.abs(arr[i] * 2)){
                    // 大于2倍，不可能了
                    break;
                }
                if (arr[j] == arr[i] * 2){
                    return true;
                }
                if(arr[j] * 2 == arr[i]){
                    return true;
                }
            }
        }
        return false;
    }
    // 哈希表
    public static boolean checkIfExistHash(int[] arr) {
        if(arr == null || arr.length <= 1){
            return false;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int each : arr) {
            map.put(each,map.getOrDefault(each,0) + 1);
        }
        for(int each : arr){
            Integer num = map.getOrDefault(each * 2,0);

            if(each != 0 && num >= 1){
                return true;
            }
            if(each == 0 && num > 1){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkIfExistHash(new int[]{10,2,5,3}));
    }
}
