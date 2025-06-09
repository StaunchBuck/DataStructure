package src.hackerrank.dp;

import java.util.Collections;
import java.util.List;

public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static long getWays(int n, List<Integer> c) {
		Integer[] sums = new Integer[n+1];
	      sums[0]=1;
	      Collections.sort(c);
	      for(Integer coin: c){
	        for(Integer sum=0;sum<=n;sum++){
	          if(coin<=sum){
	            sums[sum] +=sums[sum-coin];
	          }
	        } 
	      }
	      return sums[n];
	}

}
