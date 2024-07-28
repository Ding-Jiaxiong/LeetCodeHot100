package LeetCodeHot100.best_time_to_buy_and_sell_stock77;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 思路：贪心 动规
 *
 * @author Ding Jiaxiong
 */

public class Main {

    public static int maxProfit(int[] prices) {

        int cost = Integer.MAX_VALUE;
        int profit = 0;

        for (int price : prices) {

            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);

        }

        return profit;
    }

    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};

        System.out.println(maxProfit(prices));

    }
}
