package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @Author jiahao
 * @Date 2020/10/24 21:46
 */
public class IsAnagram_242 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i < s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
        }
        for(int i = 0;i < t.length();i++){
            Integer count = map.get(t.charAt(i));
            if(count == null){
                return false;
            }else if(count > 1){
                count = count - 1;
                map.put(t.charAt(i),count);
            }else{
                map.remove(t.charAt(i));
            }
        }
        return map.isEmpty();
    }
}
