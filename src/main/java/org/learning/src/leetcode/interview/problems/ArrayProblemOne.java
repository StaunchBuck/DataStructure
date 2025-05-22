package org.learning.src.leetcode.interview.problems;

import java.util.Arrays;

public class ArrayProblemOne {
public static void main(String[] a) {
System.out.println(findClosest(new int[] {1,2,8,4,2,1,3,2,3,9,4,2}, 6));
}

	private static int findClosest(int[] a, int key) {
		Arrays.sort(a);
		for (int i = 0; i < a.length; i++) {
			if (a[i] == key) return a[i];
			if (a[i] > key) return key-a[i-1] <= a[i]-key?a[i - 1]:a[i];
		}
		return 0;
	}
}

//package interview.problems;
//
//import java.util.Arrays;
//
//public class ArrayProblemOne {
//public static void main(String[] a) {
//System.out.println(findClosest(new int[] {1,2,8,4,2,1,3,2,3,9,4,2}, 6));
//}
//private static int findClosest(int[] a, int key) {
//Arrays.sort(a);
//int result = 0;
//for(int i=0;i<a.length;i++){
//  if(a[i] == key){
//	  result = a[i];
//	  break;
//  }
//  if(a[i] > key){
//  	int prevDiff = i-1 >= 0 ?key - a[i-1]:Integer.MAX_VALUE;
//	int nextDiff = a[i] - key;
//	if(prevDiff <= nextDiff){
//	  result = a[i-1];
//	  break;
//	}else{
//	  result = a[i];
//	  break;
//	}
//  }
//}
//return result; //this will chnage as per your logic
//}
//}