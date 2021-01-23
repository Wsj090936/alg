package se;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * TODO
 *
 * @Author jiahao
 * @Date 2021/1/23 10:28
 */
public class HuaweiTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int start = sc.nextInt();
        int end = sc.nextInt();
    }

//    public static String reversWords(String s,int start,int end){
//        if(s == null || s.length()<= 0 || start < 0){
//            return "EMPTY";
//        }
//        // 找到区间内的单词
//        int curWord = 0;// 表示当前是字符串第几个单词
//        String[] split = s.split(" ");
//        List<String> list = new ArrayList<>();
//        int left = 0;
//        int right = split.length;
//        for(int i = 0;i < split.length;i++){
//            String s1 = split[i];
//            if(!s1.equals("")){
//                curWord++;
//            }
//            // 检查当前单词是不是在区间内
//            if(curWord >= start && curWord <= end){
//                list.add(s1);
//            }
//            if(curWord == start){
//                // 如果是区间开始，则需要记录左半部分位置
//                left = i;
//            }
//            if(curWord == end){
//                // 如果是结束，则记录结束坐标
//                right = i;
//                break;
//            }
//        }
//        if(curWord < end - start - 1){
//            return "EMPTY";
//        }
//        // 将区间内的单词翻转
//        int start1 = 0;
//        int end1 = list.size();
//        while (start1 <= end1){
//            swap(list,start,end);
//            start1++;
//            end1--;
//        }
//
//        StringBuilder result = new StringBuilder();
//        for (int i = 0; i < list.size(); i++) {
//            if(i == list.size() - 1){
//                result.append(list.get(i));
//            }else {
//                result.append(list.get(i)).append(" ");
//            }
//        }
//        // 左部分
//        StringBuilder leftStr = new StringBuilder();
//        for(int i = 0;i < left;i++){
//            leftStr.append(split[i]);
//        }
//        // 右部分
//        StringBuilder rightStr = new StringBuilder();
//        for(int i = right + 1;i < split.length;i++){
//            rightStr.append(split[i]);
//        }
//        StringBuilder res = leftStr.append(result.toString()).append(rightStr.toString());
//        return res.toString();
//    }



    private static void swap(List<String> strArr,int a,int b){
        String temp = strArr.get(a);
        strArr.set(a,strArr.get(b));
        strArr.set(b,temp);
    }
}
