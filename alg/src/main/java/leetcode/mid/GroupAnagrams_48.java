package leetcode.mid;

import java.util.*;

/**
 *49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * @Author jiahao
 * @Date 2020/10/26 20:57
 */
public class GroupAnagrams_48 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String each : strs){
            char[] chars = each.toCharArray();
            Arrays.sort(chars);
            List<String> stringList = map.get(String.valueOf(chars));
            if(stringList == null){
                stringList = new ArrayList<>();
            }
            stringList.add(each);
            map.put(String.valueOf(chars),stringList);
        }
        return new ArrayList<>(map.values());
    }

    private void getArr(int[] map,String[] strs,List<String> path,int start,List<List<String>> res){
        if(start >= strs.length ){
            List<String> arr = new ArrayList<>(path);
            res.add(arr);
        }
        int[] newMap = new int[26];
        for(int i = 0;i < strs[start].length();i++){
            map[strs[start].charAt(i) - 'a']--;
            newMap[strs[start].charAt(i) - 'a']++;
            if(map[strs[start].charAt(i) - 'a'] < 0){
                // 不符合直接查下一个
                List<String> newList = new ArrayList<>();
                newList.add(strs[start]);
                getArr(newMap,strs,newList,start + 1,res);

            }
        }
        // 符合
        getArr(map,strs,path,start + 1,res);
    }

    public static void main(String[] args) {
        Long l = -1L;
        System.out.println(l.compareTo(0L));
    }

}
