/*

https://www.spoj.com/problems/PR003004/

Find all the digit sum of numbers between range a and b (inclusive)

1. a = 8 and b = 12
Sum : 23
Explanation:
 8 + 9 + 1 + 0 + 1 + 1 + 1 + 2 = 23
 */

package src.algorithm.digitdp;

public class SumOfAllDigitsBetweenRange {
    private int[][][] dp = new int[1000][2][1000];
    public static void main(String[] args) {
        SumOfAllDigitsBetweenRange s = new SumOfAllDigitsBetweenRange();
        int a = 9;
        int b = 11;
        Integer b_sum = s.digitsSum(b);
        Integer a_sum = s.digitsSum(a-1);
        System.out.println(b_sum-a_sum);
    }

    private Integer digitsSum(int num){
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 1000; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return calculate(0,1,0,""+num);
    }

    private Integer calculate(int index,int tight,int sum,String num){

        if(index>=num.length())
            return sum;
        if(dp[index][tight][sum] != -1)
            return dp[index][tight][sum];
        int limit = tight==1 ? num.charAt(index) -'0' : 9;
        int all_sum=0;
        for(int i=0;i<=limit;i++){
            int newTight = i == limit ? 1 : 0;
            all_sum += calculate(index+1,newTight,sum+i,num);
        }
        dp[index][tight][sum] = all_sum;
        return all_sum;
    }
}
