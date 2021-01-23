package leetcode.mid;


/**
 * TODO
 *
 * @Author jiahao
 * @Date 2021/1/23 19:09
 */
public class MyPow_offer_16 {
    public double myPow(double x, int n) {
        long N = n;
        return N > 0 ? cacl(x,N) : 1/ cacl(x,-N);
    }

    private double cacl(double x, long N) {
        if(N == 0){
            return 1;
        }
        double y = cacl(x, N / 2);

        return N % 2 == 0 ? y * y : y * y * x;
    }
}
