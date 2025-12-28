package src.stockseries;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock obj = new BestTimeToBuyAndSellStock();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(obj.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        /*
        //profit[i][k][0] -> profit on ith day with max k transactions having 0 stocks in hand
        int[][][] profit = new int[prices.length][2][2];  //k can be either 0,1 and stocks in hand can be either 0,1

        for(int i=0;i<prices.length;i++){
            dp[i][1][0] = Math.max(dp[i-1][1][0],dp[i-1][1][1] + prices[i]);
            dp[i][1][1] = Math.max(dp[i-1][1][1],dp[i-1][0][0]-prices[i]);
        }

        This can be further simplified down to below as we see that our ith result only depends on the i-1 day so no need to store rest of the previous days profit in array.
        */

        int p_i10 = 0; // profit at ith day when 1 transaction has been done and no stock in hand
        int p_i11 = Integer.MIN_VALUE; // profit at ith day when 1 transaction is done and you have a stock in hand.We assume that the buy price is -infinity

        for(int i=0;i<prices.length;i++){
            p_i10 = Math.max(p_i10,p_i11 + prices[i]);
            p_i11 = Math.max(p_i11,-prices[i]); // Math.max(p_i11,p_i-100-prices[i]); can be simplified to Math.max(p_i11,-prices[i]); as p_i-100 means i-1th days profit when no transaction has been done and nop stock inhand which will always be 0.
        }
        return p_i10;
    }
}