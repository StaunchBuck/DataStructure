package src.leetcode.home.tech.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpecialNumbers {

//	public static void main(String[] args) {
//		
//		
//		List<Integer> list = new ArrayList<>();
//		list.add(4);
//		list.add(5);
//		int len = 1;
//
//		// len <= log10(n) - 1
//		while (len <= 5)
//		{
//		    int width = 1 << len;
//		    int size = list.size();
//		    for (int i = 0; i < width; i++)
//		    {
//		        list.add(list.get(size - 1 - i) * 10 + 4);
//		        list.add(list.get(size - 1 - i) * 10 + 5);
//		    }
//
//		    len++;
//		}
//
//	}
	
	public static boolean isGood(int n)
	{
		String str = String.valueOf(n);
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)!='4' && str.charAt(i)!='5')return false;
		}
		return true;
	}
	public static void main(String[] args)
	{
		//Scanner fs = new Scanner(System.in);
		//int n = fs.nextInt();
		int n = 45;
		List<Integer> arr = new ArrayList();
		for(int i=1;i<=n;i++)
		{
			if(isGood(i)==true)
			{
				arr.add(i);
			}
		}
		int[][] dp = new int[arr.size()+1][n+1];//dp
		
		
		for(int col=0;col<dp[0].length;col++)dp[0][col]=Integer.MAX_VALUE;//base case
		for(int row=1;row<dp.length;row++)dp[row][0]=0;//base case
		
		
		//Try optimizing the values at each step
		for(int row=1;row<dp.length;row++)
		{
			for(int col=1;col<dp[0].length;col++)
			{
				if(arr.get(row-1)>col)
				{
					dp[row][col] = dp[row-1][col];
				}
				else if(dp[row][col-arr.get(row-1)]==Integer.MAX_VALUE)
				{
					dp[row][col] = dp[row-1][col];
				}
				else
				{
					dp[row][col] = Math.min(1+dp[row][col-arr.get(row-1)], dp[row-1][col]);
				}
			}
		}
		System.out.println(dp[arr.size()][n]==Integer.MAX_VALUE?-1:dp[arr.size()][n]);
	}

}
