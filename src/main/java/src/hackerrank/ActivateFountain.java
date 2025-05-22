package src.hackerrank;

public class ActivateFountain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int calculate(int n,int[] arr) {
		if(arr.length == 1)
            return 0;
		
		int[] range = new int[arr.length];
		for (int i = 1; i <= n; i++){
			int l = Math.max(1, i - arr[i-1]);
			int r = Math.min(n, i + arr[i-1]);
			range[l] = Math.max(range[l], r - l);
		}
		int[] dp = new int[range.length];
		for (int i=0;i<range.length;i++)
			dp[i]=range.length;
		
		dp[0] = 0;
        for(int pos=0;pos<range.length;pos++) {
        	if(pos+range[pos] >= range.length-1)
        		return dp[pos]+1;
        	for(int i=pos+1;i<pos+range[pos]+1;i++)
        		dp[i] = Math.min(dp[i],dp[pos]+1);
        }
           
       return 0;  
	}

}
