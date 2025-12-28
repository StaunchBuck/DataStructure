package src.stockseries;


public class BestTimeToBuySellStockTransactionFee  {

    public static void main(String[] args) {
        BestTimeToBuySellStockTransactionFee obj = new BestTimeToBuySellStockTransactionFee();
        int[] prices = {1,3,2,8,4,9};
        int fee = 2;
        System.out.println(obj.maxProfit(prices,fee));
    }
    public int maxProfit(int[] prices, int fee) {
        /*
        //profit[i][k][0] -> profit on ith day with max k transactions having 0 stocks in hand
        int[][][] profit = new int[prices.length][n/2][2];  //k can be from 0 to at most n/2 and stocks in hand can be either 0,1. Here n is the length of the prices array. Since we need to buy and sell stocks , ideally the most transactions that can happeen within this range is n/2 where we consider buy and sell together as 1 transaction.

Here we increase k when we buy a stock. The fee will only be deducted when we purchase a stock.

        for(int i=0;i<prices.length;i++){
            for(int k=0;k<prices.length/2;k++){
                dp[i][k][0] = Math.max(dp[i-1][k][0],dp[i-1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i] - fee); -> Math.max(dp[i-1][k][1],dp[i-1][k][0]-prices[i])
            }
        }

        Now here dp[i-1][k-1][0] can be considered as dp[i-1][k][0] since for k = infinity there is no much difference between k-1 and k.
        This can be further simplified down to below as we see that our ith result only depends on the i-1 day so no need to store rest of the previous days profit in array.
        */

        int p_ik0 = 0; // profit at ith day when k transaction has been done and no stock in hand
        int p_ik1 = Integer.MIN_VALUE; // profit at ith day when k transaction is done and you have a stock in hand.We assume that the buy price is -infinity

        for(int i=0;i<prices.length;i++){
            p_ik0 = Math.max(p_ik0,p_ik1 + prices[i]);
            p_ik1 = Math.max(p_ik1,p_ik0-prices[i] - fee); // Math.max(p_i11,p_i-100-prices[i]); can be simplified to Math.max(p_i11,-prices[i]); as p_i-100 means i-1th days profit when no transaction has been done and nop stock inhand which will always be 0.
        }
        return p_ik0;
    }
}