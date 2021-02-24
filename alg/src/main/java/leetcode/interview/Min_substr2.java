package leetcode.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @Author jiahao
 * @Date 2021/2/2 9:50
 */
public class Min_substr2 {

    public static String minSubStr(String str,String targetStr){
        if(targetStr == null){
            return "";
        }
        int[] strArr = new int[26];
        int[] targetArr = new int[26];
        // 初始化
        for(int i = 0;i < targetStr.length();i++){
            targetArr[targetStr.charAt(i) - 'a'] = 1;
        }
        int curLength = 0;
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        String res = "";
        for(int j = 0;j < str.length();j++){
            if(strArr[str.charAt(j) - 'a'] == 0 && targetArr[str.charAt(j) - 'a'] == 1){
                // 找到首次出现的
                curLength++;
            }
            strArr[str.charAt(j) - 'a']++;
            for(;left <= j;left++){
                if(strArr[str.charAt(left) - 'a'] == 1 && targetArr[str.charAt(left) - 'a'] == 1){
                    // 找到了
                    if(curLength == targetStr.length()){
                        String strRes = str.substring(left,j - left + 1);
                        res = minLength > strRes.length() ? strRes : res;
                        // left右移
                        strArr[str.charAt(left) - 'a']--;
                        left++;
                        curLength--;
                    }
                    break;
                }
                strArr[str.charAt(left) - 'a']--;
            }

        }

        return res;

    }

    public static void main(String[] args) {
        System.out.println(minSubStr("abcdefg","abd"));
    }

}
