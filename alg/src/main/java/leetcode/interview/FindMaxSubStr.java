package leetcode.interview;

import java.util.*;

/**
 * TODO
 *
 * @Author jiahao
 * @Date 2021/2/3 21:43
 */
public class FindMaxSubStr {
    private static List<Map<String,Object>> findMaxSubStr(String str){
        if(str == null || str.length() <= 0){
            return new ArrayList<>();
        }
        List<String> subStrList = new ArrayList<>();
        for(int i = str.length() - 1;i >= 0 ;i--){
            subStrList.add(str.substring(i));
        }
        Collections.sort(subStrList);
        Map<String,Integer> strMap = new HashMap<>();
        int maxLen = 0;
        for(int i = 0;i < subStrList.size() - 1;i++){
            String ptr = subStrList.get(i);
            String cur = subStrList.get(i + 1);
            int sameLen = getSameLen(ptr, cur);
            if(sameLen > 0){
                String tempStr = ptr.substring(0,sameLen);
                maxLen = maxLen > sameLen ? maxLen : sameLen;

                Integer count = strMap.get(tempStr);
                if(count == null){
                    strMap.put(tempStr,2);
                }else {
                    strMap.put(tempStr,count + 1);
                }
            }

        }
        // 找出最大的 并返回
        List<Map<String,Object>> list = new ArrayList<>();
        Set<Map.Entry<String, Integer>> entries = strMap.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            Integer value = entry.getValue();
            if(value < 2){
                continue;
            }
            if(entry.getKey().equals("")){
                continue;
            }
            String key = entry.getKey();
            // 找出重复的，且最大的
            if(key.length() == maxLen){
                Map<String,Object> map = new HashMap<>();
                map.put("maxSubStr",entry.getKey());
                map.put("count",entry.getValue());
                list.add(map);
            }

        }

        return list;
    }
    // 找出公共
    private static int getSameLen(String str1,String str2){
        int len = 0;
        for(int i = 0;i < str1.length() && i < str2.length();i++){
            if(str1.charAt(i) != str2.charAt(i)){
                break;
            }else {
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        findMaxSubStr("abcdebcdde");
    }

}
