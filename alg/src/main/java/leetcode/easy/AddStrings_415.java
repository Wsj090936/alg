package leetcode.easy;

/**
 *
 * @Author jiahao
 * @Date 2020/12/7 20:23
 */
public class AddStrings_415 {
    public String addStrings(String num1, String num2) {
        int i = num1.length();
        int j = num2.length();
        int pre = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (i >= 0 && j >= 0){
            int sum = pre;
            sum += num1.charAt(i--) - '0';
            sum += num2.charAt(j--) - '0';
            pre = sum / 10;
            stringBuilder.append(sum % 10);
        }
        // 第一个数多了
        while (i >= 0){
            int sum = pre + num1.charAt(i--) - '0';
            pre = sum / 10;
            stringBuilder.append(sum % 10);

        }
        while (j >= 0){
            int sum = pre + num2.charAt(j--) - '0';
            pre = sum / 10;
            stringBuilder.append(sum % 10);

        }
        if(pre == 1){
            stringBuilder.append(pre);
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println('9' - '0');
    }
}
