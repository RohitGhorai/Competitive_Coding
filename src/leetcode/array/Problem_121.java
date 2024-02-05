package leetcode.array;

public class Problem_121 {
    public static void main(String[] args) {
        int[] arr = {7,5,1,4,3,6,2};
        int ans = method_2(arr);
        System.out.println(ans);
    }
    static int maxProfit(int[] prices) {
        int max_profit = 0;
        for (int i = 0; i < prices.length; i++){
            for (int j = i + 1; j < prices.length; j++){
                if (prices[j] - prices[i] > max_profit) max_profit = prices[j] - prices[i];
            }
        }
        return max_profit;
    }

    static int method_2(int[] prices){
        int maxProfit = 0;
        int buyPrice = prices[0];
        for (int i = 1; i < prices.length; i++){
            maxProfit = Math.max(maxProfit, prices[i] - buyPrice);
            buyPrice = Math.min(buyPrice, prices[i]);
        }
        return maxProfit;
    }
}
