package src.leetcode.home.tech.problem;

public class MinimumCostOfTickets {
    public static void main(String[] args) {
        int[] days = {1,4,6,7,8,20};
        int[] costs = {2,7,15};
        System.out.println(new MinimumCostOfTickets().mincostTickets(days,costs));
    }

    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length+1];
        dp[0] = 0;
        int day1 = 0; int day7 = 0; int day30 = 0;
        for(int i=0;i<days.length;i++){
            day1 = dp[i]; day7 = i; day30 = i;
            int counter = i;
            while(counter >= 0){
                if(days[counter] > days[i]-7){
                    day7--;
                }
                if(days[counter] > days[i]-30){
                    day30--;
                }else{
                    break;
                }
                counter--;
            }
            day1 += costs[0];
            day7 = day7 == -1 ? costs[1] : dp[day7+1] + costs[1];
            day30 = day30 == -1 ? costs[2] : dp[day30+1] + costs[2];

            dp[i+1] = Math.min(day1,Math.min(day7,day30));
        }
        return dp[dp.length-1];
    }
}
