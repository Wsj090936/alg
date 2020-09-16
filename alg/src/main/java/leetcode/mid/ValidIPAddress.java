package leetcode.mid;

/**
 * 468. 验证IP地址
 * 编写一个函数来验证输入的字符串是否是有效的 IPv4 或 IPv6 地址。
 *
 * IPv4 地址由十进制数和点来表示，每个地址包含4个十进制数，其范围为 0 - 255， 用(".")分割。比如，172.16.254.1；
 *
 * 同时，IPv4 地址内的数不会以 0 开头。比如，地址 172.16.254.01 是不合法的。
 *
 * IPv6 地址由8组16进制的数字来表示，每组表示 16 比特。这些组数字通过 (":")分割。比如,  2001:0db8:85a3:0000:0000:8a2e:0370:7334 是一个有效的地址。而且，我们可以加入一些以 0 开头的数字，字母可以使用大写，也可以是小写。所以， 2001:db8:85a3:0:0:8A2E:0370:7334 也是一个有效的 IPv6 address地址 (即，忽略 0 开头，忽略大小写)。
 *
 * 然而，我们不能因为某个组的值为 0，而使用一个空的组，以至于出现 (::) 的情况。 比如， 2001:0db8:85a3::8A2E:0370:7334 是无效的 IPv6 地址。
 *
 * 同时，在 IPv6 地址中，多余的 0 也是不被允许的。比如， 02001:0db8:85a3:0000:0000:8a2e:0370:7334 是无效的。
 *
 * 说明: 你可以认为给定的字符串里没有空格或者其他特殊字符。
 *
 * 示例 1:
 *
 * 输入: "172.16.254.1"
 *
 * 输出: "IPv4"
 *
 * 解释: 这是一个有效的 IPv4 地址, 所以返回 "IPv4"。
 * 示例 2:
 *
 * 输入: "2001:0db8:85a3:0:0:8A2E:0370:7334"
 *
 * 输出: "IPv6"
 *
 * 解释: 这是一个有效的 IPv6 地址, 所以返回 "IPv6"。
 * 示例 3:
 *
 * 输入: "256.256.256.256"
 *
 * 输出: "Neither"
 *
 * 解释: 这个地址既不是 IPv4 也不是 IPv6 地址。
 * 来源：力扣
 * https://leetcode-cn.com/problems/validate-ip-address/
 * @Author jiahao
 * @Date 2020/9/16 19:45
 */
public class ValidIPAddress {
    public static String validIPAddress(String IP) {
        if(IP == null || IP.length() == 0){
            return "Neither";
        }
        // 先验证V4 一共4为，4个十进制数，并且不会以0开头
        boolean isV4 = IP.chars().filter(ch -> ch == '.').count() == 3;
        if(isV4){
            String[] v4 = IP.split("\\.");
            if(v4.length != 4){
                return "Neither";
            }
            for(String str : v4){

                if(str.length() == 0 || str.length() > 3){
                    return "Neither";
                }
                int num = 0;
                for(int i = 0;i < str.length();i++){
                    char c = str.charAt(i);
                    if(i == 0 && str.length() != 1){
                        if(c == '0'){
                            return "Neither";
                        }
                    }
                    // 是字母，也不算
                    if(c >= 'a' && c <= 'z'){
                        return "Neither";

                    }
                    if(c >= 'A' && c <= 'Z'){
                        return "Neither";

                    }

                }
                int i = Integer.parseInt(str);
                 if(i > 255){
                     return "Neither";
                 }
            }
            return "IPv4";

        }
        boolean isV6 = IP.chars().filter(ch -> ch == ':').count() == 7;
        if(isV6){
            String[] v6 = IP.split(":");
            if(v6.length != 8){
                return "Neither";
            }
            // 长度为8才判断V6
            String hex = "0123456789abcdefABCDEF";
            for(String str : v6){
                if(str.length() == 0 || str.length() > 4){
                    return "Neither";
                }
                for(Character each : str.toCharArray()){
                    if(hex.indexOf(each) == -1){
                        return "Neither";
                    }
                }
            }
            return "IPv6";
        }

        // V6的验证

        return "Neither";

    }
    public static void main(String[] args) {
        validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334");
    }
}
