package leetcode.mid;

/**
 * 1201. 丑数 III
 * 请你帮忙设计一个程序，用来找出第 n 个丑数。
 *
 * 丑数是可以被 a 或 b 或 c 整除的 正整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3, a = 2, b = 3, c = 5
 * 输出：4
 * 解释：丑数序列为 2, 3, 4, 5, 6, 8, 9, 10... 其中第 3 个是 4。
 * 示例 2：
 *
 * 输入：n = 4, a = 2, b = 3, c = 4
 * 输出：6
 * 解释：丑数序列为 2, 3, 4, 6, 8, 9, 10, 12... 其中第 4 个是 6。
 * 示例 3：
 *
 * 输入：n = 5, a = 2, b = 11, c = 13
 * 输出：10
 * 解释：丑数序列为 2, 4, 6, 8, 10, 11, 12, 13... 其中第 5 个是 10。
 * 示例 4：
 *
 * 输入：n = 1000000000, a = 2, b = 217983653, c = 336916467
 * 输出：1999999984
 *
 * @Author jiahao
 * @Date 2020/9/18 21:38
 */
public class NthUglyNumber {

    private static int nthUglyNumber(int n,int a,int b,int c){
        long low = Math.min(Math.min(a,b),c);
        long high = n * low;
        long res = binary(low,high,a,b,c,n);
        long i = res % a;
        long i1 = res % b;
        long i2 = res % c;
        return (int)(res - Math.min(Math.min(i,i1),i2));
    }
    private static long binary(long left ,long right,long a,long b,long c,long n){
        if(left >= right){
            return left;
        }
        long mid = (left + right) / 2;
        long a_b = getMinM(a, b);
        long b_c = getMinM(b, c);
        long a_c = getMinM(a, c);
        long a_b_c = getMinM(a_b,c);
        long count_n = mid/a + mid/b  + mid/c - mid/a_b - mid/a_c - mid/b_c + mid/a_b_c;
        if(count_n == n){
            return mid;
        }
        if(count_n < n){
            return binary(mid + 1,right,a,b,c,n);
        }
        return binary(left,mid - 1,a,b,c,n);
    }


    private static long getMinM(long a,long b){
        long m1 = a;
        long n1 = b;

        long m = m1 % n1;
        while (m != 0){
            m1 = n1;
            n1 = m;
            m = m1 % n1;
        }
        return (a * b / n1);
    }

    public static void main(String[] args) {
    }
}
