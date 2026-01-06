package src.algorithm.dp;

import java.util.Arrays;

public class MinimumCostOfTicket {

    public static void main(String[] args) {
        MinimumCostOfTicket m = new MinimumCostOfTicket();
        System.out.println(m.mincostTickets(new int[]{1,4,6,7,8,20},new int[]{2,7,15}));
    }
    public int mincostTickets(int[] days, int[] costs) {
        int dp[] = new int[days.length+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        for(int cost=0;cost<costs.length;cost++){
            int day_pass = cost == 0 ? 1 : (cost == 1 ? 7 : 30);
            for(int day=0;day<days.length;day++){
                int back_day=day;
                while(back_day>=0 && days[back_day]>days[day]-day_pass){
                    back_day--;
                }
                // back_day = Math.max(0,back_day);
                dp[day+1] = dp[day+1] == -1 ? dp[back_day+1]+costs[cost] : Math.min(dp[day+1],dp[back_day+1]+costs[cost]);
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[dp.length-1];
    }
}