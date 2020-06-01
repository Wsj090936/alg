package linkedList;

/**
 * TODO
 *
 * @Author jiahao
 * @Date 2020/5/29 14:26
 */
public class DoTest {
    public static void main(String[] args) {
        int targetPrice = 400;// 400分 = 4元
        int roi = 400;// roi 数据库里扩大100倍的
        int price = 1;// 0.01 元
        int deltaPrice = targetPrice - price;
        int cashBack = deltaPrice * 100 / roi;// 转化为分
        System.out.println("cashBack:" + cashBack);

        long amount = Math.round(cashBack / 100.0) > 0 ? Math.round(cashBack / 100.0) : 1;
        System.out.println("amount:" + amount);
    }
}
