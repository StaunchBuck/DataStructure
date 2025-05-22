package org.learning.src.leetcode.home.tech.problem;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SubstringCalculator {

	static Set<String> set = new HashSet<>();
	
	public static void main(String[] args) {
		String s = "abcde";
		ExecutorService executor = Executors.newFixedThreadPool(4);
		
		for(int i = 0;i<s.length();i++) {
			final String sub = s.substring(0,i+1);
			
			executor.execute(()->{
				for(int j =0;j<sub.length();j++) {
					set.add(sub.substring(j,sub.length()));
				}
			});
		}
		System.out.println(set.size());
	}

}
