package src.stockseries;

import java.util.Arrays;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
public class BestTimeToBuyAndSellStockIV {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIV obj = new BestTimeToBuyAndSellStockIV();
        int k = 2;
        int[] prices = new int[]{3,2,6,5,0,3};
        System.out.println(obj.maxProfit(k,prices));
    }
    public int maxProfit(int k,int[] prices) {
        /*
        //profit[i][k][0] -> profit on ith day with max k transactions having 0 stocks in hand
        int[][][] profit = new int[prices.length][n/2][2];  //k can be from 0 to at most n/2 and stocks in hand can be either 0,1. Here n is the length of the prices array. Since we need to buy and sell stocks , ideally the most transactions that can happeen within this range is n/2 where we consider buy and sell together as 1 transaction.

Here we increase k when we buy a stock.

        for(int i=0;i<prices.length;i++){
            for(int k=0;k<prices.length/2;k++){
                dp[i][k][0] = Math.max(dp[i-1][k][0],dp[i-1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i]);
            }
        }

      Now we can have two ranges of k values, when k is less than n/2 or k > n/2. If we have k > n/2 then its similar to k ~ infinity. If less than n/2 then we need to store the profit for each k values
        This can be further simplified down to below.
        */


        // this is the same case where we consider k = infinity
        if(k>prices.length/2){
            int p_ik0=0;
            int p_ik1 = Integer.MIN_VALUE;
            for(int i=0;i<prices.length;i++){
                p_ik0 = Math.max(p_ik0,p_ik1 + prices[i]);
                p_ik1 = Math.max(p_ik1,p_ik0-prices[i]);
            }
            return p_ik0;
        }

        // this is the same case where we consider k < n/2
        int[] p_ik0 = new int[k+1]; //here we store the profits for each transaction number when we have the stock
        int[] p_ik1 = new int[k+1]; //here we store the profits for each transaction number when we dont have the stock
        Arrays.fill(p_ik1, Integer.MIN_VALUE); // filling the initial values with minimum profit when we have the stock

        // here for each stock price we populate the profit values for each number of transaction values.
        for(int price: prices){
            for(int j=1;j<=k;j++){
                p_ik0[j] = Math.max(p_ik0[j],p_ik1[j] + price);
                p_ik1[j] = Math.max(p_ik1[j],p_ik0[j-1]-price);
            }
        }
        return p_ik0[k];
    }
}