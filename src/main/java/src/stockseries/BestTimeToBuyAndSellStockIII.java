package src.stockseries;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
public class BestTimeToBuyAndSellStockIII {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIII obj = new BestTimeToBuyAndSellStockIII();
        int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println(obj.maxProfit(prices));
    }
    public int maxProfit(int[] prices) {
        /*
        //profit[i][3][0] -> profit on ith day with max 2 transactions having 0 stocks in hand
        int[][][] profit = new int[prices.length][3][2];  //k can be from 0 to at most 2 and stocks in hand can be either 0,1. Here n is the length of the prices array.

Here we increase k when we buy a stock.

        for(int i=0;i<prices.length;i++){
            for(int k=0;k<3;k++){
                dp[i][k][0] = Math.max(dp[i-1][k][0],dp[i-1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i]);
            }
        }
        Here we can consider when k = 0 , then if we have stock in hand then profit would be -infinity and if we dont have a stock in hand then profit is 0
        This can be further simplified down to below as we see that our ith result only depends on the i-1 day and since k can only range from 0 to 2, we can store these values in seperate variables so no need to store rest of the previous days profit in array.
        */

        int p_i10 = 0; // profit at ith day when 1 transaction has been done and no stock in hand
        int p_i11 = Integer.MIN_VALUE; // profit at ith day when 1 transaction is done and you have a stock in hand.We assume that the buy price is -infinity
        int p_i20 = 0; // profit at ith day when 2 transaction has been done and no stock in hand
        int p_i21 = Integer.MIN_VALUE; // profit at ith day when 2 transaction is done and you have a stock in hand.We assume that the buy price is -infinity
        for(int i=0;i<prices.length;i++){
            p_i10 = Math.max(p_i10,p_i11 + prices[i]); //sell
            p_i11 = Math.max(p_i11,-prices[i]); //buy -> Math.max(p_i11,p_i00-prices[i]) -> p_i00 will be always 0
            p_i20 = Math.max(p_i20,p_i21 + prices[i]); //sell
            p_i21 = Math.max(p_i21,p_i10-prices[i]); //buy
        }
        return p_i20;
    }
}