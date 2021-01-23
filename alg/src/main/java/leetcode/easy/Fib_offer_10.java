package leetcode.easy;

/**
 * TODO
 *
 * @Author jiahao
 * @Date 2021/1/21 20:24
 */
public class Fib_offer_10 {
    public int fib(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int pre = 0,cur = 1;
        int ans = 0;
        for(int i = 2;i <=n;i++){
            ans = (pre + cur) % 1000000007;
            pre = cur;
            cur = ans;
        }
        return ans;
    }
}
