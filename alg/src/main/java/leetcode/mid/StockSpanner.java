package leetcode.mid;

import java.util.Stack;

/**
 * 编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。
 *
 * 今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
 *
 * 例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]。
 *
 *  
 *
 * 示例：
 *
 * 输入：["StockSpanner","next","next","next","next","next","next","next"], [[],[100],[80],[60],[70],[60],[75],[85]]
 * 输出：[null,1,1,1,2,1,4,6]
 * 解释：
 * 首先，初始化 S = StockSpanner()，然后：
 * S.next(100) 被调用并返回 1，
 * S.next(80) 被调用并返回 1，
 * S.next(60) 被调用并返回 1，
 * S.next(70) 被调用并返回 2，
 * S.next(60) 被调用并返回 1，
 * S.next(75) 被调用并返回 4，
 * S.next(85) 被调用并返回 6。
 *
 * 注意 (例如) S.next(75) 返回 4，因为截至今天的最后 4 个价格
 * (包括今天的价格 75) 小于或等于今天的价格。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/online-stock-span
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author jiahao
 * @Date 2020/9/3 22:04
 */
public class StockSpanner {
    Stack<Integer> weights;
    Stack<Integer> prices;
    public StockSpanner() {
        weights = new Stack<>();
        prices = new Stack<>();
    }

    public int next(int price) {
        int weight = 1;
        // 每次调用，都会弹出比当前价格小的数
        while (!prices.isEmpty() && prices.peek() <= price){
            prices.pop();
            // 下一个过来时，只需要用1 + 上面所有比他小的天数综合
            weight += weights.pop();
        }
        // 将弹出的或者未弹出的数与当天的跨度记录下来
        prices.push(price);
        weights.push(weight);
        return weight;
    }
}
