
package stackAndQueue;

/**
 * 汉诺塔问题(修改版)
 *  移动时，必须经过中间的塔
 * @Author jiahao
 * @Date 2020/4/5 21:59
 */
public class HanoiProblem {

    /**
     * 递归方式
     * @param num 左边的柱子上塔的高度
     * @param left left
     * @param mid mid
     * @param right right
     * @return
     */
    public static int hanoiProblem(int num, String left, String mid, String right){
        if(num < 1){
            return 0;
        }
        return handle(num, left, mid, right,left,right);
    }

    private static int handle(int num, String left, String mid, String right, String from, String to) {
        if(num == 1){//只有最上层的元素可取时
            if(from.equals(mid) || to.equals(mid)){// 从中间移动或者从其他地方移动到中间
                System.out.println("Move 1 from" + from + "to" + mid);// 终点只可能是mid
                return 1;
            }else {
                // 从左边移动到右边或者从右边移动到左边，需要至少两步
                System.out.println("Move 1 from" + from + "to" + mid);
                System.out.println("Move 1 from" + mid + "to" + to);
                return 2;
            }
        }
        // 如果将剩下N个元素移动到中间或从中间移出
        if(from.equals(mid) || to.equals(mid)){
            String another = (from.equals(left) || to.equals(left)) ? right : left;// 除去 from 和 to 剩下的元素
            // 先将 1~n-1的元素移动到不相干的柱子上
            int part1 = handle(num - 1, left, mid, right, from, another);
            // 再将元素n移动到目的地
            int part2 = 1;
            System.out.println("Move 1 from" + from + "to" + to);
            // 再将剩下的的元素移动到目的地
            int part3 = handle(num - 1, left, mid, right, another,to);
            return part1 + part2 + part3;
        }else {
            // 剩下就是从左移动到右边或者从右边移动到左了
            // 先将 1~N-1移动
            int part1 = handle(num - 1,left,mid,right,from,to);
            // 将第n个移动到中间
            int part2 = 1;
            System.out.println("Move 1 from" + from + "to" + mid);
            // 再将 n-1个移动到另一边
            int part3 = handle(num - 1,left,mid,right,to,from);
            int part4 = 1;
            // 将中间的移动到右边
            System.out.println("Move 1 from" + mid + "to" + right);
            // 将剩下的从左移动到右边
            int part5 = handle(num - 1,left, mid, right, from, to);

            return  part1 + part2 + part3 + part4 + part5;
        }
    }

    public static void main(String[] args) {
        int i = hanoiProblem(2, "left", "mid", "right");
        System.out.println("需要" + i + "步");
    }
}
